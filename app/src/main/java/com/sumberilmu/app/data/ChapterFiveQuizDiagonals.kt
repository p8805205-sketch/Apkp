package com.sumberilmu.app.data

object ChapterFiveQuizDiagonals {
    val questions = listOf(
        q(15, "Belah ketupat mempunyai diagonal 12 cm dan 8 cm. Luasnya ...", listOf("40 cm²", "48 cm²", "80 cm²", "96 cm²"), "48 cm²", "Luas = 1/2 × 12 × 8 = 48 cm².", "mudah", 155),
        q(16, "Luas belah ketupat 90 cm². Jika diagonal pertama 15 cm, diagonal kedua adalah ...", listOf("6 cm", "10 cm", "12 cm", "15 cm"), "12 cm", "90 = 1/2 × 15 × d2, sehingga d2 = 12 cm.", "menantang", 155),
        q(17, "Layang-layang mempunyai diagonal 15 cm dan 10 cm. Luasnya ...", listOf("50 cm²", "75 cm²", "125 cm²", "150 cm²"), "75 cm²", "Luas = 1/2 × 15 × 10 = 75 cm².", "mudah", 157)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) = CuratedQuestionFactory.create(5, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
