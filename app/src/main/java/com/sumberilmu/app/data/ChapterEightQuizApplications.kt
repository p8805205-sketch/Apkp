package com.sumberilmu.app.data

object ChapterEightQuizApplications {
    val questions = listOf(
        q(22, "Pada 2019 terdapat 16 siswa laki-laki dan 12 siswa perempuan. Selisihnya adalah ...", listOf("4 siswa", "2 siswa", "6 siswa", "28 siswa"), "4 siswa", "Selisih = 16 - 12 = 4 siswa.", "mudah", 264),
        q(23, "Pengunjung perpustakaan turun dari 36 orang pada Kamis menjadi 24 orang pada Jumat. Besar penurunannya ...", listOf("12 orang", "10 orang", "18 orang", "24 orang"), "12 orang", "Penurunan = 36 - 24 = 12 orang.", "sedang", 269),
        q(24, "Tabungan Nisa selama lima minggu adalah Rp17.000, Rp24.000, Rp21.000, Rp18.000, dan Rp23.000. Untuk membeli alat gambar Rp150.000, hasil tabungannya ...", listOf("Rp103.000 dan masih kurang Rp47.000", "Rp103.000 dan lebih Rp47.000", "Rp93.000 dan masih kurang Rp57.000", "Rp113.000 dan masih kurang Rp37.000"), "Rp103.000 dan masih kurang Rp47.000", "Total tabungan = 17.000 + 24.000 + 21.000 + 18.000 + 23.000 = Rp103.000. Kekurangan = Rp150.000 - Rp103.000 = Rp47.000.", "menantang", 270),
        q(25, "Total persentase pengguna internet usia 18–24 tahun adalah 30,7% dan usia 25–34 tahun 34,1%. Selisihnya ...", listOf("3,4 poin persentase", "4,4 poin persentase", "2,4 poin persentase", "64,8 poin persentase"), "3,4 poin persentase", "Selisih = 34,1% - 30,7% = 3,4 poin persentase.", "menantang", 272)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(8, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
