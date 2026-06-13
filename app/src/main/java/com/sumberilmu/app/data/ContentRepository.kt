package com.sumberilmu.app.data

import android.content.Context

class ContentRepository(@Suppress("UNUSED_PARAMETER") context: Context) {
    fun loadCatalog(): LearningCatalog {
        val base = GeneratedContent.catalog
        val chapters = base.chapters.map { chapter ->
            when (chapter.id) {
                CuratedChapterOne.chapter.id -> CuratedChapterOne.chapter
                CuratedChapterTwo.chapter.id -> CuratedChapterTwo.chapter
                CuratedChapterThree.chapter.id -> CuratedChapterThree.chapter
                CuratedChapterFour.chapter.id -> CuratedChapterFour.chapter
                else -> chapter
            }
        }
        return base.copy(chapters = chapters)
    }
}
