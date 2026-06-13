package com.sumberilmu.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

@Composable
fun PlaceValueEnhancedChapterScreen(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    contentPadding: PaddingValues,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit
) {
    CollapsibleLabChapterScreen(
        chapter = chapter,
        chapterProgress = chapterProgress,
        passScore = passScore,
        contentPadding = contentPadding,
        labTitle = "Laboratorium Nilai Tempat",
        collapsedSubtitle = "Ketuk untuk membuka alat susun dan banding bilangan",
        expandedSubtitle = "Ketuk untuk menutup dan kembali ke materi",
        labIcon = "123",
        onMarkCompleted = onMarkCompleted,
        onStartQuiz = onStartQuiz,
        labContent = { accent ->
            PlaceValueLearningShowcase(accent = accent)
        }
    )
}
