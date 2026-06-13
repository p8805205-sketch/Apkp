package com.sumberilmu.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress
import com.sumberilmu.app.data.ContentRepository
import com.sumberilmu.app.data.LearningCatalog
import com.sumberilmu.app.data.ProgressRepository
import com.sumberilmu.app.data.QuizAnswer
import com.sumberilmu.app.data.QuizResult
import com.sumberilmu.app.data.QuizSession
import com.sumberilmu.app.domain.ScoreCalculator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class AppScreen {
    DASHBOARD,
    CATALOG,
    CHAPTER,
    QUIZ,
    RESULT
}

data class AppUiState(
    val loading: Boolean = true,
    val errorMessage: String? = null,
    val catalog: LearningCatalog? = null,
    val screen: AppScreen = AppScreen.DASHBOARD,
    val selectedChapterId: String? = null,
    val progress: Map<String, ChapterProgress> = emptyMap(),
    val quizSession: QuizSession? = null,
    val quizResult: QuizResult? = null
) {
    val selectedChapter: Chapter?
        get() = catalog?.chapters?.firstOrNull { it.id == selectedChapterId }
}

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val contentRepository = ContentRepository(application)
    private val progressRepository = ProgressRepository(application)

    private val _uiState = MutableStateFlow(AppUiState())
    val uiState: StateFlow<AppUiState> = _uiState.asStateFlow()

    init {
        loadContent()
    }

    private fun loadContent() {
        runCatching {
            contentRepository.loadCatalog()
        }.onSuccess { catalog ->
            _uiState.value = AppUiState(
                loading = false,
                catalog = catalog,
                progress = progressRepository.load(catalog.chapters.map { it.id })
            )
        }.onFailure { throwable ->
            _uiState.value = AppUiState(
                loading = false,
                errorMessage = throwable.message ?: "Konten tidak dapat dimuat."
            )
        }
    }

    fun showDashboard() {
        _uiState.update {
            it.copy(
                screen = AppScreen.DASHBOARD,
                selectedChapterId = null,
                quizSession = null,
                quizResult = null
            )
        }
    }

    fun showCatalog() {
        _uiState.update {
            it.copy(
                screen = AppScreen.CATALOG,
                quizSession = null,
                quizResult = null
            )
        }
    }

    fun openChapter(chapterId: String) {
        _uiState.update {
            it.copy(
                screen = AppScreen.CHAPTER,
                selectedChapterId = chapterId,
                quizSession = null,
                quizResult = null
            )
        }
    }

    fun markMaterialCompleted(chapterId: String) {
        val current = _uiState.value.progress[chapterId]
            ?: ChapterProgress(chapterId)
        val updated = progressRepository.markMaterialCompleted(current)

        _uiState.update {
            it.copy(progress = it.progress + (chapterId to updated))
        }
    }

    fun startQuiz(chapterId: String) {
        val catalog = _uiState.value.catalog ?: return
        val chapter = catalog.chapters.firstOrNull { it.id == chapterId } ?: return
        val questions = chapter.quiz
            .shuffled()
            .take(catalog.quizQuestionsPerChapter)

        _uiState.update {
            it.copy(
                screen = AppScreen.QUIZ,
                selectedChapterId = chapterId,
                quizSession = QuizSession(
                    chapterId = chapterId,
                    questions = questions
                ),
                quizResult = null
            )
        }
    }

    fun selectAnswer(index: Int) {
        _uiState.update { state ->
            val session = state.quizSession ?: return@update state
            if (session.submitted || index !in session.currentQuestion.options.indices) {
                state
            } else {
                state.copy(quizSession = session.copy(selectedIndex = index))
            }
        }
    }

    fun submitAnswer() {
        _uiState.update { state ->
            val session = state.quizSession ?: return@update state
            val selectedIndex = session.selectedIndex ?: return@update state
            if (session.submitted) return@update state

            val currentQuestion = session.currentQuestion
            val answer = QuizAnswer(
                question = currentQuestion,
                selectedIndex = selectedIndex,
                isCorrect = selectedIndex == currentQuestion.correctIndex
            )

            state.copy(
                quizSession = session.copy(
                    submitted = true,
                    answers = session.answers + answer
                )
            )
        }
    }

    fun nextQuestion() {
        val state = _uiState.value
        val session = state.quizSession ?: return
        if (!session.submitted) return

        if (session.isLastQuestion) {
            finishQuiz(session)
            return
        }

        _uiState.update {
            it.copy(
                quizSession = session.copy(
                    currentIndex = session.currentIndex + 1,
                    selectedIndex = null,
                    submitted = false
                )
            )
        }
    }

    private fun finishQuiz(session: QuizSession) {
        val catalog = _uiState.value.catalog ?: return
        val chapter = catalog.chapters.firstOrNull { it.id == session.chapterId } ?: return
        val correctAnswers = session.answers.count { it.isCorrect }
        val score = ScoreCalculator.percentage(
            correctAnswers = correctAnswers,
            totalQuestions = session.questions.size
        )
        val currentProgress = _uiState.value.progress[chapter.id]
            ?: ChapterProgress(chapter.id)
        val updatedProgress = progressRepository.recordQuiz(currentProgress, score)

        val result = QuizResult(
            chapterId = chapter.id,
            chapterTitle = chapter.title,
            score = score,
            correctAnswers = correctAnswers,
            totalQuestions = session.questions.size,
            passed = score >= catalog.passScore,
            answers = session.answers
        )

        _uiState.update {
            it.copy(
                screen = AppScreen.RESULT,
                progress = it.progress + (chapter.id to updatedProgress),
                quizResult = result
            )
        }
    }

    fun repeatQuiz() {
        _uiState.value.selectedChapterId?.let(::startQuiz)
    }

    fun navigateBack() {
        when (_uiState.value.screen) {
            AppScreen.DASHBOARD -> Unit
            AppScreen.CATALOG -> showDashboard()
            AppScreen.CHAPTER -> showCatalog()
            AppScreen.QUIZ -> {
                _uiState.value.selectedChapterId?.let(::openChapter)
            }
            AppScreen.RESULT -> {
                _uiState.value.selectedChapterId?.let(::openChapter)
            }
        }
    }
}
