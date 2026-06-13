package com.sumberilmu.app.data

object CuratedQuestionFactory {
    fun create(
        chapterNumber: Int,
        id: Int,
        prompt: String,
        options: List<String>,
        correct: String,
        explanation: String,
        difficulty: String,
        sourcePage: Int
    ): Question {
        require(options.size == 4)
        require(options.toSet().size == 4)
        val correctIndex = options.indexOf(correct)
        require(correctIndex >= 0)
        return Question(
            id = "bab-$chapterNumber-soal-$id",
            prompt = prompt,
            options = options.mapIndexed { index, value ->
                QuestionOption(
                    text = value,
                    explanation = if (index == correctIndex) "Tepat. $explanation" else "Belum tepat. $explanation"
                )
            },
            correctIndex = correctIndex,
            explanation = explanation,
            difficulty = difficulty,
            sourcePage = sourcePage
        )
    }
}
