package com.sumberilmu.app.data

object ChapterFourQuizApplications {
    val questions = listOf(
        q(14, "Keliling persegi panjang 50 cm. Jika panjangnya 16 cm, lebarnya ...", listOf("7 cm", "8 cm", "9 cm", "18 cm"), "9 cm", "Setengah keliling 25 cm, sehingga lebar = 25 - 16 = 9 cm.", "sedang", 119),
        q(15, "Taman segitiga memiliki sisi 15 m, 12 m, dan 9 m. Panjang pagar ...", listOf("27 m", "30 m", "36 m", "45 m"), "36 m", "Panjang pagar = 15 + 12 + 9 = 36 m.", "mudah", 113),
        q(16, "Foto berukuran 18 cm × 13 cm diberi pita pada seluruh tepinya. Panjang pita ...", listOf("31 cm", "49 cm", "62 cm", "234 cm"), "62 cm", "Keliling = 2 × (18 + 13) = 62 cm.", "mudah", 108),
        q(17, "Lapangan persegi bersisi 25 m dipagari, tetapi pintu 2 m tidak dipagari. Panjang pagar ...", listOf("96 m", "98 m", "100 m", "102 m"), "98 m", "Keliling 100 m dikurangi pintu 2 m menjadi 98 m.", "sedang", 108),
        q(18, "Pelari mengelilingi lapangan 40 m × 25 m sebanyak 3 putaran. Jaraknya ...", listOf("130 m", "195 m", "390 m", "3.000 m"), "390 m", "Satu putaran 130 m, sehingga tiga putaran 390 m.", "sedang", 113),
        q(19, "Persegi sisi 4 cm ditempel pada persegi panjang 10 cm × 6 cm dengan sisi berhimpit 4 cm. Keliling gabungan ...", listOf("40 cm", "44 cm", "48 cm", "56 cm"), "40 cm", "Jumlah keliling 48 cm dikurangi dua kali sisi berhimpit 8 cm menjadi 40 cm.", "menantang", 125)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) = CuratedQuestionFactory.create(4, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
