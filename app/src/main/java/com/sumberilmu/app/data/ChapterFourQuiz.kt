package com.sumberilmu.app.data

object ChapterFourQuiz {
    val questions: List<Question> = listOf(
        q(1, "Keliling sebuah bangun datar adalah ...", listOf("Jumlah panjang seluruh sisi pada batas bangun", "Banyaknya titik sudut bangun", "Daerah yang tertutup oleh bangun", "Panjang satu sisi terpendek"), "Jumlah panjang seluruh sisi pada batas bangun", "Keliling merupakan total panjang lintasan yang mengelilingi batas terluar suatu bangun datar.", "mudah", 108),
        q(2, "Sebuah persegi memiliki panjang sisi 8 cm. Kelilingnya adalah ...", listOf("16 cm", "24 cm", "32 cm", "64 cm"), "32 cm", "Keliling persegi = 4 × sisi = 4 × 8 = 32 cm.", "mudah", 115),
        q(3, "Persegi panjang dengan panjang 12 cm dan lebar 7 cm memiliki keliling ...", listOf("19 cm", "38 cm", "84 cm", "48 cm"), "38 cm", "Keliling persegi panjang = 2 × (panjang + lebar) = 2 × (12 + 7) = 38 cm.", "mudah", 116),
        q(4, "Sisi-sisi sebuah segitiga adalah 8 cm, 7 cm, dan 5 cm. Kelilingnya ...", listOf("18 cm", "20 cm", "28 cm", "35 cm"), "20 cm", "Jumlahkan seluruh sisi segitiga: 8 + 7 + 5 = 20 cm.", "mudah", 111),
        q(5, "Keliling segitiga sama sisi yang panjang setiap sisinya 9 cm adalah ...", listOf("18 cm", "27 cm", "36 cm", "81 cm"), "27 cm", "Segitiga sama sisi mempunyai tiga sisi sama panjang. Keliling = 3 × 9 = 27 cm.", "mudah", 112),
        q(6, "Segitiga sama kaki mempunyai dua sisi 10 cm dan alas 6 cm. Kelilingnya ...", listOf("16 cm", "20 cm", "26 cm", "36 cm"), "26 cm", "Keliling = 10 + 10 + 6 = 26 cm.", "mudah", 112),
        q(7, "Sebuah jajargenjang memiliki sisi-sisi berdekatan 14 cm dan 9 cm. Kelilingnya ...", listOf("23 cm", "36 cm", "46 cm", "126 cm"), "46 cm", "Sisi berhadapan pada jajargenjang sama panjang. Keliling = 2 × (14 + 9) = 46 cm.", "sedang", 118),
        q(8, "Belah ketupat memiliki panjang sisi 13 cm. Kelilingnya adalah ...", listOf("26 cm", "39 cm", "52 cm", "169 cm"), "52 cm", "Keempat sisi belah ketupat sama panjang. Keliling = 4 × 13 = 52 cm.", "mudah", 119),
        q(9, "Layang-layang memiliki dua sisi masing-masing 12 cm dan dua sisi masing-masing 8 cm. Kelilingnya ...", listOf("20 cm", "32 cm", "40 cm", "96 cm"), "40 cm", "Keliling = 2 × 12 + 2 × 8 = 24 + 16 = 40 cm.", "sedang", 119),
        q(10, "Sisi-sisi sebuah trapesium adalah 12 cm, 8 cm, 6 cm, dan 5 cm. Kelilingnya ...", listOf("26 cm", "31 cm", "36 cm", "48 cm"), "31 cm", "Keliling trapesium diperoleh dengan menjumlahkan keempat sisinya: 12 + 8 + 6 + 5 = 31 cm.", "mudah", 120),
        q(11, "Sebuah segi lima beraturan mempunyai panjang sisi 7 cm. Kelilingnya ...", listOf("28 cm", "35 cm", "42 cm", "49 cm"), "35 cm", "Segi lima beraturan mempunyai lima sisi sama panjang. Keliling = 5 × 7 = 35 cm.", "mudah", 122),
        q(12, "Keliling segi enam beraturan dengan panjang sisi 6 cm adalah ...", listOf("24 cm", "30 cm", "36 cm", "42 cm"), "36 cm", "Segi enam beraturan mempunyai enam sisi sama panjang. Keliling = 6 × 6 = 36 cm.", "mudah", 122),
        q(13, "Keliling sebuah persegi 48 cm. Panjang satu sisinya adalah ...", listOf("8 cm", "10 cm", "12 cm", "16 cm"), "12 cm", "Panjang sisi persegi = keliling ÷ 4 = 48 ÷ 4 = 12 cm.", "sedang", 116),
        q(14, "Keliling persegi panjang 50 cm. Jika panjangnya 16 cm, lebarnya adalah ...", listOf("7 cm", "8 cm", "9 cm", "18 cm"), "9 cm", "Setengah keliling = 25 cm. Karena panjang + lebar = 25, maka lebar = 25 - 16 = 9 cm.", "sedang", 117),
        q(15, "Taman berbentuk segitiga memiliki sisi 15 m, 12 m, dan 9 m. Panjang pagar yang diperlukan adalah ...", listOf("27 m", "30 m", "36 m", "45 m"), "36 m", "Panjang pagar sama dengan keliling taman: 15 + 12 + 9 = 36 m.", "mudah", 113),
        q(16, "Foto berukuran 18 cm × 13 cm akan diberi pita pada seluruh tepinya. Panjang pita minimal adalah ...", listOf("31 cm", "49 cm", "62 cm", "234 cm"), "62 cm", "Keliling foto = 2 × (18 + 13) = 62 cm.", "mudah", 117),
        q(17, "Lapangan persegi bersisi 25 m akan dipagari, tetapi terdapat pintu selebar 2 m yang tidak dipagari. Panjang pagar adalah ...", listOf("96 m", "98 m", "100 m", "102 m"), "98 m", "Keliling lapangan = 4 × 25 = 100 m. Kurangi bagian pintu 2 m, sehingga pagar yang dibutuhkan 98 m.", "sedang", 124),
        q(18, "Seorang pelari mengelilingi lapangan 40 m × 25 m sebanyak 3 putaran. Jarak yang ditempuh ...", listOf("130 m", "195 m", "390 m", "3.000 m"), "390 m", "Keliling satu putaran = 2 × (40 + 25) = 130 m. Tiga putaran = 3 × 130 = 390 m.", "sedang", 124),
        q(19, "Sebuah persegi sisi 4 cm ditempel pada sisi persegi panjang 10 cm × 6 cm. Panjang sisi yang berhimpit 4 cm. Keliling bangun gabungan adalah ...", listOf("40 cm", "44 cm", "48 cm", "56 cm"), "40 cm", "Keliling kedua bangun adalah 32 + 16 = 48 cm. Sisi berhimpit 4 cm dihitung dua kali, sehingga dikurangi 8 cm. Hasilnya 40 cm.", "menantang", 126),
        q(20, "Dua persegi dengan sisi 5 cm ditempel berdampingan pada satu sisi penuh. Keliling bangun gabungannya ...", listOf("20 cm", "25 cm", "30 cm", "40 cm"), "30 cm", "Dua persegi membentuk persegi panjang 10 cm × 5 cm. Keliling = 2 × (10 + 5) = 30 cm.", "sedang", 126),
        q(21, "Sebuah bangun berbentuk L memiliki sisi luar berturut-turut 8 cm, 3 cm, 4 cm, 7 cm, 12 cm, dan 10 cm. Kelilingnya ...", listOf("34 cm", "40 cm", "44 cm", "48 cm"), "44 cm", "Jumlahkan semua sisi luar: 8 + 3 + 4 + 7 + 12 + 10 = 44 cm.", "menantang", 127),
        q(22, "Bingkai segitiga mempunyai sisi 22 cm, 18 cm, dan 16 cm. Diperlukan tambahan 3 cm untuk simpul. Panjang tali seluruhnya ...", listOf("53 cm", "56 cm", "59 cm", "62 cm"), "59 cm", "Keliling bingkai = 22 + 18 + 16 = 56 cm. Tambahkan 3 cm untuk simpul menjadi 59 cm.", "sedang", 128),
        q(23, "Biaya pagar adalah Rp4.000 per meter. Sebuah kebun berukuran 30 m × 20 m akan dipagari seluruhnya. Biayanya ...", listOf("Rp200.000", "Rp320.000", "Rp400.000", "Rp2.400.000"), "Rp400.000", "Keliling kebun = 2 × (30 + 20) = 100 m. Biaya = 100 × Rp4.000 = Rp400.000.", "menantang", 128),
        q(24, "Persegi bersisi 15 cm dan persegi panjang berukuran 20 cm × 10 cm mempunyai keliling yang ...", listOf("Persegi lebih besar", "Persegi panjang lebih besar", "Sama besar", "Tidak dapat dibandingkan"), "Sama besar", "Keliling kedua bangun sama-sama 60 cm.", "sedang", 129),
        q(25, "Bangun berbentuk rumah terdiri atas persegi panjang berukuran lebar 12 cm dan tinggi 8 cm, serta atap segitiga dengan dua sisi miring 10 cm. Alas atap berhimpit dengan sisi atas persegi panjang. Keliling luarnya ...", listOf("40 cm", "48 cm", "52 cm", "60 cm"), "48 cm", "Sisi luar terdiri atas alas 12 cm, dua sisi tegak 8 cm, dan dua sisi miring 10 cm: 12 + 8 + 8 + 10 + 10 = 48 cm.", "menantang", 129)
    )

    private fun q(
        id: Int,
        prompt: String,
        options: List<String>,
        correct: String,
        explanation: String,
        difficulty: String,
        sourcePage: Int
    ): Question {
        require(options.size == 4)
        require(options.toSet().size == 4)
        val correctIndex = options.indexOf(correct)
        require(correctIndex >= 0)
        return Question(
            id = "bab-4-soal-$id",
            prompt = prompt,
            options = options.mapIndexed { index, value ->
                QuestionOption(
                    text = value,
                    explanation = if (index == correctIndex) "Tepat. $explanation" else "Belum tepat. $explanation"
                )
            },
            correctIndex = correctIndex,
            explanation = explanation,
            difficulty = difficulty,
            sourcePage = sourcePage
        )
    }
}
