package com.sumberilmu.app.data

import android.content.Context

class ContentRepository(@Suppress("UNUSED_PARAMETER") context: Context) {
    fun loadCatalog(): LearningCatalog = GeneratedContent.catalog
}
