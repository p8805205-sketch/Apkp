package com.sumberilmu.app.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
        LoadingScreen()
        return
    }

    state.errorMessage?.let { message ->
        ErrorScreen(message)
        return
    }

    val catalog = requireNotNull(state.catalog)
    val title = when (state.screen) {
        AppScreen.DASHBOARD -> catalog.appName
        AppScreen.CATALOG -> "Katalog Belajar"
        AppScreen.CHAPTER -> state.selectedChapter?.let { "Bab ${it.number}" } ?: "Materi Bab"
        AppScreen.QUIZ -> "Quiz Bab"
        AppScreen.RESULT -> "Hasil Quiz"
    }
    val showBack = state.screen !in setOf(AppScreen.DASHBOARD, AppScreen.CATALOG)
    val showBottomBar = state.screen in setOf(AppScreen.DASHBOARD, AppScreen.CATALOG)
    val showLearningPath = state.screen in setOf(AppScreen.CATALOG, AppScreen.CHAPTER)

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        if (showBack) {
                            IconButton(onClick = viewModel::navigateBack) {
                                Icon(Icons.Rounded.ArrowBack, contentDescription = "Kembali")
                            }
                        } else {
                            IconButton(onClick = viewModel::showDashboard) {
                                Box(
                                    modifier = Modifier
                                        .size(36.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(
                                            Brush.linearGradient(
                                                listOf(BrandIndigo, BrandViolet)
                                            )
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        Icons.Rounded.School,
                                        contentDescription = "Sumber Ilmu",
                                        tint = Color.White,
                                        modifier = Modifier.size(21.dp)
                                    )
                                }
                            }
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.onBackground,
                        navigationIconContentColor = MaterialTheme.colorScheme.onBackground
                    )
                )
                if (showLearningPath) {
                    LearningPathStrip(
                        catalog = catalog,
                        selectedChapterNumber = state.selectedChapter?.number
                    )
                }
            }
        },
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 4.dp
                ) {
                    NavigationBarItem(
                        selected = state.screen == AppScreen.DASHBOARD,
                        onClick = viewModel::showDashboard,
                        icon = {
                            Icon(
                                Icons.Rounded.Home,
                                contentDescription = "Beranda"
                            )
                        },
                        label = { Text("Beranda") }
                    )
                    NavigationBarItem(
                        selected = state.screen == AppScreen.CATALOG,
                        onClick = viewModel::showCatalog,
                        icon = {
                            Icon(
                                Icons.Rounded.AutoStories,
                                contentDescription = "Materi"
                            )
                        },
                        label = { Text("Materi") }
                    )
                }
            }
        }
    ) { paddingValues ->
        when (state.screen) {
            AppScreen.DASHBOARD -> DashboardScreen(
                catalog = catalog,
                progress = state.progress,
                contentPadding = paddingValues,
                onOpenCatalog = viewModel::showCatalog,
                onOpenChapter = viewModel::openChapter
            )

            AppScreen.CATALOG -> ReferenceInspiredCatalogScreen(
                catalog = catalog,
                progress = state.progress,
                contentPadding = paddingValues,
                onOpenChapter = viewModel::openChapter
            )

            AppScreen.CHAPTER -> {
                val chapter = state.selectedChapter ?: return@Scaffold
                when (chapter.number) {
                    6 -> AngleEnhancedChapterScreen(
                        chapter = chapter,
                        chapterProgress = state.progress[chapter.id],
                        passScore = catalog.passScore,
                        contentPadding = paddingValues,
                        onMarkCompleted = { viewModel.markMaterialCompleted(chapter.id) },
                        onStartQuiz = { viewModel.startQuiz(chapter.id) }
                    )
                    7 -> ShapeEnhancedChapterScreen(
                        chapter = chapter,
                        chapterProgress = state.progress[chapter.id],
                        passScore = catalog.passScore,
                        contentPadding = paddingValues,
                        onMarkCompleted = { viewModel.markMaterialCompleted(chapter.id) },
                        onStartQuiz = { viewModel.startQuiz(chapter.id) }
                    )
                    8 -> DataEnhancedChapterScreen(
                        chapter = chapter,
                        chapterProgress = state.progress[chapter.id],
                        passScore = catalog.passScore,
                        contentPadding = paddingValues,
                        onMarkCompleted = { viewModel.markMaterialCompleted(chapter.id) },
                        onStartQuiz = { viewModel.startQuiz(chapter.id) }
                    )
                    else -> ChapterScreen(
                        chapter = chapter,
                        chapterProgress = state.progress[chapter.id],
                        passScore = catalog.passScore,
                        contentPadding = paddingValues,
                        onMarkCompleted = { viewModel.markMaterialCompleted(chapter.id) },
                        onStartQuiz = { viewModel.startQuiz(chapter.id) }
                    )
                }
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

@Composable
private fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(RoundedCornerShape(22.dp))
                    .background(
                        Brush.linearGradient(
                            listOf(BrandIndigo, BrandViolet, BrandBlue)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Rounded.School,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(36.dp)
                )
            }
            Spacer(Modifier.height(18.dp))
            Text(
                "Sumber Ilmu",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(12.dp))
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 3.dp,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}
