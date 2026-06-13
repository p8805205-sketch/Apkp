package com.sumberilmu.app.data

data class LearningCatalog(
    val appName: String,
    val curriculum: String,
    val level: String,
    val grade: String,
    val subject: String,
    val semester: String,
    val passScore: Int,
    val quizQuestionsPerChapter: Int,
    val source: ContentSource,
    val chapters: List<Chapter>
)

data class ContentSource(
    val title: String,
    val publisher: String,
    val year: Int,
    val isbn: String,
    val note: String
)

data class Chapter(
    val id: String,
    val number: Int,
    val title: String,
    val sourcePageStart: Int,
    val sourcePageEnd: Int,
    val objective: String,
    val keywords: List<String>,
    val summary: List<String>,
    val subchapters: List<Subchapter>,
    val quiz: List<Question>
)

data class Subchapter(
    val title: String,
    val explanation: List<String>,
    val example: WorkedExample
)

data class WorkedExample(
    val question: String,
    val steps: List<String>,
    val answer: String
)

data class Question(
    val id: String,
    val prompt: String,
    val options: List<QuestionOption>,
    val correctIndex: Int,
    val explanation: String,
    val difficulty: String,
    val sourcePage: Int
)

data class QuestionOption(
    val text: String,
    val explanation: String
)

data class ChapterProgress(
    val chapterId: String,
    val materialCompleted: Boolean = false,
    val attempts: Int = 0,
    val bestScore: Int = 0,
    val lastScore: Int = 0
) {
    fun isMastered(passScore: Int): Boolean = materialCompleted && bestScore >= passScore
}

data class QuizAnswer(
    val question: Question,
    val selectedIndex: Int,
    val isCorrect: Boolean
)

data class QuizSession(
    val chapterId: String,
    val questions: List<Question>,
    val currentIndex: Int = 0,
    val selectedIndex: Int? = null,
    val submitted: Boolean = false,
    val answers: List<QuizAnswer> = emptyList()
) {
    val currentQuestion: Question get() = questions[currentIndex]
    val isLastQuestion: Boolean get() = currentIndex == questions.lastIndex
}

data class QuizResult(
    val chapterId: String,
    val chapterTitle: String,
    val score: Int,
    val correctAnswers: Int,
    val totalQuestions: Int,
    val passed: Boolean,
    val answers: List<QuizAnswer>
)
