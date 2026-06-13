package com.sumberilmu.app.data

object ChapterFourQuizShapes {
    val questions = listOf(
        q(8, "Belah ketupat memiliki panjang sisi 13 cm. Kelilingnya ...", listOf("26 cm", "39 cm", "52 cm", "169 cm"), "52 cm", "Keempat sisi sama panjang, sehingga 4 × 13 = 52 cm.", "mudah", 120),
        q(9, "Pada Uji Kompetensi, layang-layang mempunyai dua sisi 6 cm dan dua sisi 4 cm. Kelilingnya ...", listOf("10 cm", "20 cm", "24 cm", "48 cm"), "20 cm", "Keliling = 2 × 6 + 2 × 4 = 20 cm.", "sedang", 130),
        q(10, "Sisi trapesium adalah 12 cm, 8 cm, 6 cm, dan 5 cm. Kelilingnya ...", listOf("26 cm", "31 cm", "36 cm", "48 cm"), "31 cm", "Jumlahkan seluruh sisi: 12 + 8 + 6 + 5 = 31 cm.", "mudah", 121),
        q(11, "Segi lima beraturan mempunyai sisi 7 cm. Kelilingnya ...", listOf("28 cm", "35 cm", "42 cm", "49 cm"), "35 cm", "Keliling = 5 × 7 = 35 cm.", "mudah", 122),
        q(12, "Pada Uji Kompetensi, segi delapan beraturan mempunyai sisi 10 cm. Kelilingnya ...", listOf("40 cm", "60 cm", "80 cm", "100 cm"), "80 cm", "Keliling = 8 × 10 = 80 cm.", "mudah", 130),
        q(13, "Keliling sebuah persegi 48 cm. Panjang satu sisinya ...", listOf("8 cm", "10 cm", "12 cm", "16 cm"), "12 cm", "Panjang sisi = 48 ÷ 4 = 12 cm.", "sedang", 120)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) = CuratedQuestionFactory.create(4, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
