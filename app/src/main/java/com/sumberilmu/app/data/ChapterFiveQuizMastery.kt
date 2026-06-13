package com.sumberilmu.app.data

object ChapterFiveQuizMastery {
    val questions = listOf(
        q(22, "Sebuah bangun tersusun dari 22 petak satuan penuh tanpa tumpang tindih. Luas bangun tersebut adalah ...", listOf("18 satuan luas", "20 satuan luas", "22 satuan luas", "24 satuan luas"), "22 satuan luas", "Setiap petak penuh mewakili satu satuan luas. Karena terdapat 22 petak tanpa tumpang tindih, luas totalnya 22 satuan luas.", "menantang", 162),
        q(23, "Sebuah bangun dapat diuraikan menjadi dua bagian dengan luas 12 satuan dan 8 satuan. Luas total bangun tersebut adalah ...", listOf("18 satuan luas", "20 satuan luas", "22 satuan luas", "24 satuan luas"), "20 satuan luas", "Luas total diperoleh dengan menjumlahkan kedua bagian: 12 + 8 = 20 satuan luas.", "menantang", 162),
        q(24, "Semua ukuran berikut berkeliling 60 cm. Ukuran yang menghasilkan luas terbesar adalah ...", listOf("20 cm × 10 cm", "18 cm × 12 cm", "16 cm × 14 cm", "15 cm × 15 cm"), "15 cm × 15 cm", "Untuk jumlah panjang dan lebar tetap, luas terbesar terjadi saat kedua ukuran paling seimbang. 15 × 15 = 225 cm².", "menantang", 160),
        q(25, "Persegi panjang 20 cm × 10 cm dan 18 cm × 12 cm sama-sama berkeliling 60 cm. Selisih luas keduanya ...", listOf("8 cm²", "12 cm²", "16 cm²", "24 cm²"), "16 cm²", "Luasnya 200 cm² dan 216 cm². Selisihnya 16 cm².", "sedang", 160)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) = CuratedQuestionFactory.create(5, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
