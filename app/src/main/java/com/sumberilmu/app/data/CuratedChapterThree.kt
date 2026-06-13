package com.sumberilmu.app.data

object CuratedChapterThree {
    val chapter = Chapter(
        id = "bab-3",
        number = 3,
        title = "Bilangan Pecahan",
        sourcePageStart = 63,
        sourcePageEnd = 104,
        objective = "Mengurutkan, membandingkan, menjumlahkan, dan mengurangkan bilangan pecahan biasa maupun pecahan campuran dengan penyebut sama atau berbeda.",
        keywords = listOf(
            "pembilang",
            "penyebut",
            "pecahan biasa",
            "pecahan campuran",
            "pecahan senilai",
            "garis bilangan",
            "KPK penyebut",
            "penjumlahan",
            "pengurangan"
        ),
        summary = listOf(
            "Pecahan menyatakan bagian dari satu satuan atau bagian dari keseluruhan. Pembilang menunjukkan bagian yang dipilih, sedangkan penyebut menunjukkan jumlah bagian sama besar.",
            "Pecahan dapat dibandingkan dengan gambar, garis bilangan, menyamakan penyebut, atau membandingkan bilangan bulat pada pecahan campuran.",
            "Untuk menjumlahkan atau mengurangkan pecahan, penyebut harus sama. Jika berbeda, cari KPK penyebut lalu ubah ke pecahan senilai.",
            "Pecahan campuran dapat dihitung dengan mengubahnya ke pecahan biasa atau dengan memisahkan bagian bilangan bulat dan bagian pecahan.",
            "Hasil akhir perlu disederhanakan dan pecahan tidak wajar dapat diubah kembali menjadi pecahan campuran."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Makna Pecahan dan Bentuk-Bentuknya",
                explanation = listOf(
                    "Pecahan adalah bagian dari satu satuan atau bagian dari keseluruhan yang dibagi menjadi bagian sama besar.",
                    "Pada pecahan a/b, a adalah pembilang dan b adalah penyebut. Penyebut tidak boleh bernilai nol.",
                    "Pecahan biasa terdiri atas pembilang dan penyebut. Pecahan campuran terdiri atas bilangan bulat dan pecahan biasa.",
                    "Pecahan campuran dapat diubah menjadi pecahan biasa dengan rumus: bilangan bulat × penyebut + pembilang, lalu hasilnya ditempatkan sebagai pembilang baru."
                ),
                example = WorkedExample(
                    question = "Ubah pecahan campuran 2 3/4 menjadi pecahan biasa.",
                    steps = listOf(
                        "Kalikan bilangan bulat dengan penyebut: 2 × 4 = 8.",
                        "Tambahkan pembilang: 8 + 3 = 11.",
                        "Penyebut tetap 4.",
                        "Tuliskan hasil sebagai 11/4."
                    ),
                    answer = "2 3/4 = 11/4."
                )
            ),
            Subchapter(
                title = "Membandingkan dan Mengurutkan Pecahan",
                explanation = listOf(
                    "Pada garis bilangan, pecahan yang terletak lebih ke kanan mempunyai nilai lebih besar.",
                    "Pecahan berbeda penyebut dapat dibandingkan dengan menyamakan penyebut menggunakan KPK.",
                    "Jika penyebut sudah sama, bandingkan pembilangnya. Pembilang yang lebih besar menunjukkan pecahan yang lebih besar.",
                    "Untuk pecahan campuran, bandingkan dahulu bagian bilangan bulat. Jika sama, lanjutkan membandingkan bagian pecahannya."
                ),
                example = WorkedExample(
                    question = "Urutkan 2 3/4, 3 1/2, dan 7/8 dari yang terbesar.",
                    steps = listOf(
                        "Ubah pecahan campuran: 2 3/4 = 11/4 dan 3 1/2 = 7/2.",
                        "Samakan penyebut menjadi 8: 11/4 = 22/8 dan 7/2 = 28/8.",
                        "Bandingkan pembilang 28, 22, dan 7.",
                        "Susun dari pembilang terbesar."
                    ),
                    answer = "3 1/2, 2 3/4, lalu 7/8."
                )
            ),
            Subchapter(
                title = "Penjumlahan Pecahan Berpenyebut Sama",
                explanation = listOf(
                    "Jika penyebut sama, jumlahkan pembilang dan pertahankan penyebut.",
                    "Model gambar atau benda konkret dapat membantu melihat bahwa bagian-bagian yang ukurannya sama dapat langsung digabungkan.",
                    "Setelah dijumlahkan, sederhanakan hasil jika pembilang dan penyebut mempunyai faktor persekutuan."
                ),
                example = WorkedExample(
                    question = "Lukas memberikan 2 dari 10 penghapus kepada Asep dan 3 dari 10 kepada Yohana. Berapa bagian yang diberikan?",
                    steps = listOf(
                        "Tuliskan bagian Asep sebagai 2/10.",
                        "Tuliskan bagian Yohana sebagai 3/10.",
                        "Jumlahkan pembilang: 2 + 3 = 5, penyebut tetap 10.",
                        "Sederhanakan 5/10 dengan membagi pembilang dan penyebut oleh 5."
                    ),
                    answer = "5/10 = 1/2 bagian."
                )
            ),
            Subchapter(
                title = "Penjumlahan Pecahan Berbeda Penyebut",
                explanation = listOf(
                    "Pecahan dengan penyebut berbeda tidak dapat langsung dijumlahkan karena ukuran bagiannya berbeda.",
                    "Cari KPK dari penyebut, lalu ubah setiap pecahan menjadi pecahan senilai dengan penyebut tersebut.",
                    "Setelah penyebut sama, jumlahkan pembilang dan sederhanakan hasilnya.",
                    "Untuk pecahan campuran, gunakan cara mengubah ke pecahan biasa atau pisahkan bagian bulat dan bagian pecahan."
                ),
                example = WorkedExample(
                    question = "Hitung 1/3 + 4/6.",
                    steps = listOf(
                        "KPK dari 3 dan 6 adalah 6.",
                        "Ubah 1/3 menjadi 2/6.",
                        "Jumlahkan 2/6 + 4/6 = 6/6.",
                        "Sederhanakan 6/6 menjadi satu."
                    ),
                    answer = "1/3 + 4/6 = 1."
                )
            ),
            Subchapter(
                title = "Penjumlahan Pecahan Campuran",
                explanation = listOf(
                    "Cara pertama adalah mengubah seluruh pecahan campuran menjadi pecahan biasa, menyamakan penyebut, lalu menjumlahkan.",
                    "Cara kedua adalah menjumlahkan bagian bilangan bulat dan bagian pecahan secara terpisah.",
                    "Jika jumlah bagian pecahan mencapai atau melebihi satu, ubah ke pecahan campuran dan gabungkan dengan bagian bulat."
                ),
                example = WorkedExample(
                    question = "Hitung 2 1/5 + 3 1/5.",
                    steps = listOf(
                        "Jumlahkan bagian bulat: 2 + 3 = 5.",
                        "Jumlahkan bagian pecahan: 1/5 + 1/5 = 2/5.",
                        "Gabungkan bagian bulat dan pecahan.",
                        "Periksa bahwa 2/5 sudah paling sederhana."
                    ),
                    answer = "5 2/5."
                )
            ),
            Subchapter(
                title = "Pengurangan Pecahan Berpenyebut Sama",
                explanation = listOf(
                    "Jika penyebut sama, kurangkan pembilang dan pertahankan penyebut.",
                    "Pengurangan pecahan dapat dimaknai sebagai mencari sisa bagian dari keseluruhan.",
                    "Hasil pengurangan perlu disederhanakan jika masih memiliki faktor persekutuan."
                ),
                example = WorkedExample(
                    question = "Lukas harus melukis 2/3 bagian kertas dan sudah menyelesaikan 1/3. Berapa bagian yang belum dilukis?",
                    steps = listOf(
                        "Tuliskan bagian tugas sebagai 2/3.",
                        "Tuliskan bagian selesai sebagai 1/3.",
                        "Kurangkan pembilang: 2 - 1 = 1.",
                        "Penyebut tetap 3."
                    ),
                    answer = "Masih tersisa 1/3 bagian."
                )
            ),
            Subchapter(
                title = "Pengurangan Pecahan Berbeda Penyebut dan Pecahan Campuran",
                explanation = listOf(
                    "Samakan penyebut menggunakan KPK sebelum mengurangkan pecahan berbeda penyebut.",
                    "Pecahan campuran dapat diubah menjadi pecahan biasa agar proses peminjaman lebih mudah.",
                    "Alternatifnya, pisahkan bilangan bulat dan pecahan. Jika bagian pecahan atas lebih kecil, lakukan peminjaman satu dari bagian bulat.",
                    "Periksa hasil dengan penjumlahan balik: selisih + bilangan yang dikurangkan harus menghasilkan bilangan awal."
                ),
                example = WorkedExample(
                    question = "Komang memerlukan tali 4 1/2 m dan sudah memiliki 2 1/3 m. Berapa meter tali yang harus dibeli?",
                    steps = listOf(
                        "Ubah 4 1/2 menjadi 9/2 dan 2 1/3 menjadi 7/3.",
                        "KPK dari 2 dan 3 adalah 6.",
                        "Ubah menjadi 27/6 - 14/6 = 13/6.",
                        "Ubah 13/6 menjadi pecahan campuran."
                    ),
                    answer = "Komang harus membeli 2 1/6 m tali."
                )
            )
        ),
        quiz = ChapterThreeQuiz.questions
    )
}
