package com.sumberilmu.app.data

object ChapterSevenQuizComparisons {
    val questions = listOf(
        q(20, "Banyak sumbu simetri pada persegi adalah ...", listOf("4", "2", "1", "0"), "4", "Persegi mempunyai dua sumbu melalui titik tengah sisi dan dua sumbu melalui diagonal.", "mudah", 224),
        q(21, "Banyak sumbu simetri pada persegi panjang yang bukan persegi adalah ...", listOf("2", "4", "1", "0"), "2", "Sumbunya melalui titik tengah pasangan sisi yang berhadapan secara horizontal dan vertikal.", "mudah", 224),
        q(22, "Apakah setiap persegi juga merupakan persegi panjang?", listOf("Ya, karena mempunyai empat sudut siku-siku dan sisi berhadapan sejajar", "Tidak, karena semua sisinya sama panjang", "Tidak, karena persegi tidak mempunyai diagonal", "Ya, karena hanya mempunyai satu pasang sisi sejajar"), "Ya, karena mempunyai empat sudut siku-siku dan sisi berhadapan sejajar", "Persegi memenuhi semua ciri persegi panjang, lalu memiliki sifat tambahan berupa empat sisi sama panjang.", "menantang", 228),
        q(23, "Apakah setiap persegi panjang merupakan persegi?", listOf("Tidak, karena sisi yang berdekatan belum tentu sama panjang", "Ya, karena mempunyai empat sudut siku-siku", "Ya, karena mempunyai dua diagonal", "Tidak, karena tidak mempunyai sisi sejajar"), "Tidak, karena sisi yang berdekatan belum tentu sama panjang", "Persegi menuntut keempat sisi sama panjang, sedangkan persegi panjang hanya menjamin sisi berhadapan sama panjang.", "menantang", 228),
        q(24, "Persamaan utama persegi dan belah ketupat adalah ...", listOf("Keduanya mempunyai empat sisi sama panjang", "Keduanya selalu mempunyai empat sudut siku-siku", "Keduanya hanya mempunyai satu sumbu simetri", "Keduanya tidak mempunyai sisi sejajar"), "Keduanya mempunyai empat sisi sama panjang", "Perbedaannya, sudut belah ketupat tidak harus siku-siku, sedangkan semua sudut persegi siku-siku.", "sedang", 230),
        q(25, "Persamaan persegi dan persegi panjang adalah ...", listOf("Empat sudut siku-siku dan dua pasang sisi sejajar", "Empat sisi selalu sama panjang", "Diagonal selalu saling tegak lurus", "Hanya satu pasang sisi sejajar"), "Empat sudut siku-siku dan dua pasang sisi sejajar", "Keduanya memiliki empat sudut 90°, sisi berhadapan sejajar, serta diagonal sama panjang dan saling membagi dua.", "sedang", 232)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(7, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
