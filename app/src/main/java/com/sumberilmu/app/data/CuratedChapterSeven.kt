package com.sumberilmu.app.data

object CuratedChapterSeven {
    val chapter = Chapter(
        id = "bab-7",
        number = 7,
        title = "Membandingkan Ciri-Ciri Bangun Datar",
        sourcePageStart = 191,
        sourcePageEnd = 234,
        objective = "Membandingkan dan mengelompokkan segitiga serta segi empat berdasarkan panjang sisi, besar sudut, sisi sejajar, diagonal, dan simetri.",
        keywords = listOf(
            "syarat segitiga",
            "segitiga sama sisi",
            "segitiga sama kaki",
            "segitiga sembarang",
            "segi empat",
            "sisi sejajar",
            "diagonal",
            "simetri",
            "persamaan",
            "perbedaan"
        ),
        summary = listOf(
            "Tiga ruas garis dapat membentuk segitiga apabila jumlah panjang dua sisi mana pun lebih besar daripada sisi yang tersisa.",
            "Segitiga dapat dikelompokkan berdasarkan sisi menjadi sama sisi, sama kaki, dan sembarang; berdasarkan sudut menjadi lancip, siku-siku, dan tumpul.",
            "Jumlah ketiga sudut dalam setiap segitiga selalu 180°.",
            "Segi empat dapat dibandingkan melalui panjang sisi, pasangan sisi sejajar, besar sudut, sifat diagonal, dan banyak sumbu simetri.",
            "Persegi memiliki seluruh ciri persegi panjang dan belah ketupat, ditambah empat sisi sama panjang dan empat sudut siku-siku.",
            "Satu bangun dapat menjadi anggota lebih dari satu kelompok jika memenuhi seluruh ciri kelompok tersebut.",
            "Membandingkan bangun sebaiknya dilakukan dengan tabel ciri agar persamaan dan perbedaannya terlihat jelas."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Syarat Terbentuknya Segitiga",
                explanation = listOf(
                    "Tidak semua tiga ruas garis dapat membentuk segitiga.",
                    "Jumlah panjang dua sisi terpendek harus lebih besar daripada sisi terpanjang.",
                    "Syarat yang sama berlaku untuk setiap pasangan sisi: a + b > c, a + c > b, dan b + c > a.",
                    "Jika jumlah dua sisi tepat sama dengan sisi ketiga, bangun akan menjadi garis lurus, bukan segitiga."
                ),
                example = WorkedExample(
                    question = "Apakah batang 4 cm, 6 cm, dan 9 cm dapat membentuk segitiga?",
                    steps = listOf(
                        "Urutkan panjang sisi: 4, 6, dan 9.",
                        "Jumlahkan dua sisi terpendek: 4 + 6 = 10.",
                        "Bandingkan 10 dengan sisi terpanjang 9.",
                        "Karena 10 > 9, ketiga batang dapat membentuk segitiga."
                    ),
                    answer = "Ya, ketiga batang dapat membentuk segitiga."
                )
            ),
            Subchapter(
                title = "Segitiga Berdasarkan Panjang Sisi",
                explanation = listOf(
                    "Segitiga sama sisi mempunyai tiga sisi sama panjang dan tiga sudut sama besar.",
                    "Segitiga sama kaki mempunyai dua sisi sama panjang dan dua sudut alas sama besar.",
                    "Segitiga sembarang mempunyai tiga sisi berbeda panjang.",
                    "Tanda garis kecil pada gambar digunakan untuk menunjukkan sisi-sisi yang sama panjang."
                ),
                example = WorkedExample(
                    question = "Sebuah segitiga mempunyai sisi 7 cm, 7 cm, dan 10 cm. Termasuk jenis apa?",
                    steps = listOf(
                        "Bandingkan ketiga panjang sisi.",
                        "Dua sisi bernilai 7 cm.",
                        "Sisi ketiga bernilai 10 cm.",
                        "Dua sisi sama panjang menunjukkan segitiga sama kaki."
                    ),
                    answer = "Segitiga tersebut merupakan segitiga sama kaki."
                )
            ),
            Subchapter(
                title = "Segitiga Berdasarkan Besar Sudut",
                explanation = listOf(
                    "Segitiga lancip mempunyai tiga sudut yang semuanya kurang dari 90°.",
                    "Segitiga siku-siku mempunyai tepat satu sudut 90°.",
                    "Segitiga tumpul mempunyai tepat satu sudut lebih dari 90°.",
                    "Satu segitiga tidak mungkin mempunyai dua sudut siku-siku atau dua sudut tumpul karena jumlah sudutnya 180°."
                ),
                example = WorkedExample(
                    question = "Segitiga mempunyai sudut 35°, 55°, dan 90°. Apa jenisnya berdasarkan sudut?",
                    steps = listOf(
                        "Periksa apakah ada sudut 90°.",
                        "Salah satu sudut tepat 90°.",
                        "Dua sudut lainnya kurang dari 90°.",
                        "Gunakan ciri segitiga siku-siku."
                    ),
                    answer = "Segitiga tersebut adalah segitiga siku-siku."
                )
            ),
            Subchapter(
                title = "Jumlah Sudut Dalam Segitiga",
                explanation = listOf(
                    "Jumlah ketiga sudut dalam setiap segitiga selalu 180°.",
                    "Sudut yang belum diketahui dapat dicari dengan mengurangkan dua sudut yang diketahui dari 180°.",
                    "Segitiga sama sisi mempunyai tiga sudut 60°.",
                    "Pada segitiga sama kaki, dua sudut alas sama besar."
                ),
                example = WorkedExample(
                    question = "Dua sudut segitiga berukuran 48° dan 72°. Tentukan sudut ketiga.",
                    steps = listOf(
                        "Jumlahkan dua sudut: 48° + 72° = 120°.",
                        "Jumlah sudut segitiga adalah 180°.",
                        "Kurangkan 180° - 120°.",
                        "Periksa jumlah ketiga sudut."
                    ),
                    answer = "Sudut ketiga berukuran 60°."
                )
            ),
            Subchapter(
                title = "Persegi dan Persegi Panjang",
                explanation = listOf(
                    "Persegi mempunyai empat sisi sama panjang, dua pasang sisi sejajar, dan empat sudut siku-siku.",
                    "Persegi panjang mempunyai sisi berhadapan sama panjang, dua pasang sisi sejajar, dan empat sudut siku-siku.",
                    "Diagonal keduanya sama panjang dan saling membagi dua.",
                    "Persegi mempunyai empat sumbu simetri, sedangkan persegi panjang bukan persegi mempunyai dua."
                ),
                example = WorkedExample(
                    question = "Mengapa persegi juga dapat disebut persegi panjang?",
                    steps = listOf(
                        "Periksa jumlah sudut persegi: semuanya 90°.",
                        "Periksa sisi berhadapan: sejajar dan sama panjang.",
                        "Ciri tersebut memenuhi definisi persegi panjang.",
                        "Persegi memiliki sifat tambahan berupa empat sisi sama panjang."
                    ),
                    answer = "Karena persegi memenuhi seluruh ciri persegi panjang."
                )
            ),
            Subchapter(
                title = "Jajargenjang dan Trapesium",
                explanation = listOf(
                    "Jajargenjang mempunyai dua pasang sisi berhadapan sejajar dan sama panjang.",
                    "Sudut berhadapan pada jajargenjang sama besar, sedangkan sudut yang berdekatan berjumlah 180°.",
                    "Trapesium mempunyai paling sedikit satu pasang sisi sejajar.",
                    "Trapesium sama kaki mempunyai dua sisi tidak sejajar sama panjang serta pasangan sudut alas yang sama besar."
                ),
                example = WorkedExample(
                    question = "Apa perbedaan utama jajargenjang dan trapesium biasa?",
                    steps = listOf(
                        "Hitung pasangan sisi sejajar pada jajargenjang.",
                        "Jajargenjang mempunyai dua pasang sisi sejajar.",
                        "Periksa trapesium biasa.",
                        "Trapesium dikenali dengan satu pasangan sisi sejajar."
                    ),
                    answer = "Jajargenjang mempunyai dua pasang sisi sejajar, sedangkan trapesium biasa satu pasang."
                )
            ),
            Subchapter(
                title = "Belah Ketupat dan Layang-Layang",
                explanation = listOf(
                    "Belah ketupat mempunyai empat sisi sama panjang dan dua pasang sisi berhadapan sejajar.",
                    "Diagonal belah ketupat saling tegak lurus dan saling membagi dua.",
                    "Layang-layang mempunyai dua pasang sisi berdekatan sama panjang.",
                    "Diagonal layang-layang saling tegak lurus, tetapi hanya satu diagonal yang membagi diagonal lainnya."
                ),
                example = WorkedExample(
                    question = "Apa persamaan belah ketupat dan layang-layang?",
                    steps = listOf(
                        "Periksa hubungan diagonal kedua bangun.",
                        "Kedua bangun mempunyai diagonal yang saling tegak lurus.",
                        "Periksa sisi sama panjangnya.",
                        "Keduanya mempunyai dua pasang sisi sama panjang, tetapi susunannya berbeda."
                    ),
                    answer = "Keduanya mempunyai pasangan sisi sama panjang dan diagonal yang saling tegak lurus."
                )
            ),
            Subchapter(
                title = "Membandingkan, Mengelompokkan, dan Menemukan Hierarki",
                explanation = listOf(
                    "Tabel ciri membantu membandingkan jumlah sisi sama panjang, sisi sejajar, sudut, diagonal, dan simetri.",
                    "Persegi termasuk persegi panjang karena mempunyai empat sudut siku-siku dan sisi berhadapan sejajar.",
                    "Persegi juga termasuk belah ketupat karena keempat sisinya sama panjang.",
                    "Kebalikannya tidak selalu benar: persegi panjang belum tentu persegi dan belah ketupat belum tentu persegi."
                ),
                example = WorkedExample(
                    question = "Apakah setiap belah ketupat merupakan persegi?",
                    steps = listOf(
                        "Periksa ciri belah ketupat: empat sisi sama panjang.",
                        "Periksa syarat tambahan persegi: empat sudut siku-siku.",
                        "Belah ketupat tidak selalu mempunyai sudut 90°.",
                        "Karena syarat persegi belum tentu terpenuhi, jawabannya tidak."
                    ),
                    answer = "Tidak. Hanya belah ketupat dengan empat sudut siku-siku yang merupakan persegi."
                )
            )
        ),
        quiz = ChapterSevenQuiz.questions
    )
}
