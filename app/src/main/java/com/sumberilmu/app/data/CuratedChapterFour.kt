package com.sumberilmu.app.data

object CuratedChapterFour {
    val chapter = Chapter(
        id = "bab-4",
        number = 4,
        title = "Keliling Bangun Datar",
        sourcePageStart = 105,
        sourcePageEnd = 130,
        objective = "Memahami makna keliling, menghitung keliling berbagai bangun datar dan bangun gabungan, menentukan panjang sisi yang belum diketahui, serta menyelesaikan masalah sehari-hari yang berkaitan dengan keliling.",
        keywords = listOf(
            "keliling",
            "batas bangun",
            "panjang sisi",
            "segitiga",
            "segi empat",
            "segi banyak",
            "bangun beraturan",
            "bangun gabungan"
        ),
        summary = listOf(
            "Keliling adalah jumlah panjang seluruh sisi yang membentuk batas terluar sebuah bangun datar.",
            "Keliling segitiga diperoleh dengan menjumlahkan ketiga sisinya. Pada segitiga sama sisi, keliling dapat dihitung dengan 3 × panjang sisi.",
            "Keliling persegi adalah 4 × sisi, sedangkan keliling persegi panjang adalah 2 × (panjang + lebar).",
            "Keliling jajargenjang, belah ketupat, layang-layang, dan trapesium tetap dihitung dari jumlah seluruh sisi luarnya dengan memanfaatkan sifat sisi yang sama panjang.",
            "Pada segi banyak beraturan, keliling = banyak sisi × panjang satu sisi.",
            "Untuk bangun gabungan, hanya sisi yang terlihat dari luar yang dihitung. Sisi yang berhimpit di bagian dalam tidak termasuk keliling."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Memahami Konsep Keliling",
                explanation = listOf(
                    "Keliling dapat dibayangkan sebagai panjang lintasan ketika seseorang berjalan tepat mengikuti tepi sebuah bangun.",
                    "Satuan keliling adalah satuan panjang, misalnya milimeter, sentimeter, meter, atau kilometer.",
                    "Semua sisi pada batas terluar harus dihitung tepat satu kali.",
                    "Sebelum menghitung, pastikan seluruh panjang sisi menggunakan satuan yang sama."
                ),
                example = WorkedExample(
                    question = "Sebuah bingkai mempunyai sisi 8 cm, 5 cm, 8 cm, dan 5 cm. Berapa kelilingnya?",
                    steps = listOf(
                        "Tuliskan seluruh sisi yang membentuk batas bingkai.",
                        "Jumlahkan 8 + 5 + 8 + 5.",
                        "Kelompokkan sisi yang sama: 2 × 8 dan 2 × 5.",
                        "Pastikan jawaban menggunakan satuan sentimeter."
                    ),
                    answer = "Keliling bingkai adalah 26 cm."
                )
            ),
            Subchapter(
                title = "Keliling Segitiga",
                explanation = listOf(
                    "Keliling segitiga adalah jumlah panjang ketiga sisinya.",
                    "Segitiga sama sisi mempunyai tiga sisi sama panjang sehingga kelilingnya 3 × sisi.",
                    "Segitiga sama kaki mempunyai dua sisi sama panjang. Jumlahkan kedua sisi tersebut dengan panjang alas.",
                    "Jika keliling dan dua sisi diketahui, sisi ketiga dapat dicari dengan mengurangkan keliling dengan jumlah dua sisi lainnya."
                ),
                example = WorkedExample(
                    question = "Segitiga sama kaki mempunyai dua sisi 12 cm dan alas 8 cm. Berapa kelilingnya?",
                    steps = listOf(
                        "Tulis panjang ketiga sisi: 12 cm, 12 cm, dan 8 cm.",
                        "Jumlahkan kedua sisi yang sama: 12 + 12 = 24.",
                        "Tambahkan panjang alas: 24 + 8.",
                        "Tuliskan satuan pada hasil akhir."
                    ),
                    answer = "Keliling segitiga adalah 32 cm."
                )
            ),
            Subchapter(
                title = "Keliling Persegi dan Persegi Panjang",
                explanation = listOf(
                    "Persegi mempunyai empat sisi sama panjang sehingga K = 4 × s.",
                    "Persegi panjang mempunyai dua pasang sisi sama panjang sehingga K = 2 × (p + l).",
                    "Jika keliling persegi diketahui, panjang sisi diperoleh dengan membagi keliling dengan 4.",
                    "Jika keliling dan panjang persegi panjang diketahui, lebar dapat dicari dari setengah keliling dikurangi panjang."
                ),
                example = WorkedExample(
                    question = "Keliling persegi panjang 54 cm dan panjangnya 17 cm. Tentukan lebarnya.",
                    steps = listOf(
                        "Gunakan K = 2 × (p + l).",
                        "Setengah keliling adalah 54 ÷ 2 = 27.",
                        "Karena p + l = 27, maka l = 27 - 17.",
                        "Periksa: 2 × (17 + 10) = 54."
                    ),
                    answer = "Lebar persegi panjang adalah 10 cm."
                )
            ),
            Subchapter(
                title = "Keliling Segi Empat Lainnya",
                explanation = listOf(
                    "Jajargenjang mempunyai dua pasang sisi berhadapan sama panjang, sehingga kelilingnya 2 × (sisi pertama + sisi kedua).",
                    "Belah ketupat mempunyai empat sisi sama panjang, sehingga kelilingnya 4 × sisi.",
                    "Layang-layang mempunyai dua pasang sisi berdekatan sama panjang, sehingga kelilingnya 2 × (sisi pertama + sisi kedua).",
                    "Trapesium dapat mempunyai panjang sisi berbeda-beda, sehingga keempat sisinya dijumlahkan langsung."
                ),
                example = WorkedExample(
                    question = "Layang-layang mempunyai dua sisi 15 cm dan dua sisi 9 cm. Berapa kelilingnya?",
                    steps = listOf(
                        "Kelompokkan dua sisi 15 cm dan dua sisi 9 cm.",
                        "Hitung 2 × 15 = 30.",
                        "Hitung 2 × 9 = 18.",
                        "Jumlahkan 30 + 18."
                    ),
                    answer = "Keliling layang-layang adalah 48 cm."
                )
            ),
            Subchapter(
                title = "Keliling Segi Banyak",
                explanation = listOf(
                    "Segi banyak adalah bangun tertutup yang dibatasi oleh tiga atau lebih ruas garis.",
                    "Pada segi banyak beraturan, semua sisi sama panjang sehingga keliling dapat dihitung dengan banyak sisi × panjang sisi.",
                    "Pada segi banyak tidak beraturan, ukur atau tentukan setiap sisi lalu jumlahkan seluruh sisi luarnya.",
                    "Gunakan penandaan sisi yang sama panjang untuk menghindari penghitungan berulang."
                ),
                example = WorkedExample(
                    question = "Sebuah segi enam beraturan mempunyai sisi 7 cm. Berapa kelilingnya?",
                    steps = listOf(
                        "Segi enam mempunyai enam sisi.",
                        "Semua sisi sama panjang karena bangun beraturan.",
                        "Kalikan banyak sisi dengan panjang sisi: 6 × 7.",
                        "Tuliskan hasil dalam sentimeter."
                    ),
                    answer = "Keliling segi enam adalah 42 cm."
                )
            ),
            Subchapter(
                title = "Keliling Bangun Gabungan dan Pemecahan Masalah",
                explanation = listOf(
                    "Bangun gabungan tersusun dari dua atau lebih bangun datar yang saling menempel.",
                    "Keliling bangun gabungan hanya menghitung ruas garis pada batas terluar.",
                    "Sisi yang berhimpit menjadi bagian dalam dan tidak ikut dihitung. Jika menjumlahkan keliling bangun penyusun, kurangi dua kali panjang sisi yang berhimpit.",
                    "Masalah pagar, pita, lintasan, dan bingkai biasanya menggunakan konsep keliling. Perhatikan bagian yang tidak dipagari, jumlah putaran, atau tambahan untuk sambungan."
                ),
                example = WorkedExample(
                    question = "Persegi sisi 5 cm ditempel pada sisi persegi panjang 12 cm × 7 cm dengan sisi berhimpit 5 cm. Tentukan keliling gabungannya.",
                    steps = listOf(
                        "Keliling persegi panjang = 2 × (12 + 7) = 38 cm.",
                        "Keliling persegi = 4 × 5 = 20 cm.",
                        "Jumlah awal = 38 + 20 = 58 cm.",
                        "Kurangi dua kali sisi berhimpit: 58 - (2 × 5) = 48 cm."
                    ),
                    answer = "Keliling bangun gabungan adalah 48 cm."
                )
            )
        ),
        quiz = ChapterFourQuiz.questions
    )
}
