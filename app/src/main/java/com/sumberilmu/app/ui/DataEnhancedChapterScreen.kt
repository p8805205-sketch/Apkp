package com.sumberilmu.app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.weight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

@Composable
fun DataEnhancedChapterScreen(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    contentPadding: PaddingValues,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit
) {
    val accent = chapterAccent(chapter.number)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        Box(modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp)) {
            DataLearningShowcase(accent = accent)
        }
        Box(modifier = Modifier.weight(1f)) {
            ChapterScreen(
                chapter = chapter,
                chapterProgress = chapterProgress,
                passScore = passScore,
                contentPadding = PaddingValues(0.dp),
                onMarkCompleted = onMarkCompleted,
                onStartQuiz = onStartQuiz
            )
        }
    }
}
