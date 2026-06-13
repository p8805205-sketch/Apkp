package com.sumberilmu.app.data

object ChapterEightQuizBars {
    val questions = listOf(
        q(15, "Indonesia memperoleh medali emas paling banyak pada Sea Games tahun ...", listOf("2019", "2021", "2013", "2017"), "2019", "Data medali emas adalah 65, 47, 38, 72, dan 69. Nilai tertinggi 72 terjadi pada 2019.", "mudah", 255),
        q(16, "Perolehan medali emas paling sedikit terjadi pada tahun ...", listOf("2017", "2015", "2013", "2021"), "2017", "Nilai terendah pada tabel adalah 38 medali pada 2017.", "mudah", 255),
        q(17, "Penurunan medali emas dari 2013 ke 2015 adalah ...", listOf("18 medali", "9 medali", "22 medali", "31 medali"), "18 medali", "Perolehan turun dari 65 menjadi 47, sehingga penurunannya 65 - 47 = 18.", "sedang", 256),
        q(18, "Pada 2019 Indonesia memperoleh 72 emas, 84 perak, dan 111 perunggu. Pecahan emas dari seluruh medali dalam bentuk paling sederhana adalah ...", listOf("24/89", "72/195", "8/29", "24/65"), "24/89", "Total medali 72 + 84 + 111 = 267. Pecahan 72/267 disederhanakan dengan membagi 3 menjadi 24/89.", "menantang", 257),
        q(19, "Berdasarkan diagram panen lele, hasil Kolam 2 dan Kolam 4 berturut-turut adalah ...", listOf("28 kg dan 16 kg", "30 kg dan 20 kg", "25 kg dan 18 kg", "32 kg dan 21 kg"), "28 kg dan 16 kg", "Ujung batang Kolam 2 berada pada 28 kg dan Kolam 4 pada 16 kg.", "sedang", 260),
        q(20, "Total hasil panen lele dari lima kolam adalah ...", listOf("122 kg", "112 kg", "132 kg", "102 kg"), "122 kg", "Jumlahkan 32 + 28 + 21 + 16 + 25 = 122 kg.", "sedang", 261),
        q(21, "Jika seluruh 122 kg lele dijual Rp22.000,00 per kg, pendapatannya adalah ...", listOf("Rp2.684.000,00", "Rp2.440.000,00", "Rp2.860.000,00", "Rp3.684.000,00"), "Rp2.684.000,00", "Pendapatan = 122 × Rp22.000,00 = Rp2.684.000,00.", "menantang", 261)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(8, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
