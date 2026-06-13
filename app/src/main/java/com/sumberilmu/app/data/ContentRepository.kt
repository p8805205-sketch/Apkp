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
                CuratedChapterFour.chapter.id -> auditedChapterFour()
                CuratedChapterFive.chapter.id -> CuratedChapterFive.chapter
                CuratedChapterSix.chapter.id -> CuratedChapterSix.chapter
                CuratedChapterSeven.chapter.id -> CuratedChapterSeven.chapter
                CuratedChapterEight.chapter.id -> CuratedChapterEight.chapter
                CuratedChapterNine.chapter.id -> CuratedChapterNine.chapter
                else -> chapter
            }
        }
        return base.copy(chapters = chapters)
    }

    private fun auditedChapterFour(): Chapter {
        val sourceNote = "Catatan penting: rumus 4 × sisi hanya berlaku jika keempat sisi sama panjang. Trapesium dan segi empat sembarang harus dihitung dengan menjumlahkan semua sisinya."
        return CuratedChapterFour.chapter.copy(
            summary = CuratedChapterFour.chapter.summary + sourceNote,
            subchapters = CuratedChapterFour.chapter.subchapters.map { subchapter ->
                if (subchapter.title == "Keliling Segi Empat Lainnya") {
                    subchapter.copy(explanation = subchapter.explanation + sourceNote)
                } else {
                    subchapter
                }
            }
        )
    }
}
