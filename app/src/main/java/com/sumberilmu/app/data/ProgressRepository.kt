package com.sumberilmu.app.data

import android.content.Context
import org.json.JSONObject

class ProgressRepository(context: Context) {

    private val preferences = context.getSharedPreferences(
        "sumber_ilmu_progress",
        Context.MODE_PRIVATE
    )

    fun load(chapterIds: List<String>): Map<String, ChapterProgress> =
        chapterIds.associateWith { chapterId ->
            val objectValue = preferences.getString(chapterId, null)
                ?.let(::JSONObject)

            ChapterProgress(
                chapterId = chapterId,
                materialCompleted = objectValue?.optBoolean("materialCompleted") ?: false,
                attempts = objectValue?.optInt("attempts") ?: 0,
                bestScore = objectValue?.optInt("bestScore") ?: 0,
                lastScore = objectValue?.optInt("lastScore") ?: 0
            )
        }

    fun markMaterialCompleted(current: ChapterProgress): ChapterProgress {
        val updated = current.copy(materialCompleted = true)
        save(updated)
        return updated
    }

    fun recordQuiz(current: ChapterProgress, score: Int): ChapterProgress {
        val updated = current.copy(
            attempts = current.attempts + 1,
            bestScore = maxOf(current.bestScore, score),
            lastScore = score
        )
        save(updated)
        return updated
    }

    private fun save(progress: ChapterProgress) {
        val json = JSONObject()
            .put("materialCompleted", progress.materialCompleted)
            .put("attempts", progress.attempts)
            .put("bestScore", progress.bestScore)
            .put("lastScore", progress.lastScore)

        preferences.edit()
            .putString(progress.chapterId, json.toString())
            .apply()
    }
}
