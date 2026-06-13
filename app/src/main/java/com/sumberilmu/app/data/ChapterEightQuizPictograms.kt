package com.sumberilmu.app.data

object ChapterEightQuizPictograms {
    val questions = listOf(
        q(9, "Piktogram adalah penyajian data menggunakan ...", listOf("Gambar atau simbol yang mewakili nilai tertentu", "Kalimat panjang tanpa angka", "Hanya garis lurus vertikal", "Rumus perkalian"), "Gambar atau simbol yang mewakili nilai tertentu", "Pada piktogram, setiap gambar atau simbol memiliki nilai yang dijelaskan pada keterangan.", "mudah", 251),
        q(10, "Jika satu simbol mewakili 4 kue, setengah simbol mewakili ...", listOf("2 kue", "4 kue", "6 kue", "8 kue"), "2 kue", "Setengah dari 4 adalah 2. Bagian simbol harus dibaca sesuai pecahan bentuknya.", "mudah", 250),
        q(11, "Total kue apem yang terjual selama enam hari adalah ...", listOf("198 kue", "188 kue", "208 kue", "218 kue"), "198 kue", "Jumlahkan 40 + 35 + 30 + 37 + 27 + 29 = 198.", "sedang", 250),
        q(12, "Keuntungan setiap kue apem Rp300,00. Keuntungan dari 198 kue adalah ...", listOf("Rp59.400,00", "Rp49.500,00", "Rp69.300,00", "Rp594.000,00"), "Rp59.400,00", "Keuntungan = 198 × Rp300,00 = Rp59.400,00.", "menantang", 251),
        q(13, "Total hasil panen tomat selama lima minggu adalah ...", listOf("60 kg", "50 kg", "56 kg", "64 kg"), "60 kg", "Jumlahkan 10 + 14 + 20 + 12 + 4 = 60 kg.", "sedang", 252),
        q(14, "Penurunan hasil panen tomat paling besar adalah ...", listOf("8 kg", "6 kg", "4 kg", "16 kg"), "8 kg", "Panen turun dari 20 ke 12 kg dan dari 12 ke 4 kg. Keduanya turun 8 kg.", "sedang", 252)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(8, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
