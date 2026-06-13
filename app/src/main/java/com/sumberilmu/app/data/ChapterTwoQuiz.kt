package com.sumberilmu.app.data

object ChapterTwoQuiz {
    val questions: List<Question> = listOf(
        question(
            id = 1,
            prompt = "Lima bilangan kelipatan 6 yang pertama adalah ...",
            options = listOf("6, 12, 18, 24, 30", "1, 2, 3, 4, 5", "6, 11, 16, 21, 26", "0, 6, 12, 18, 24"),
            correct = "6, 12, 18, 24, 30",
            explanation = "Kelipatan 6 diperoleh dari 1 × 6, 2 × 6, 3 × 6, dan seterusnya. Buku tidak memasukkan 0 sebagai bilangan kelipatan 6 pada pembahasan ini.",
            difficulty = "mudah",
            sourcePage = 37
        ),
        question(
            id = 2,
            prompt = "Bilangan yang bukan kelipatan 7 adalah ...",
            options = listOf("21", "35", "49", "54"),
            correct = "54",
            explanation = "21 = 3 × 7, 35 = 5 × 7, dan 49 = 7 × 7. Bilangan 54 tidak habis dibagi 7.",
            difficulty = "mudah",
            sourcePage = 36
        ),
        question(
            id = 3,
            prompt = "Kelipatan persekutuan 2 dan 3 yang kurang dari 20 adalah ...",
            options = listOf("2, 4, 8, 10", "3, 9, 15", "6, 12, 18", "5, 10, 15"),
            correct = "6, 12, 18",
            explanation = "Kelipatan persekutuan harus merupakan kelipatan 2 sekaligus kelipatan 3. Di bawah 20, bilangannya adalah 6, 12, dan 18.",
            difficulty = "mudah",
            sourcePage = 39
        ),
        question(
            id = 4,
            prompt = "KPK dari 4 dan 5 adalah ...",
            options = listOf("10", "15", "20", "40"),
            correct = "20",
            explanation = "Kelipatan 4 adalah 4, 8, 12, 16, 20, ... dan kelipatan 5 adalah 5, 10, 15, 20, .... Kelipatan persekutuan terkecilnya 20.",
            difficulty = "mudah",
            sourcePage = 40
        ),
        question(
            id = 5,
            prompt = "Nisa berenang setiap 3 hari dan Yohana setiap 4 hari. Jika mereka berenang bersama pada 3 Agustus, mereka akan bersama lagi pada ...",
            options = listOf("7 Agustus", "12 Agustus", "15 Agustus", "19 Agustus"),
            correct = "15 Agustus",
            explanation = "KPK dari 3 dan 4 adalah 12. Dua belas hari setelah 3 Agustus adalah 15 Agustus.",
            difficulty = "sedang",
            sourcePage = 41
        ),
        question(
            id = 6,
            prompt = "KPK dari 5 dan 7 adalah ...",
            options = listOf("12", "25", "30", "35"),
            correct = "35",
            explanation = "Kelipatan pertama yang sama pada daftar kelipatan 5 dan 7 adalah 35.",
            difficulty = "mudah",
            sourcePage = 42
        ),
        question(
            id = 7,
            prompt = "KPK dari 6 dan 8 adalah ...",
            options = listOf("12", "18", "24", "48"),
            correct = "24",
            explanation = "Kelipatan 6: 6, 12, 18, 24, ...; kelipatan 8: 8, 16, 24, .... Bilangan sama yang paling kecil adalah 24.",
            difficulty = "mudah",
            sourcePage = 42
        ),
        question(
            id = 8,
            prompt = "KPK dari 3, 4, dan 5 adalah ...",
            options = listOf("12", "20", "40", "60"),
            correct = "60",
            explanation = "60 habis dibagi 3, 4, dan 5 serta merupakan bilangan positif terkecil yang memenuhi ketiganya.",
            difficulty = "sedang",
            sourcePage = 42
        ),
        question(
            id = 9,
            prompt = "Dinda les piano setiap 5 hari dan Amelia setiap 2 hari. Jika mereka bertemu pada 14 Juli, pertemuan terdekat berikutnya adalah ...",
            options = listOf("19 Juli", "20 Juli", "24 Juli", "29 Juli"),
            correct = "24 Juli",
            explanation = "KPK dari 5 dan 2 adalah 10. Sepuluh hari setelah 14 Juli adalah 24 Juli.",
            difficulty = "sedang",
            sourcePage = 42
        ),
        question(
            id = 10,
            prompt = "Semua faktor dari 12 adalah ...",
            options = listOf("1, 2, 3, 4, 6, 12", "1, 2, 4, 8, 12", "2, 3, 4, 6", "1, 3, 6, 9, 12"),
            correct = "1, 2, 3, 4, 6, 12",
            explanation = "Faktor adalah bilangan yang membagi 12 tanpa sisa. Pasangan faktornya: 1 × 12, 2 × 6, dan 3 × 4.",
            difficulty = "mudah",
            sourcePage = 44
        ),
        question(
            id = 11,
            prompt = "Pasangan faktor dari 18 yang tepat adalah ...",
            options = listOf("2 dan 8", "3 dan 6", "4 dan 5", "6 dan 6"),
            correct = "3 dan 6",
            explanation = "Pasangan faktor harus menghasilkan 18 ketika dikalikan. 3 × 6 = 18.",
            difficulty = "mudah",
            sourcePage = 45
        ),
        question(
            id = 12,
            prompt = "Daftar faktor 24 yang lengkap adalah ...",
            options = listOf("1, 2, 3, 4, 6, 8, 12, 24", "1, 2, 4, 6, 12, 24", "2, 3, 6, 8, 12", "1, 3, 4, 8, 16, 24"),
            correct = "1, 2, 3, 4, 6, 8, 12, 24",
            explanation = "Pasangan faktor 24 adalah 1 × 24, 2 × 12, 3 × 8, dan 4 × 6.",
            difficulty = "sedang",
            sourcePage = 46
        ),
        question(
            id = 13,
            prompt = "Faktor persekutuan dari 12 dan 18 adalah ...",
            options = listOf("1, 2, 3, 6", "1, 2, 4, 6", "2, 3, 6, 9", "1, 3, 6, 12"),
            correct = "1, 2, 3, 6",
            explanation = "Faktor 12 adalah 1, 2, 3, 4, 6, 12 dan faktor 18 adalah 1, 2, 3, 6, 9, 18. Bilangan yang sama adalah 1, 2, 3, dan 6.",
            difficulty = "mudah",
            sourcePage = 48
        ),
        question(
            id = 14,
            prompt = "FPB dari 12 dan 18 adalah ...",
            options = listOf("2", "3", "6", "12"),
            correct = "6",
            explanation = "Faktor persekutuannya 1, 2, 3, dan 6. Yang terbesar adalah 6.",
            difficulty = "mudah",
            sourcePage = 48
        ),
        question(
            id = 15,
            prompt = "FPB dari 8 dan 20 adalah ...",
            options = listOf("2", "4", "8", "10"),
            correct = "4",
            explanation = "Faktor 8 adalah 1, 2, 4, 8 dan faktor 20 adalah 1, 2, 4, 5, 10, 20. Faktor persekutuan terbesar adalah 4.",
            difficulty = "mudah",
            sourcePage = 50
        ),
        question(
            id = 16,
            prompt = "Ada 24 mawar merah dan 18 mawar putih. Setiap vas harus berisi jumlah tiap warna yang sama. Vas paling banyak yang dapat digunakan adalah ...",
            options = listOf("3 vas", "4 vas", "6 vas", "8 vas"),
            correct = "6 vas",
            explanation = "Jumlah vas paling banyak adalah FPB dari 24 dan 18, yaitu 6. Setiap vas berisi 4 mawar merah dan 3 mawar putih.",
            difficulty = "sedang",
            sourcePage = 51
        ),
        question(
            id = 17,
            prompt = "Dania mempunyai 36 susu, 48 permen, dan 24 biskuit. Paket identik paling banyak yang dapat dibuat adalah ...",
            options = listOf("6 paket", "8 paket", "12 paket", "24 paket"),
            correct = "12 paket",
            explanation = "FPB dari 36, 48, dan 24 adalah 12. Setiap paket berisi 3 susu, 4 permen, dan 2 biskuit.",
            difficulty = "sedang",
            sourcePage = 53
        ),
        question(
            id = 18,
            prompt = "Bilangan prima di antara bilangan berikut adalah ...",
            options = listOf("21", "29", "39", "51"),
            correct = "29",
            explanation = "29 hanya mempunyai dua faktor, yaitu 1 dan 29. Bilangan lain dapat dibagi oleh 3 atau 7.",
            difficulty = "mudah",
            sourcePage = 53
        ),
        question(
            id = 19,
            prompt = "Bilangan 1 bukan bilangan prima karena ...",
            options = listOf("1 adalah bilangan ganjil", "1 hanya mempunyai satu faktor", "1 lebih kecil dari 2", "1 tidak dapat dijumlahkan"),
            correct = "1 hanya mempunyai satu faktor",
            explanation = "Bilangan prima harus mempunyai tepat dua faktor berbeda: 1 dan bilangan itu sendiri. Bilangan 1 hanya mempunyai satu faktor.",
            difficulty = "mudah",
            sourcePage = 53
        ),
        question(
            id = 20,
            prompt = "Daftar bilangan prima kurang dari 20 yang lengkap adalah ...",
            options = listOf("2, 3, 5, 7, 11, 13, 17, 19", "1, 2, 3, 5, 7, 11, 13, 17, 19", "2, 4, 6, 8, 10, 12, 14, 16, 18", "3, 5, 7, 9, 11, 13, 15, 17, 19"),
            correct = "2, 3, 5, 7, 11, 13, 17, 19",
            explanation = "Saringan Eratosthenes menghapus 1 dan semua bilangan komposit. Bilangan yang tersisa kurang dari 20 adalah 2, 3, 5, 7, 11, 13, 17, dan 19.",
            difficulty = "sedang",
            sourcePage = 54
        ),
        question(
            id = 21,
            prompt = "Faktorisasi prima dari 60 adalah ...",
            options = listOf("2 × 2 × 3 × 5", "2 × 3 × 10", "3 × 4 × 5", "2 × 2 × 15"),
            correct = "2 × 2 × 3 × 5",
            explanation = "Faktorisasi prima hanya memakai faktor prima. 60 = 2² × 3 × 5.",
            difficulty = "sedang",
            sourcePage = 59
        ),
        question(
            id = 22,
            prompt = "Faktorisasi prima dari 96 adalah ...",
            options = listOf("2 × 2 × 2 × 2 × 2 × 3", "2 × 2 × 2 × 12", "3 × 4 × 8", "2 × 3 × 16"),
            correct = "2 × 2 × 2 × 2 × 2 × 3",
            explanation = "Bagi 96 berulang dengan 2: 96, 48, 24, 12, 6, 3, lalu 1. Jadi 96 = 2⁵ × 3.",
            difficulty = "sedang",
            sourcePage = 59
        ),
        question(
            id = 23,
            prompt = "KPK dan FPB dari 42 dan 60 berturut-turut adalah ...",
            options = listOf("210 dan 6", "420 dan 6", "420 dan 12", "840 dan 6"),
            correct = "420 dan 6",
            explanation = "42 = 2 × 3 × 7 dan 60 = 2² × 3 × 5. KPK = 2² × 3 × 5 × 7 = 420, sedangkan FPB = 2 × 3 = 6.",
            difficulty = "menantang",
            sourcePage = 59
        ),
        question(
            id = 24,
            prompt = "KPK dan FPB dari 27 dan 81 berturut-turut adalah ...",
            options = listOf("81 dan 27", "27 dan 81", "243 dan 9", "81 dan 9"),
            correct = "81 dan 27",
            explanation = "27 = 3³ dan 81 = 3⁴. Pangkat terbesar menghasilkan KPK 81, sedangkan pangkat terkecil menghasilkan FPB 27.",
            difficulty = "menantang",
            sourcePage = 59
        ),
        question(
            id = 25,
            prompt = "Tiga lampu merah menyala setiap 15, 24, dan 36 detik. Jika menyala bersama pada pukul 15:30:00, ketiganya menyala bersama lagi pada ...",
            options = listOf("15:33:00", "15:34:00", "15:36:00", "15:42:00"),
            correct = "15:36:00",
            explanation = "KPK dari 15, 24, dan 36 adalah 360 detik atau 6 menit. Enam menit setelah 15:30 adalah 15:36.",
            difficulty = "menantang",
            sourcePage = 61
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
            id = "bab-2-soal-$id",
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
