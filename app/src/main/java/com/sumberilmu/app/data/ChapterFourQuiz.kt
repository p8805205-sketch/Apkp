package com.sumberilmu.app.data

object ChapterFourQuiz {
    val questions: List<Question> = listOf(
        question(
            id = 1,
            prompt = "Keliling sebuah bangun datar adalah ...",
            options = listOf(
                "Jumlah panjang seluruh sisi pada batas bangun",
                "Banyaknya titik sudut bangun",
                "Daerah yang tertutup oleh bangun",
                "Panjang satu sisi terpendek"
            ),
            correct = "Jumlah panjang seluruh sisi pada batas bangun",
            explanation = "Keliling merupakan total panjang lintasan yang mengelilingi batas terluar suatu bangun datar.",
            difficulty = "mudah",
            sourcePage = 108
        ),
        question(
            id = 2,
            prompt = "Sebuah persegi memiliki panjang sisi 8 cm. Kelilingnya adalah ...",
            options = listOf("16 cm", "24 cm", "32 cm", "64 cm"),
            correct = "32 cm",
            explanation = "Keliling persegi = 4 × sisi = 4 × 8 = 32 cm.",
            difficulty = "mudah",
            sourcePage = 115
        ),
        question(
            id = 3,
            prompt = "Persegi panjang dengan panjang 12 cm dan lebar 7 cm memiliki keliling ...",
            options = listOf("19 cm", "38 cm", "84 cm", "48 cm"),
            correct = "38 cm",
            explanation = "Keliling persegi panjang = 2 × (panjang + lebar) = 2 × (12 + 7) = 38 cm.",
            difficulty = "mudah",
            sourcePage = 116
        ),
        question(
            id = 4,
            prompt = "Sisi-sisi sebuah segitiga adalah 8 cm, 7 cm, dan 5 cm. Kelilingnya ...",
            options = listOf("18 cm", "20 cm", "28 cm", "35 cm"),
            correct = "20 cm",
            explanation = "Jumlahkan seluruh sisi segitiga: 8 + 7 + 5 = 20 cm.",
            difficulty = "mudah",
            sourcePage = 111
        ),
        question(
            id = 5,
            prompt = "Keliling segitiga sama sisi yang panjang setiap sisinya 9 cm adalah ...",
            options = listOf("18 cm", "27 cm", "36 cm", "81 cm"),
            correct = "27 cm",
            explanation = "Segitiga sama sisi mempunyai tiga sisi sama panjang. Keliling = 3 × 9 = 27 cm.",
            difficulty = "mudah",
            sourcePage = 112
        ),
        question(
            id = 6,
            prompt = "Segitiga sama kaki mempunyai dua sisi 10 cm dan alas 6 cm. Kelilingnya ...",
            options = listOf("16 cm", "20 cm", "26 cm", "36 cm"),
            correct = "26 cm",
            explanation = "Keliling = 10 + 10 + 6 = 26 cm.",
            difficulty = "mudah",
            sourcePage = 112
        ),
        question(
            id = 7,
            prompt = "Sebuah jajargenjang memiliki sisi-sisi berdekatan 14 cm dan 9 cm. Kelilingnya ...",
            options = listOf("23 cm", "36 cm", "46 cm", "126 cm"),
            correct = "46 cm",
            explanation = "Sisi berhadapan pada jajargenjang sama panjang. Keliling = 2 × (14 + 9) = 46 cm.",
            difficulty = "sedang",
            sourcePage = 118
        ),
        question(
            id = 8,
            prompt = "Belah ketupat memiliki panjang sisi 13 cm. Kelilingnya adalah ...",
            options = listOf("26 cm", "39 cm", "52 cm", "169 cm"),
            correct = "52 cm",
            explanation = "Keempat sisi belah ketupat sama panjang. Keliling = 4 × 13 = 52 cm.",
            difficulty = "mudah",
            sourcePage = 119
        ),
        question(
            id = 9,
            prompt = "Layang-layang memiliki dua sisi masing-masing 12 cm dan dua sisi masing-masing 8 cm. Kelilingnya ...",
            options = listOf("20 cm", "32 cm", "40 cm", "96 cm"),
            correct = "40 cm",
            explanation = "Keliling = 2 × 12 + 2 × 8 = 24 + 16 = 40 cm.",
            difficulty = "sedang",
            sourcePage = 119
        ),
        question(
            id = 10,
            prompt = "Sisi-sisi sebuah trapesium adalah 12 cm, 8 cm, 6 cm, dan 5 cm. Kelilingnya ...",
            options = listOf("26 cm", "31 cm", "36 cm", "48 cm"),
            correct = "31 cm",
            explanation = "Keliling trapesium diperoleh dengan menjumlahkan keempat sisinya: 12 + 8 + 6 + 5 = 31 cm.",
            difficulty = "mudah",
            sourcePage = 120
        ),
        question(
            id = 11,
            prompt = "Sebuah segi lima beraturan mempunyai panjang sisi 7 cm. Kelilingnya ...",
            options = listOf("28 cm", "35 cm", "42 cm", "49 cm"),
            correct = "35 cm",
            explanation = "Segi lima beraturan mempunyai lima sisi sama panjang. Keliling = 5 × 7 = 35 cm.",
            difficulty = "mudah",
            sourcePage = 122
        ),
        question(
            id = 12,
            prompt = "Keliling segi enam beraturan dengan panjang sisi 6 cm adalah ...",
            options = listOf("24 cm", "30 cm", "36 cm", "42 cm"),
            correct = "36 cm",
            explanation = "Segi enam beraturan mempunyai enam sisi sama panjang. Keliling = 6 × 6 = 36 cm.",
            difficulty = "mudah",
            sourcePage = 122
        ),
        question(
            id = 13,
            prompt = "Keliling sebuah persegi 48 cm. Panjang satu sisinya adalah ...",
            options = listOf("8 cm", "10 cm", "12 cm", "16 cm"),
            correct = "12 cm",
            explanation = "Panjang sisi persegi = keliling ÷ 4 = 48 ÷ 4 = 12 cm.",
            difficulty = "sedang",
            sourcePage = 116
        ),
        question(
            id = 14,
            prompt = "Keliling persegi panjang 50 cm. Jika panjangnya 16 cm, lebarnya adalah ...",
            options = listOf("7 cm", "8 cm", "9 cm", "18 cm"),
            correct = "9 cm",
            explanation = "Setengah keliling = 25 cm. Karena panjang + lebar = 25, maka lebar = 25 - 16 = 9 cm.",
            difficulty = "sedang",
            sourcePage = 117
        ),
        question(
            id = 15,
            prompt = "Taman berbentuk segitiga memiliki sisi 15 m, 12 m, dan 9 m. Panjang pagar yang diperlukan adalah ...",
            options = listOf("27 m", "30 m", "36 m", "45 m"),
            correct = "36 m",
            explanation = "Panjang pagar sama dengan keliling taman: 15 + 12 + 9 = 36 m.",
            difficulty = "mudah",
            sourcePage = 113
        ),
        question(
            id = 16,
            prompt = "Foto berukuran 18 cm × 13 cm akan diberi pita pada seluruh tepinya. Panjang pita minimal adalah ...",
            options = listOf("31 cm", "49 cm", "62 cm", "234 cm"),
            correct = "62 cm",
            explanation = "Keliling foto = 2 × (18 + 13) = 62 cm.",
            difficulty = "mudah",
            sourcePage = 117
        ),
        question(
            id = 17,
            prompt = "Lapangan persegi bersisi 25 m akan dipagari, tetapi terdapat pintu selebar 2 m yang tidak dipagari. Panjang pagar adalah ...",
            options = listOf("96 m", "98 m", "100 m", "102 m"),
            correct = "98 m",
            explanation = "Keliling lapangan = 4 × 25 = 100 m. Kurangi bagian pintu 2 m, sehingga pagar yang dibutuhkan 98 m.",
            difficulty = "sedang",
            sourcePage = 124
        ),
        question(
            id = 18,
            prompt = "Seorang pelari mengelilingi lapangan 40 m × 25 m sebanyak 3 putaran. Jarak yang ditempuh ...",
            options = listOf("130 m", "195 m", "390 m", "3.000 m"),
            correct = "390 m",
            explanation = "Keliling satu putaran = 2 × (40 + 25) = 130 m. Tiga putaran = 3 × 130 = 390 m.",
            difficulty = "sedang",
            sourcePage = 124
        ),
        question(
            id = 19,
            prompt = "Sebuah persegi sisi 4 cm ditempel pada sisi persegi panjang 10 cm × 6 cm. Panjang sisi yang berhimpit 4 cm. Keliling bangun gabungan adalah ...",
            options = listOf("40 cm", "44 cm", "48 cm", "56 cm"),
            correct = "48 cm",
            explanation = "Jumlah keliling kedua bangun = 32 + 16 = 48? Periksa: keliling persegi panjang 32 dan persegi 16, lalu kurangi dua kali sisi berhimpit 8. Hasilnya 40 cm.",
            difficulty = "menantang",
            sourcePage = 126
        ),
        question(
            id = 20,
            prompt = "Dua persegi dengan sisi 5 cm ditempel berdampingan pada satu sisi penuh. Keliling bangun gabungannya ...",
            options = listOf("20 cm", "25 cm", "30 cm", "40 cm"),
            correct = "30 cm",
            explanation = "Dua persegi membentuk persegi panjang 10 cm × 5 cm. Keliling = 2 × (10 + 5) = 30 cm.",
            difficulty = "sedang",
            sourcePage = 126
        ),
        question(
            id = 21,
            prompt = "Sebuah bangun berbentuk L memiliki sisi luar berturut-turut 8 cm, 3 cm, 4 cm, 7 cm, 12 cm, dan 10 cm. Kelilingnya ...",
            options = listOf("34 cm", "40 cm", "44 cm", "48 cm"),
            correct = "44 cm",
            explanation = "Keliling bangun tidak beraturan diperoleh dengan menjumlahkan semua sisi luarnya: 8 + 3 + 4 + 7 + 12 + 10 = 44 cm.",
            difficulty = "menantang",
            sourcePage = 127
        ),
        question(
            id = 22,
            prompt = "Bingkai segitiga mempunyai sisi 22 cm, 18 cm, dan 16 cm. Diperlukan tambahan 3 cm untuk simpul. Panjang tali seluruhnya ...",
            options = listOf("53 cm", "56 cm", "59 cm", "62 cm"),
            correct = "59 cm",
            explanation = "Keliling bingkai = 22 + 18 + 16 = 56 cm. Tambahkan 3 cm untuk simpul menjadi 59 cm.",
            difficulty = "sedang",
            sourcePage = 128
        ),
        question(
            id = 23,
            prompt = "Biaya pagar adalah Rp4.000 per meter. Sebuah kebun berukuran 30 m × 20 m akan dipagari seluruhnya. Biayanya ...",
            options = listOf("Rp200.000", "Rp320.000", "Rp400.000", "Rp2.400.000"),
            correct = "Rp400.000",
            explanation = "Keliling kebun = 2 × (30 + 20) = 100 m. Biaya = 100 × Rp4.000 = Rp400.000.",
            difficulty = "menantang",
            sourcePage = 128
        ),
        question(
            id = 24,
            prompt = "Persegi bersisi 15 cm dan persegi panjang berukuran 20 cm × 10 cm mempunyai keliling yang ...",
            options = listOf("Persegi lebih besar", "Persegi panjang lebih besar", "Sama besar", "Tidak dapat dibandingkan"),
            correct = "Sama besar",
            explanation = "Keliling persegi = 4 × 15 = 60 cm. Keliling persegi panjang = 2 × (20 + 10) = 60 cm.",
            difficulty = "sedang",
            sourcePage = 129
        ),
        question(
            id = 25,
            prompt = "Bangun berbentuk rumah terdiri atas persegi panjang berukuran lebar 12 cm dan tinggi 8 cm, serta atap segitiga dengan dua sisi miring 10 cm. Alas atap berhimpit dengan sisi atas persegi panjang. Keliling luarnya ...",
            options = listOf("40 cm", "48 cm", "52 cm", "60 cm"),
            correct = "48 cm",
            explanation = "Sisi luar terdiri atas alas 12 cm, dua sisi tegak 8 cm, dan dua sisi miring 10 cm. Jadi 12 + 8 + 8 + 10 + 10 = 48 cm.",
            difficulty = "menantang",
            sourcePage = 129
        )
    )

    private fun question(
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
                    explanation = if (index == correctIndex) {
                        "Tepat. $explanation"
                    } else {
                        "Belum tepat. $explanation"
                    }
                )
            },
            correctIndex = correctIndex,
            explanation = explanation,
            difficulty = difficulty,
            sourcePage = sourcePage
        )
    }
}
