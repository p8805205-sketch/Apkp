package com.sumberilmu.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sumberilmu.app.AppScreen
import com.sumberilmu.app.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SumberIlmuApp(viewModel: AppViewModel) {
    val state by viewModel.uiState.collectAsState()

    BackHandler(enabled = state.screen != AppScreen.DASHBOARD) {
        viewModel.navigateBack()
    }

    if (state.loading) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    state.errorMessage?.let { message ->
        ErrorScreen(message)
        return
    }

    val title = when (state.screen) {
        AppScreen.DASHBOARD -> state.catalog?.appName.orEmpty()
        AppScreen.CATALOG -> "Katalog Belajar"
        AppScreen.CHAPTER -> "Materi Bab"
        AppScreen.QUIZ -> "Quiz Bab"
        AppScreen.RESULT -> "Hasil Quiz"
    }
    val showBack = state.screen !in setOf(AppScreen.DASHBOARD, AppScreen.CATALOG)
    val showBottomBar = state.screen in setOf(AppScreen.DASHBOARD, AppScreen.CATALOG)

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    if (showBack) {
                        IconButton(onClick = viewModel::navigateBack) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Kembali")
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    NavigationBarItem(
                        selected = state.screen == AppScreen.DASHBOARD,
                        onClick = viewModel::showDashboard,
                        icon = { Icon(Icons.Default.Home, contentDescription = null) },
                        label = { Text("Beranda") }
                    )
                    NavigationBarItem(
                        selected = state.screen == AppScreen.CATALOG,
                        onClick = viewModel::showCatalog,
                        icon = { Icon(Icons.Default.MenuBook, contentDescription = null) },
                        label = { Text("Materi") }
                    )
                }
            }
        }
    ) { paddingValues ->
        val catalog = requireNotNull(state.catalog)
        when (state.screen) {
            AppScreen.DASHBOARD -> DashboardScreen(
                catalog = catalog,
                progress = state.progress,
                contentPadding = paddingValues,
                onOpenCatalog = viewModel::showCatalog,
                onOpenChapter = viewModel::openChapter
            )

            AppScreen.CATALOG -> CatalogScreen(
                catalog = catalog,
                progress = state.progress,
                contentPadding = paddingValues,
                onOpenChapter = viewModel::openChapter
            )

            AppScreen.CHAPTER -> {
                val chapter = state.selectedChapter ?: return@Scaffold
                ChapterScreen(
                    chapter = chapter,
                    chapterProgress = state.progress[chapter.id],
                    passScore = catalog.passScore,
                    contentPadding = paddingValues,
                    onMarkCompleted = { viewModel.markMaterialCompleted(chapter.id) },
                    onStartQuiz = { viewModel.startQuiz(chapter.id) }
                )
            }

            AppScreen.QUIZ -> {
                val session = state.quizSession ?: return@Scaffold
                QuizScreen(
                    session = session,
                    contentPadding = paddingValues,
                    onSelectAnswer = viewModel::selectAnswer,
                    onSubmitAnswer = viewModel::submitAnswer,
                    onNext = viewModel::nextQuestion
                )
            }

            AppScreen.RESULT -> {
                val result = state.quizResult ?: return@Scaffold
                ResultScreen(
                    result = result,
                    passScore = catalog.passScore,
                    contentPadding = paddingValues,
                    onRepeat = viewModel::repeatQuiz,
                    onBackToChapter = {
                        viewModel.openChapter(result.chapterId)
                    },
                    onDashboard = viewModel::showDashboard
                )
            }
        }
    }
}
