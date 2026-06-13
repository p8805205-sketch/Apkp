package com.sumberilmu.app.data

object CuratedChapterOne {
    val chapter = Chapter(
        id = "bab-1",
        number = 1,
        title = "Bilangan Cacah Sampai 100.000",
        sourcePageStart = 1,
        sourcePageEnd = 28,
        objective = "Membaca, menulis, menentukan nilai tempat, membandingkan, mengurutkan, menyusun, menguraikan, menghitung operasi, dan memecahkan masalah yang berkaitan dengan bilangan cacah sampai 100.000.",
        keywords = listOf(
            "bilangan cacah",
            "nilai tempat",
            "komposisi",
            "dekomposisi",
            "penjumlahan",
            "pengurangan",
            "perkalian",
            "pembagian"
        ),
        summary = listOf(
            "Bilangan sampai 100.000 dibaca dan ditulis dengan memperhatikan urutan nilai tempat: satuan, puluhan, ratusan, ribuan, puluh ribuan, dan seratus ribuan.",
            "Dua bilangan dibandingkan dari nilai tempat terbesar. Jika nilainya sama, lanjutkan ke nilai tempat berikutnya sampai ditemukan perbedaan.",
            "Komposisi berarti menyusun bilangan dari bagian nilai tempat, sedangkan dekomposisi berarti menguraikan bilangan menjadi nilai setiap digitnya.",
            "Penjumlahan dan pengurangan dilakukan dengan menyejajarkan nilai tempat. Perkalian dapat diurai menurut nilai tempat, sedangkan pembagian dapat diperiksa dengan perkalian balik.",
            "Masalah sehari-hari seperti harga barang, jumlah uang, dan pembagian uang dapat diterjemahkan menjadi kalimat matematika sebelum dihitung."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Membaca, Menulis, dan Menentukan Nilai Tempat",
                explanation = listOf(
                    "Setiap digit memiliki nilai sesuai posisinya. Pada 14.500, angka 1 bernilai 10.000, angka 4 bernilai 4.000, dan angka 5 bernilai 500.",
                    "Saat menulis bilangan dari kata-kata, tentukan lebih dahulu nilai puluh ribuan, ribuan, ratusan, puluhan, dan satuannya.",
                    "Saat membaca bilangan, kelompokkan bagian ribuan dan bagian satuan. Contohnya, 66.500 dibaca enam puluh enam ribu lima ratus.",
                    "Digit nol tetap penting karena menjaga posisi nilai tempat, walaupun nilainya nol."
                ),
                example = WorkedExample(
                    question = "Tuliskan 'empat belas ribu lima ratus' dalam angka dan jelaskan nilai tempatnya.",
                    steps = listOf(
                        "Empat belas ribu terdiri dari 1 puluh ribuan dan 4 ribuan.",
                        "Lima ratus menempati nilai tempat ratusan.",
                        "Tidak ada puluhan dan satuan, sehingga keduanya diisi nol.",
                        "Susun digitnya menjadi 1, 4, 5, 0, 0."
                    ),
                    answer = "14.500; nilai digitnya adalah 10.000 + 4.000 + 500."
                )
            ),
            Subchapter(
                title = "Membandingkan dan Mengurutkan Bilangan",
                explanation = listOf(
                    "Mulailah membandingkan dari digit paling kiri karena digit tersebut mempunyai nilai tempat terbesar.",
                    "Jika digit puluh ribuannya berbeda, bilangan dengan digit puluh ribuan lebih besar merupakan bilangan yang lebih besar.",
                    "Jika digit awal sama, bandingkan digit berikutnya secara berurutan sampai ditemukan perbedaan.",
                    "Untuk mengurutkan beberapa bilangan, lakukan perbandingan yang sama lalu susun dari terkecil ke terbesar atau sebaliknya."
                ),
                example = WorkedExample(
                    question = "Urutkan 56.560, 65.750, 57.000, dan 75.360 dari yang paling kecil.",
                    steps = listOf(
                        "Bilangan lima puluh ribuan lebih kecil daripada enam puluh dan tujuh puluh ribuan.",
                        "Di antara 56.560 dan 57.000, bandingkan digit ribuan: 6 lebih kecil daripada 7.",
                        "65.750 lebih kecil daripada 75.360 karena digit puluh ribuannya 6 dan 7.",
                        "Susun seluruh bilangan berdasarkan hasil perbandingan."
                    ),
                    answer = "56.560, 57.000, 65.750, 75.360."
                )
            ),
            Subchapter(
                title = "Komposisi dan Dekomposisi Bilangan",
                explanation = listOf(
                    "Komposisi adalah proses menyatukan beberapa nilai tempat menjadi satu bilangan.",
                    "Tiga puluh ribu, delapan ribu, dan enam ratus dikomposisikan menjadi 38.600.",
                    "Dekomposisi adalah proses menguraikan bilangan menjadi jumlah nilai setiap digit.",
                    "Satu bilangan dapat mempunyai beberapa bentuk komposisi uang, selama total nilainya tetap sama."
                ),
                example = WorkedExample(
                    question = "Susun bilangan dari 3 lembar 10.000, 8 lembar 1.000, dan 6 keping 100.",
                    steps = listOf(
                        "Hitung nilai puluh ribuan: 3 × 10.000 = 30.000.",
                        "Hitung nilai ribuan: 8 × 1.000 = 8.000.",
                        "Hitung nilai ratusan: 6 × 100 = 600.",
                        "Jumlahkan semua nilai tempat."
                    ),
                    answer = "30.000 + 8.000 + 600 = 38.600."
                )
            ),
            Subchapter(
                title = "Penjumlahan dan Pengurangan",
                explanation = listOf(
                    "Tuliskan bilangan dengan posisi satuan, puluhan, ratusan, ribuan, dan puluh ribuan yang sejajar.",
                    "Pada penjumlahan, jumlahkan dari satuan ke nilai tempat yang lebih besar dan lakukan penyimpanan jika diperlukan.",
                    "Pada pengurangan, kurangkan dari satuan ke kiri dan lakukan peminjaman jika digit yang dikurangi lebih kecil.",
                    "Periksa kewajaran hasil dengan perkiraan atau operasi kebalikan."
                ),
                example = WorkedExample(
                    question = "Nisa menerima 57.500 dari Ibu dan 22.000 dari Ayah. Berapa jumlah uangnya?",
                    steps = listOf(
                        "Uraikan 57.500 menjadi 50.000 + 7.000 + 500.",
                        "Uraikan 22.000 menjadi 20.000 + 2.000.",
                        "Jumlahkan nilai tempat yang sama: 70.000 + 9.000 + 500.",
                        "Gabungkan hasilnya."
                    ),
                    answer = "79.500."
                )
            ),
            Subchapter(
                title = "Perkalian dan Pembagian",
                explanation = listOf(
                    "Perkalian dapat dipandang sebagai penjumlahan berulang atau diuraikan berdasarkan nilai tempat pengalinya.",
                    "Contoh 12 × 5.000 dapat diurai menjadi 10 × 5.000 dan 2 × 5.000.",
                    "Pembagian sama rata menentukan banyaknya bagian yang diterima setiap kelompok.",
                    "Hasil pembagian dapat diperiksa dengan mengalikan hasil bagi dengan pembaginya."
                ),
                example = WorkedExample(
                    question = "Uang 64.000 dibagikan sama rata kepada 4 anak. Berapa bagian setiap anak?",
                    steps = listOf(
                        "Tuliskan kalimat matematika 64.000 ÷ 4.",
                        "Bagilah 64 ribuan menjadi empat bagian yang sama.",
                        "Setiap bagian memperoleh 16 ribuan.",
                        "Periksa: 16.000 × 4 = 64.000."
                    ),
                    answer = "Setiap anak menerima 16.000."
                )
            )
        ),
        quiz = ChapterOneQuiz.questions
    )
}
