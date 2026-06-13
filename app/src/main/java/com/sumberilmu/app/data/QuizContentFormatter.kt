package com.sumberilmu.app.data

private const val COMPLETION_INSTRUCTION =
    "Pilih jawaban yang paling tepat untuk melengkapi bagian kosong."

object QuizContentFormatter {
    fun formatChapter(chapter: Chapter): Chapter = chapter.copy(
        quiz = chapter.quiz.map(::formatQuestion)
    )

    fun formatQuestion(question: Question): Question = question.copy(
        prompt = completePrompt(question.prompt)
    )

    fun completePrompt(rawPrompt: String): String {
        val prompt = rawPrompt.trim()
        if (!containsBlankMarker(prompt)) {
            return ensureEndingPunctuation(prompt)
        }

        val completedBody = prompt
            .replace("...", "_____")
            .replace("…", "_____")
            .let(::ensureEndingPunctuation)

        return "$COMPLETION_INSTRUCTION\n$completedBody"
    }

    private fun containsBlankMarker(prompt: String): Boolean =
        "..." in prompt || "…" in prompt

    private fun ensureEndingPunctuation(prompt: String): String = when {
        prompt.isBlank() -> prompt
        prompt.endsWith("?") || prompt.endsWith("!") || prompt.endsWith(".") -> prompt
        else -> "$prompt."
    }
}
