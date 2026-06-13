package com.sumberilmu.app.data

object ChapterNineQuizCompareA {
    val questions = listOf(
        q(11, "Hubungan 445.000 dan 545.000 adalah ...", listOf("445.000 < 545.000", "445.000 > 545.000", "445.000 = 545.000", "445.000 + 545.000"), "445.000 < 545.000", "Angka ratus ribu 4 lebih kecil dari 5.", "mudah", 287),
        q(12, "Hubungan 876.000 dan 867.000 adalah ...", listOf("876.000 > 867.000", "876.000 < 867.000", "876.000 = 867.000", "876.000 - 867.000"), "876.000 > 867.000", "Ratus ribunya sama, tetapi puluh ribu 7 lebih besar dari 6.", "mudah", 287),
        q(13, "Hubungan 126.789 dan 126.789 adalah ...", listOf("=", ">", "<", "Tidak dapat dibandingkan"), "=", "Semua digit pada kedua bilangan sama.", "mudah", 287),
        q(14, "Urutan harga sepatu dari termahal adalah ...", listOf("Lukas, Komang, Nisa", "Komang, Lukas, Nisa", "Nisa, Komang, Lukas", "Lukas, Nisa, Komang"), "Lukas, Komang, Nisa", "Rp432.543 > Rp342.231 > Rp232.231.", "sedang", 285),
        q(15, "Kunjungan wisatawan mancanegara paling sedikit terjadi pada tahun ...", listOf("2020", "2016", "2018", "2019"), "2020", "Nilai tahun 2020 adalah 69.968, paling kecil pada grafik.", "mudah", 286)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(9, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
