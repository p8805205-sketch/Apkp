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
            "trapesium inklusif",
            "sisi sejajar",
            "diagonal",
            "simetri",
            "hierarki bangun"
        ),
        summary = listOf(
            "Tiga ruas garis dapat membentuk segitiga apabila jumlah panjang dua sisi mana pun lebih besar daripada sisi yang tersisa.",
            "Segitiga sama kaki mempunyai setidaknya dua sisi sama panjang. Karena itu, segitiga sama sisi juga dapat digolongkan sebagai segitiga sama kaki.",
            "Segitiga dapat dikelompokkan berdasarkan sudut menjadi lancip, siku-siku, dan tumpul; jumlah ketiga sudut dalam selalu 180°.",
            "Buku menggunakan pengertian trapesium inklusif: segi empat dengan setidaknya satu pasang sisi sejajar.",
            "Dengan pengertian tersebut, jajargenjang termasuk trapesium, tetapi bukan trapesium sama kaki karena tidak memiliki satu sumbu simetri dan sudut alasnya tidak sama besar.",
            "Belah ketupat dapat digolongkan sebagai jajargenjang sekaligus layang-layang.",
            "Persegi memiliki seluruh ciri persegi panjang dan belah ketupat, sehingga satu bangun dapat menjadi anggota beberapa kelompok sekaligus.",
            "Membandingkan bangun dilakukan melalui sisi, sisi sejajar, sudut, diagonal, dan simetri."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Syarat Terbentuknya Segitiga",
                explanation = listOf(
                    "Tidak semua tiga ruas garis dapat membentuk segitiga.",
                    "Jumlah panjang dua sisi terpendek harus lebih besar daripada sisi terpanjang.",
                    "Syarat yang sama berlaku untuk setiap pasangan sisi: a + b > c, a + c > b, dan b + c > a.",
                    "Jika jumlah dua sisi sama dengan atau lebih kecil dari sisi ketiga, ketiganya tidak membentuk segitiga."
                ),
                example = WorkedExample(
                    question = "Apakah batang 5 cm, 7 cm, dan 1 cm dapat membentuk segitiga?",
                    steps = listOf(
                        "Urutkan panjang sisi: 1, 5, dan 7.",
                        "Jumlahkan dua sisi terpendek: 1 + 5 = 6.",
                        "Bandingkan 6 dengan sisi terpanjang 7.",
                        "Karena 6 tidak lebih besar dari 7, syarat segitiga tidak terpenuhi."
                    ),
                    answer = "Tidak, ketiga batang tidak dapat membentuk segitiga."
                )
            ),
            Subchapter(
                title = "Segitiga Berdasarkan Panjang Sisi",
                explanation = listOf(
                    "Segitiga sama kaki mempunyai setidaknya dua sisi sama panjang dan dua sudut alas sama besar.",
                    "Segitiga sama sisi mempunyai tiga sisi sama panjang dan tiga sudut sama besar.",
                    "Karena mempunyai lebih dari dua sisi sama panjang, segitiga sama sisi juga memenuhi ciri segitiga sama kaki.",
                    "Segitiga sembarang mempunyai tiga sisi berbeda panjang."
                ),
                example = WorkedExample(
                    question = "Mengapa segitiga sama sisi juga dapat disebut segitiga sama kaki?",
                    steps = listOf(
                        "Segitiga sama kaki mensyaratkan setidaknya dua sisi sama panjang.",
                        "Segitiga sama sisi mempunyai tiga sisi sama panjang.",
                        "Tiga sisi sama panjang tentu mencakup adanya dua sisi sama panjang.",
                        "Jadi semua ciri segitiga sama kaki dimiliki oleh segitiga sama sisi."
                    ),
                    answer = "Karena segitiga sama sisi mempunyai setidaknya dua sisi sama panjang."
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
                title = "Trapesium dan Jajargenjang",
                explanation = listOf(
                    "Dalam buku ini, trapesium adalah segi empat yang mempunyai setidaknya satu pasang sisi sejajar.",
                    "Jajargenjang mempunyai dua pasang sisi berhadapan sejajar dan sama panjang, sehingga memenuhi pengertian trapesium tersebut.",
                    "Jajargenjang bukan trapesium sama kaki karena tidak memiliki satu sumbu simetri dan sudut pada alasnya tidak sama besar.",
                    "Sudut berhadapan pada jajargenjang sama besar, sedangkan sudut yang berdekatan berjumlah 180°."
                ),
                example = WorkedExample(
                    question = "Bolehkah jajargenjang disebut trapesium menurut pengertian yang dipakai buku?",
                    steps = listOf(
                        "Trapesium memiliki setidaknya satu pasang sisi sejajar.",
                        "Jajargenjang memiliki dua pasang sisi sejajar.",
                        "Dua pasang berarti syarat setidaknya satu pasang terpenuhi.",
                        "Periksa trapesium sama kaki secara terpisah karena memerlukan satu sumbu simetri."
                    ),
                    answer = "Ya. Jajargenjang termasuk trapesium, tetapi bukan trapesium sama kaki."
                )
            ),
            Subchapter(
                title = "Persegi Panjang dan Jajargenjang",
                explanation = listOf(
                    "Jajargenjang mempunyai sisi berhadapan sejajar dan sama panjang serta sudut berhadapan sama besar.",
                    "Persegi panjang mempunyai semua ciri jajargenjang.",
                    "Ciri tambahan persegi panjang adalah salah satu sudutnya siku-siku; akibatnya semua sudutnya siku-siku.",
                    "Karena itu, persegi panjang adalah jajargenjang khusus."
                ),
                example = WorkedExample(
                    question = "Mengapa persegi panjang dapat digolongkan sebagai jajargenjang?",
                    steps = listOf(
                        "Periksa sisi berhadapan: sejajar dan sama panjang.",
                        "Periksa sudut berhadapan: sama besar.",
                        "Semua ciri jajargenjang terpenuhi.",
                        "Sudut siku-siku merupakan ciri tambahan."
                    ),
                    answer = "Persegi panjang adalah jajargenjang yang salah satu sudutnya siku-siku."
                )
            ),
            Subchapter(
                title = "Belah Ketupat, Layang-Layang, dan Jajargenjang",
                explanation = listOf(
                    "Belah ketupat mempunyai empat sisi sama panjang dan sisi berhadapan sejajar, sehingga termasuk jajargenjang.",
                    "Belah ketupat juga mempunyai dua pasang sisi berurutan sama panjang dan diagonal sebagai sumbu simetri, sehingga termasuk layang-layang.",
                    "Diagonal belah ketupat saling tegak lurus, saling membagi dua, dan keduanya merupakan sumbu simetri.",
                    "Pada layang-layang umum, hanya satu diagonal yang menjadi sumbu simetri."
                ),
                example = WorkedExample(
                    question = "Mengapa belah ketupat dapat digolongkan sebagai jajargenjang dan layang-layang?",
                    steps = listOf(
                        "Sisi berhadapan belah ketupat sejajar, sehingga ciri jajargenjang terpenuhi.",
                        "Belah ketupat mempunyai dua pasang sisi berurutan sama panjang.",
                        "Diagonalnya berpotongan tegak lurus dan menjadi sumbu simetri.",
                        "Ciri-ciri tersebut juga memenuhi pengertian layang-layang."
                    ),
                    answer = "Belah ketupat termasuk jajargenjang sekaligus layang-layang."
                )
            ),
            Subchapter(
                title = "Persegi, Persegi Panjang, dan Belah Ketupat",
                explanation = listOf(
                    "Persegi mempunyai semua ciri persegi panjang: sisi berhadapan sejajar, empat sudut siku-siku, dan diagonal sama panjang.",
                    "Persegi juga mempunyai semua ciri belah ketupat: empat sisi sama panjang dan diagonal saling tegak lurus.",
                    "Persegi adalah persegi panjang yang sisi-sisi berurutannya sama panjang.",
                    "Persegi adalah belah ketupat yang salah satu sudutnya siku-siku."
                ),
                example = WorkedExample(
                    question = "Apakah persegi dapat disebut persegi panjang dan belah ketupat?",
                    steps = listOf(
                        "Periksa empat sudutnya: semuanya siku-siku.",
                        "Periksa keempat sisinya: semuanya sama panjang.",
                        "Ciri persegi panjang dan belah ketupat sama-sama terpenuhi.",
                        "Satu bangun boleh berada dalam lebih dari satu kelompok."
                    ),
                    answer = "Ya, persegi merupakan persegi panjang sekaligus belah ketupat khusus."
                )
            )
        ),
        quiz = ChapterSevenQuiz.questions
    )
}
