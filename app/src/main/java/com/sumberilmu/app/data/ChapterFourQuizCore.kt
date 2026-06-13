package com.sumberilmu.app.data

object ChapterFourQuizCore {
    val questions = listOf(
        q(1, "Keliling sebuah bangun datar adalah ...", listOf("Jumlah panjang seluruh sisi pada batas bangun", "Banyaknya titik sudut bangun", "Daerah yang tertutup oleh bangun", "Panjang satu sisi terpendek"), "Jumlah panjang seluruh sisi pada batas bangun", "Keliling merupakan total panjang lintasan yang mengelilingi batas terluar bangun.", "mudah", 113),
        q(2, "Sebuah persegi memiliki panjang sisi 8 cm. Kelilingnya ...", listOf("16 cm", "24 cm", "32 cm", "64 cm"), "32 cm", "Keliling persegi = 4 × 8 = 32 cm.", "mudah", 120),
        q(3, "Persegi panjang dengan panjang 12 cm dan lebar 7 cm memiliki keliling ...", listOf("19 cm", "38 cm", "84 cm", "48 cm"), "38 cm", "Keliling = 2 × (12 + 7) = 38 cm.", "mudah", 119),
        q(4, "Sisi segitiga adalah 8 cm, 7 cm, dan 5 cm. Kelilingnya ...", listOf("18 cm", "20 cm", "28 cm", "35 cm"), "20 cm", "Jumlahkan 8 + 7 + 5 = 20 cm.", "mudah", 115),
        q(5, "Pada Uji Kompetensi, segitiga sama sisi mempunyai sisi 8 cm. Kelilingnya ...", listOf("16 cm", "24 cm", "32 cm", "64 cm"), "24 cm", "Keliling = 3 × 8 = 24 cm.", "mudah", 130),
        q(6, "Segitiga sama kaki mempunyai dua sisi 10 cm dan alas 6 cm. Kelilingnya ...", listOf("16 cm", "20 cm", "26 cm", "36 cm"), "26 cm", "Keliling = 10 + 10 + 6 = 26 cm.", "mudah", 116),
        q(7, "Jajargenjang memiliki sisi berdekatan 14 cm dan 9 cm. Kelilingnya ...", listOf("23 cm", "36 cm", "46 cm", "126 cm"), "46 cm", "Keliling = 2 × (14 + 9) = 46 cm.", "sedang", 119)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) = CuratedQuestionFactory.create(4, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
