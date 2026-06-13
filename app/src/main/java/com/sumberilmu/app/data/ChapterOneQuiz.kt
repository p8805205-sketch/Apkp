package com.sumberilmu.app.data

object ChapterOneQuiz {
    val questions: List<Question> = listOf(
        question(
            id = 1,
            prompt = "Bilangan 'empat belas ribu lima ratus' ditulis sebagai ...",
            options = listOf("14.050", "14.500", "41.500", "14.005"),
            correct = "14.500",
            explanation = "Empat belas ribu bernilai 14.000 dan lima ratus bernilai 500, sehingga bilangannya 14.500.",
            difficulty = "mudah",
            sourcePage = 5
        ),
        question(
            id = 2,
            prompt = "Cara membaca bilangan 66.500 adalah ...",
            options = listOf(
                "Enam puluh enam ribu lima ratus",
                "Enam ribu enam ratus lima puluh",
                "Enam puluh ribu enam ratus lima",
                "Enam ratus enam puluh lima ribu"
            ),
            correct = "Enam puluh enam ribu lima ratus",
            explanation = "Angka 6 pertama berada pada tempat puluh ribuan, angka 6 kedua pada ribuan, dan angka 5 pada ratusan.",
            difficulty = "mudah",
            sourcePage = 7
        ),
        question(
            id = 3,
            prompt = "Pada bilangan 87.986, angka 7 menempati nilai tempat ...",
            options = listOf("Puluh ribuan", "Ribuan", "Ratusan", "Puluhan"),
            correct = "Ribuan",
            explanation = "Urutan nilai tempat dari kanan adalah satuan, puluhan, ratusan, ribuan, lalu puluh ribuan.",
            difficulty = "mudah",
            sourcePage = 9
        ),
        question(
            id = 4,
            prompt = "Nilai angka 5 pada bilangan 54.675 adalah ...",
            options = listOf("5", "500", "5.000", "50.000"),
            correct = "50.000",
            explanation = "Angka 5 berada pada tempat puluh ribuan, sehingga nilainya 5 × 10.000 = 50.000.",
            difficulty = "mudah",
            sourcePage = 9
        ),
        question(
            id = 5,
            prompt = "50.000 + 6.000 + 700 + 80 + 6 membentuk bilangan ...",
            options = listOf("56.786", "56.876", "50.686", "56.708"),
            correct = "56.786",
            explanation = "Gabungkan setiap nilai tempat: 5 puluh ribuan, 6 ribuan, 7 ratusan, 8 puluhan, dan 6 satuan.",
            difficulty = "mudah",
            sourcePage = 9
        ),
        question(
            id = 6,
            prompt = "Bilangan yang lebih kecil antara 56.475 dan 43.217 adalah ...",
            options = listOf("56.475", "43.217", "Keduanya sama", "Tidak dapat dibandingkan"),
            correct = "43.217",
            explanation = "Bandingkan angka puluh ribuannya. Empat puluh ribuan lebih kecil daripada lima puluh ribuan.",
            difficulty = "mudah",
            sourcePage = 14
        ),
        question(
            id = 7,
            prompt = "Tanda yang tepat untuk 76.675 ... 67.765 adalah ...",
            options = listOf(">", "<", "=", "+"),
            correct = ">",
            explanation = "Angka puluh ribuan 7 lebih besar daripada 6, sehingga 76.675 lebih besar.",
            difficulty = "mudah",
            sourcePage = 15
        ),
        question(
            id = 8,
            prompt = "Tanda yang tepat untuk 86.567 ... 86.576 adalah ...",
            options = listOf(">", "<", "=", "−"),
            correct = "<",
            explanation = "Puluh ribuan, ribuan, dan ratusannya sama. Pada tempat puluhan, 6 lebih kecil daripada 7.",
            difficulty = "sedang",
            sourcePage = 15
        ),
        question(
            id = 9,
            prompt = "Urutan harga 56.560, 65.750, 57.000, dan 75.360 dari yang termurah adalah ...",
            options = listOf(
                "56.560, 57.000, 65.750, 75.360",
                "57.000, 56.560, 65.750, 75.360",
                "75.360, 65.750, 57.000, 56.560",
                "56.560, 65.750, 57.000, 75.360"
            ),
            correct = "56.560, 57.000, 65.750, 75.360",
            explanation = "Bandingkan nilai tempat dari kiri. Dua bilangan 56.560 dan 57.000 sama-sama lima puluh ribuan, lalu 56.560 lebih kecil.",
            difficulty = "sedang",
            sourcePage = 10
        ),
        question(
            id = 10,
            prompt = "Tiga lembar uang 10.000, delapan lembar 1.000, dan enam keping 100 membentuk ...",
            options = listOf("38.060", "38.600", "30.860", "36.800"),
            correct = "38.600",
            explanation = "3 × 10.000 + 8 × 1.000 + 6 × 100 = 30.000 + 8.000 + 600 = 38.600.",
            difficulty = "mudah",
            sourcePage = 15
        ),
        question(
            id = 11,
            prompt = "Dekomposisi yang tepat untuk 45.600 adalah ...",
            options = listOf(
                "40.000 + 5.000 + 600",
                "4.000 + 5.000 + 600",
                "40.000 + 500 + 60",
                "45.000 + 60"
            ),
            correct = "40.000 + 5.000 + 600",
            explanation = "Angka 4 bernilai 40.000, angka 5 bernilai 5.000, dan angka 6 bernilai 600.",
            difficulty = "mudah",
            sourcePage = 16
        ),
        question(
            id = 12,
            prompt = "57.500 + 22.000 = ...",
            options = listOf("69.500", "79.500", "79.000", "80.500"),
            correct = "79.500",
            explanation = "Jumlahkan nilai tempat yang sejajar: 50.000 + 20.000, 7.000 + 2.000, dan 500 + 0.",
            difficulty = "mudah",
            sourcePage = 18
        ),
        question(
            id = 13,
            prompt = "Harga ayam taliwang 32.500 dan plencing kangkung 13.250. Total harganya ...",
            options = listOf("44.750", "45.750", "46.750", "45.250"),
            correct = "45.750",
            explanation = "32.500 + 13.250 = 45.750.",
            difficulty = "mudah",
            sourcePage = 19
        ),
        question(
            id = 14,
            prompt = "Lukas memiliki 47.900 dan membayar makanan seharga 45.750. Sisa uangnya ...",
            options = listOf("2.150", "2.250", "3.150", "1.250"),
            correct = "2.150",
            explanation = "47.900 − 45.750 = 2.150.",
            difficulty = "sedang",
            sourcePage = 20
        ),
        question(
            id = 15,
            prompt = "Dua belas angpau masing-masing berisi 5.000. Jumlah seluruh uang adalah ...",
            options = listOf("50.000", "55.000", "60.000", "65.000"),
            correct = "60.000",
            explanation = "12 × 5.000 = (10 × 5.000) + (2 × 5.000) = 50.000 + 10.000.",
            difficulty = "mudah",
            sourcePage = 22
        ),
        question(
            id = 16,
            prompt = "Uang 64.000 dibagikan sama rata kepada 4 anak. Setiap anak menerima ...",
            options = listOf("14.000", "15.000", "16.000", "18.000"),
            correct = "16.000",
            explanation = "64.000 ÷ 4 = 16.000.",
            difficulty = "mudah",
            sourcePage = 23
        ),
        question(
            id = 17,
            prompt = "Harga buah: mangga 23.500, jeruk 17.000, kelengkeng 34.000, buah naga 15.000, alpukat 32.000. Buah termurah adalah ...",
            options = listOf("Mangga", "Jeruk", "Buah naga", "Alpukat"),
            correct = "Buah naga",
            explanation = "Nilai paling kecil dari daftar harga tersebut adalah 15.000.",
            difficulty = "mudah",
            sourcePage = 24
        ),
        question(
            id = 18,
            prompt = "Dua bungkus mangga seharga 23.500 per bungkus dan satu bungkus jeruk 17.000 berjumlah ...",
            options = listOf("57.000", "60.000", "64.000", "67.000"),
            correct = "64.000",
            explanation = "2 × 23.500 + 17.000 = 47.000 + 17.000 = 64.000.",
            difficulty = "sedang",
            sourcePage = 25
        ),
        question(
            id = 19,
            prompt = "Nisa memiliki 100.000 lalu membeli dua mangga dan dua buah naga. Sisa uangnya ...",
            options = listOf("20.000", "21.000", "23.000", "24.000"),
            correct = "23.000",
            explanation = "Belanja = 2 × 23.500 + 2 × 15.000 = 77.000. Sisa = 100.000 − 77.000 = 23.000.",
            difficulty = "sedang",
            sourcePage = 25
        ),
        question(
            id = 20,
            prompt = "Jumlah harga buah termurah dan termahal pada daftar tersebut adalah ...",
            options = listOf("47.000", "49.000", "51.000", "57.500"),
            correct = "49.000",
            explanation = "Buah termurah 15.000 dan termahal 34.000, sehingga totalnya 49.000.",
            difficulty = "sedang",
            sourcePage = 25
        ),
        question(
            id = 21,
            prompt = "Jika masing-masing satu bungkus mangga, alpukat, kelengkeng, jeruk, dan buah naga dibeli, totalnya ...",
            options = listOf("111.500", "119.500", "121.500", "124.500"),
            correct = "121.500",
            explanation = "23.500 + 32.000 + 34.000 + 17.000 + 15.000 = 121.500.",
            difficulty = "menantang",
            sourcePage = 25
        ),
        question(
            id = 22,
            prompt = "Selisih harga satu bungkus kelengkeng 34.000 dan dua bungkus buah naga adalah ...",
            options = listOf("2.000", "3.000", "4.000", "5.000"),
            correct = "4.000",
            explanation = "Dua buah naga berharga 30.000. Selisihnya 34.000 − 30.000 = 4.000.",
            difficulty = "sedang",
            sourcePage = 25
        ),
        question(
            id = 23,
            prompt = "76.598 + 12.456 = ...",
            options = listOf("88.954", "89.054", "89.154", "90.054"),
            correct = "89.054",
            explanation = "Jumlahkan satuan hingga puluh ribuan dengan memperhatikan penyimpanan. Hasilnya 89.054.",
            difficulty = "menantang",
            sourcePage = 27
        ),
        question(
            id = 24,
            prompt = "67.987 − 13.453 = ...",
            options = listOf("54.434", "54.534", "55.534", "54.634"),
            correct = "54.534",
            explanation = "Kurangkan nilai tempat yang sejajar: 67.987 − 13.453 = 54.534.",
            difficulty = "menantang",
            sourcePage = 27
        ),
        question(
            id = 25,
            prompt = "67.032 ÷ 147 = ...",
            options = listOf("356", "426", "456", "486"),
            correct = "456",
            explanation = "Periksa dengan perkalian balik: 147 × 456 = 67.032.",
            difficulty = "menantang",
            sourcePage = 27
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
            id = "bab-1-soal-$id",
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
