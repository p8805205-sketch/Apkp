package com.sumberilmu.app.data

import android.content.Context

class ContentRepository(@Suppress("UNUSED_PARAMETER") context: Context) {
    fun loadCatalog(): LearningCatalog {
        val base = GeneratedContent.catalog
        val chapters = base.chapters.map { chapter ->
            if (chapter.id == CuratedChapterOne.chapter.id) {
                CuratedChapterOne.chapter
            } else {
                chapter
            }
        }
        return base.copy(chapters = chapters)
    }
}
