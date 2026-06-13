package com.sumberilmu.app.data

object ChapterSixQuizMeasurement {
    val questions = listOf(
        q(10, "Sudut terkecil pada jam pukul 01.00 adalah ...", listOf("30°", "60°", "90°", "120°"), "30°", "Jarak antarangka jam adalah 30°. Pada pukul 01.00 kedua jarum berjarak satu angka, jadi sudutnya 30°.", "mudah", 182),
        q(11, "Sudut terkecil pada jam pukul 08.00 adalah ...", listOf("60°", "90°", "120°", "240°"), "120°", "Selisih posisi jarum adalah delapan interval atau 240°, sehingga sudut terkecilnya 360° - 240° = 120°.", "sedang", 188),
        q(12, "Sudut terkecil pada jam pukul 06.00 adalah ...", listOf("90°", "120°", "180°", "360°"), "180°", "Jarum menit dan jam saling berlawanan arah sehingga membentuk sudut lurus 180°.", "mudah", 188),
        q(13, "Di antara pukul 11.00, 08.00, dan 06.00, sudut terkecil yang paling besar terbentuk pada ...", listOf("Pukul 11.00", "Pukul 08.00", "Pukul 06.00", "Ketiganya sama"), "Pukul 06.00", "Sudutnya berturut-turut 30°, 120°, dan 180°. Yang terbesar adalah 180° pada pukul 06.00.", "sedang", 188),
        q(14, "Sudut terkecil pada jam pukul 10.00 adalah ...", listOf("30°", "60°", "90°", "150°"), "60°", "Jarum berjarak dua interval jam. Setiap interval 30°, jadi sudutnya 60°.", "mudah", 182),
        q(15, "Sudut terkecil pada jam pukul 03.00 adalah ...", listOf("30°", "60°", "90°", "180°"), "90°", "Jarum jam dan menit membentuk seperempat putaran, yaitu 90°.", "mudah", 182),
        q(16, "Sudut terkecil pada jam pukul 04.30 adalah ...", listOf("30°", "45°", "60°", "90°"), "45°", "Pada 04.30 jarum menit berada di 180°, sedangkan jarum jam di 135°. Selisihnya 45°.", "menantang", 182),
        q(17, "Saat mengukur sudut, pusat busur derajat harus diletakkan pada ...", listOf("Titik sudut", "Ujung kaki sudut", "Skala 90°", "Bagian luar sudut"), "Titik sudut", "Pusat busur harus tepat berimpit dengan titik sudut agar pengukuran akurat.", "mudah", 178),
        q(18, "Garis dasar busur derajat harus berimpit dengan ...", listOf("Salah satu kaki sudut", "Kedua kaki sudut sekaligus", "Garis tengah kertas", "Skala 90°"), "Salah satu kaki sudut", "Salah satu kaki sudut dijadikan garis awal 0° pada busur derajat.", "mudah", 178)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(6, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
