package com.sumberilmu.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
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
    CollapsibleLabChapterScreen(
        chapter = chapter,
        chapterProgress = chapterProgress,
        passScore = passScore,
        contentPadding = contentPadding,
        labTitle = "Laboratorium Data",
        collapsedSubtitle = "Ketuk untuk membuka tabel dan diagram interaktif",
        expandedSubtitle = "Ketuk untuk menutup dan kembali ke materi",
        labIcon = "▥",
        onMarkCompleted = onMarkCompleted,
        onStartQuiz = onStartQuiz,
        labContent = { accent ->
            DataLearningShowcase(accent = accent)
        }
    )
}
