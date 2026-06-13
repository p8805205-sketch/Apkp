package com.sumberilmu.app.data

object ChapterThreeQuiz {
    val questions: List<Question> = listOf(
        question(
            id = 1,
            prompt = "Pada pecahan 3/5, angka 3 disebut ... dan angka 5 disebut ...",
            options = listOf("Pembilang dan penyebut", "Penyebut dan pembilang", "Bilangan bulat dan pembilang", "Pecahan dan satuan"),
            correct = "Pembilang dan penyebut",
            explanation = "Pembilang berada di atas garis pecahan dan menunjukkan banyak bagian yang dipilih. Penyebut berada di bawah dan menunjukkan jumlah seluruh bagian sama besar.",
            difficulty = "mudah",
            sourcePage = 67
        ),
        question(
            id = 2,
            prompt = "Pecahan campuran 2 3/4 jika diubah menjadi pecahan biasa adalah ...",
            options = listOf("5/4", "8/4", "11/4", "14/4"),
            correct = "11/4",
            explanation = "Kalikan bilangan bulat dengan penyebut lalu tambahkan pembilang: (2 × 4) + 3 = 11. Penyebut tetap 4.",
            difficulty = "mudah",
            sourcePage = 71
        ),
        question(
            id = 3,
            prompt = "Pernyataan yang benar adalah ...",
            options = listOf("1/2 > 1/5", "1/2 < 1/5", "1/2 = 1/5", "1/2 tidak dapat dibandingkan dengan 1/5"),
            correct = "1/2 > 1/5",
            explanation = "Untuk pecahan satuan, penyebut yang lebih kecil menghasilkan bagian yang lebih besar. Satu dari dua bagian lebih besar daripada satu dari lima bagian.",
            difficulty = "mudah",
            sourcePage = 66
        ),
        question(
            id = 4,
            prompt = "Urutan 2 3/4, 3 1/2, dan 7/8 dari yang terbesar adalah ...",
            options = listOf("3 1/2, 2 3/4, 7/8", "2 3/4, 3 1/2, 7/8", "7/8, 2 3/4, 3 1/2", "3 1/2, 7/8, 2 3/4"),
            correct = "3 1/2, 2 3/4, 7/8",
            explanation = "Ubah ke pecahan biasa atau desimal: 3 1/2 = 3,5; 2 3/4 = 2,75; dan 7/8 = 0,875.",
            difficulty = "sedang",
            sourcePage = 71
        ),
        question(
            id = 5,
            prompt = "Urutan 2 2/5, 2 1/4, dan 2 1/2 dari yang terpendek adalah ...",
            options = listOf("2 1/4, 2 2/5, 2 1/2", "2 1/2, 2 2/5, 2 1/4", "2 2/5, 2 1/4, 2 1/2", "2 1/4, 2 1/2, 2 2/5"),
            correct = "2 1/4, 2 2/5, 2 1/2",
            explanation = "Bilangan bulatnya sama-sama 2. Bandingkan bagian pecahannya: 1/4 = 0,25; 2/5 = 0,4; dan 1/2 = 0,5.",
            difficulty = "sedang",
            sourcePage = 75
        ),
        question(
            id = 6,
            prompt = "1/8 + 2/8 = ...",
            options = listOf("3/8", "3/16", "2/8", "1/4"),
            correct = "3/8",
            explanation = "Karena penyebutnya sama, jumlahkan pembilang: 1 + 2 = 3. Penyebut tetap 8.",
            difficulty = "mudah",
            sourcePage = 77
        ),
        question(
            id = 7,
            prompt = "Lukas memberikan 2 dari 10 penghapus kepada Asep dan 3 dari 10 kepada Yohana. Jumlah bagian yang diberikan adalah ...",
            options = listOf("1/5", "1/2", "3/10", "7/10"),
            correct = "1/2",
            explanation = "2/10 + 3/10 = 5/10. Pecahan 5/10 disederhanakan menjadi 1/2.",
            difficulty = "mudah",
            sourcePage = 79
        ),
        question(
            id = 8,
            prompt = "2 1/5 + 3 1/5 = ...",
            options = listOf("5 1/5", "5 2/5", "6 2/5", "5 1/10"),
            correct = "5 2/5",
            explanation = "Jumlahkan bilangan bulat 2 + 3 = 5 dan bagian pecahan 1/5 + 1/5 = 2/5.",
            difficulty = "mudah",
            sourcePage = 81
        ),
        question(
            id = 9,
            prompt = "1/3 + 4/6 = ...",
            options = listOf("5/9", "5/6", "1", "1 1/6"),
            correct = "1",
            explanation = "Samakan penyebut: 1/3 = 2/6. Jadi 2/6 + 4/6 = 6/6 = 1.",
            difficulty = "sedang",
            sourcePage = 87
        ),
        question(
            id = 10,
            prompt = "1/2 + 1/4 = ...",
            options = listOf("2/6", "2/4", "3/4", "1"),
            correct = "3/4",
            explanation = "KPK dari 2 dan 4 adalah 4. Ubah 1/2 menjadi 2/4, lalu 2/4 + 1/4 = 3/4.",
            difficulty = "mudah",
            sourcePage = 87
        ),
        question(
            id = 11,
            prompt = "1 1/2 + 2 1/4 + 1/200 = ...",
            options = listOf("3 151/200", "3 51/200", "4 1/200", "3 3/4"),
            correct = "3 151/200",
            explanation = "1 1/2 = 300/200, 2 1/4 = 450/200, dan 1/200 tetap. Jumlahnya 751/200 = 3 151/200.",
            difficulty = "menantang",
            sourcePage = 89
        ),
        question(
            id = 12,
            prompt = "1/4 + 3/4 = ...",
            options = listOf("4/8", "1", "3/4", "1 1/4"),
            correct = "1",
            explanation = "Penyebut sama, sehingga 1/4 + 3/4 = 4/4 = 1.",
            difficulty = "mudah",
            sourcePage = 101
        ),
        question(
            id = 13,
            prompt = "4/5 + 1/4 = ...",
            options = listOf("1 1/20", "5/9", "1 4/20", "17/20"),
            correct = "1 1/20",
            explanation = "KPK dari 5 dan 4 adalah 20. 4/5 = 16/20 dan 1/4 = 5/20, sehingga jumlahnya 21/20 = 1 1/20.",
            difficulty = "sedang",
            sourcePage = 101
        ),
        question(
            id = 14,
            prompt = "3/5 + 1/3 = ...",
            options = listOf("4/8", "8/15", "14/15", "1 1/15"),
            correct = "14/15",
            explanation = "KPK dari 5 dan 3 adalah 15. Ubah menjadi 9/15 + 5/15 = 14/15.",
            difficulty = "sedang",
            sourcePage = 102
        ),
        question(
            id = 15,
            prompt = "Joko membeli 1 1/2 kg gula jawa dan 2 1/2 kg tepung. Berat seluruh belanjaannya adalah ...",
            options = listOf("3 kg", "3 1/2 kg", "4 kg", "4 1/2 kg"),
            correct = "4 kg",
            explanation = "1 1/2 + 2 1/2 = 3 + 2/2 = 3 + 1 = 4.",
            difficulty = "mudah",
            sourcePage = 102
        ),
        question(
            id = 16,
            prompt = "2/3 - 1/3 = ...",
            options = listOf("1/3", "1/2", "1/6", "2/3"),
            correct = "1/3",
            explanation = "Penyebut sama, sehingga kurangkan pembilang: 2 - 1 = 1. Penyebut tetap 3.",
            difficulty = "mudah",
            sourcePage = 92
        ),
        question(
            id = 17,
            prompt = "Dari 8 apel, Lukas menerima 6 apel lalu memberikan 2 apel kepada Yohana. Bagian apel yang masih dipegang Lukas dari jumlah awal adalah ...",
            options = listOf("1/4", "1/2", "3/4", "6/8"),
            correct = "1/2",
            explanation = "Bagian yang diterima Lukas 6/8, lalu diberikan 2/8. Sisanya 4/8 = 1/2.",
            difficulty = "sedang",
            sourcePage = 95
        ),
        question(
            id = 18,
            prompt = "5 2/3 - 2 1/3 = ...",
            options = listOf("2 1/3", "3 1/3", "3 2/3", "4 1/3"),
            correct = "3 1/3",
            explanation = "Kurangkan bilangan bulat 5 - 2 = 3 dan pecahan 2/3 - 1/3 = 1/3.",
            difficulty = "mudah",
            sourcePage = 97
        ),
        question(
            id = 19,
            prompt = "2/3 - 1/2 = ...",
            options = listOf("1/6", "1/3", "1/2", "2/5"),
            correct = "1/6",
            explanation = "KPK dari 3 dan 2 adalah 6. Ubah menjadi 4/6 - 3/6 = 1/6.",
            difficulty = "sedang",
            sourcePage = 99
        ),
        question(
            id = 20,
            prompt = "Komang memerlukan tali 4 1/2 m dan sudah memiliki 2 1/3 m. Panjang tali yang harus dibeli adalah ...",
            options = listOf("1 1/6 m", "2 1/6 m", "2 2/3 m", "3 1/6 m"),
            correct = "2 1/6 m",
            explanation = "4 1/2 = 27/6 dan 2 1/3 = 14/6. Selisihnya 13/6 = 2 1/6.",
            difficulty = "sedang",
            sourcePage = 100
        ),
        question(
            id = 21,
            prompt = "1/3 - 1/5 = ...",
            options = listOf("1/2", "2/15", "2/8", "4/15"),
            correct = "2/15",
            explanation = "KPK dari 3 dan 5 adalah 15. Ubah menjadi 5/15 - 3/15 = 2/15.",
            difficulty = "sedang",
            sourcePage = 101
        ),
        question(
            id = 22,
            prompt = "4/6 - 2/4 = ...",
            options = listOf("1/6", "1/3", "2/10", "1/2"),
            correct = "1/6",
            explanation = "4/6 = 2/3 dan 2/4 = 1/2. Dengan penyebut 6, hasilnya 4/6 - 3/6 = 1/6.",
            difficulty = "sedang",
            sourcePage = 102
        ),
        question(
            id = 23,
            prompt = "Populasi Kabupaten Sleman 2/5 dan Kulonprogo 1/5 dari populasi provinsi. Jumlah keduanya adalah ...",
            options = listOf("1/5", "2/5", "3/5", "3/10"),
            correct = "3/5",
            explanation = "Penyebut sama, sehingga 2/5 + 1/5 = 3/5.",
            difficulty = "mudah",
            sourcePage = 103
        ),
        question(
            id = 24,
            prompt = "Populasi suku Batak 1/20 dan suku Jawa 1/6 dari penduduk Indonesia. Jumlahnya adalah ...",
            options = listOf("2/26", "7/30", "13/60", "1/12"),
            correct = "13/60",
            explanation = "KPK dari 20 dan 6 adalah 60. 1/20 = 3/60 dan 1/6 = 10/60, sehingga jumlahnya 13/60.",
            difficulty = "menantang",
            sourcePage = 103
        ),
        question(
            id = 25,
            prompt = "Penggunaan bahasa daerah 3/10 dan bahasa Indonesia 1/8. Selisih penggunaannya adalah ...",
            options = listOf("1/40", "7/40", "2/18", "13/40"),
            correct = "7/40",
            explanation = "KPK dari 10 dan 8 adalah 40. 3/10 = 12/40 dan 1/8 = 5/40, sehingga selisihnya 7/40.",
            difficulty = "menantang",
            sourcePage = 103
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
            id = "bab-3-soal-$id",
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
