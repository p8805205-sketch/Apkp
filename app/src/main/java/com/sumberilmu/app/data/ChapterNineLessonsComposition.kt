package com.sumberilmu.app.data

object ChapterNineLessonsComposition {
    val lessons = listOf(
        Subchapter(
            title = "Komposisi Bilangan",
            explanation = listOf(
                "Komposisi adalah menyusun sebuah bilangan dari nilai-nilai tempatnya.",
                "Setiap bagian dijumlahkan, misalnya 300.000 + 20.000 + 7.000 + 100.",
                "Tempat yang tidak memiliki nilai tetap diisi digit 0.",
                "Komposisi dapat berasal dari kartu angka, nilai tempat, atau pecahan uang."
            ),
            example = WorkedExample(
                question = "Susun bilangan dari 3 ratus ribuan, 2 puluh ribuan, 7 ribuan, dan 1 ratusan.",
                steps = listOf(
                    "Ubah setiap bagian menjadi nilai: 300.000, 20.000, 7.000, dan 100.",
                    "Jumlahkan 300.000 + 20.000 = 320.000.",
                    "Tambahkan 7.000 menjadi 327.000.",
                    "Tambahkan 100 dan isi puluhan serta satuan dengan nol."
                ),
                answer = "Bilangan yang terbentuk adalah 327.100."
            )
        ),
        Subchapter(
            title = "Dekomposisi Bilangan",
            explanation = listOf(
                "Dekomposisi adalah menguraikan bilangan menjadi penjumlahan nilai setiap digit.",
                "Digit 0 dapat diabaikan dalam bentuk penjumlahan karena nilainya nol.",
                "Dekomposisi membantu menjelaskan alasan suatu digit bernilai ribuan, ratusan, atau satuan.",
                "Hasil dekomposisi harus dapat dijumlahkan kembali menjadi bilangan semula."
            ),
            example = WorkedExample(
                question = "Uraikan 678.987 berdasarkan nilai tempat.",
                steps = listOf(
                    "Digit 6 bernilai 600.000.",
                    "Digit 7 bernilai 70.000 dan digit 8 bernilai 8.000.",
                    "Digit 9 bernilai 900, digit 8 bernilai 80, dan digit 7 bernilai 7.",
                    "Tuliskan seluruh nilai sebagai penjumlahan."
                ),
                answer = "678.987 = 600.000 + 70.000 + 8.000 + 900 + 80 + 7."
            )
        ),
        Subchapter(
            title = "Komposisi Pecahan Uang",
            explanation = listOf(
                "Jumlah uang diperoleh dengan mengalikan banyak lembar atau koin dengan nilai pecahannya.",
                "Pecahan berbeda dapat membentuk jumlah yang sama, sehingga satu harga dapat mempunyai beberapa komposisi pembayaran.",
                "Tuliskan subtotal setiap pecahan sebelum menjumlahkan agar perhitungan dapat diperiksa.",
                "Selisih uang dapat digunakan untuk menentukan kekurangan, harga pembelian, atau uang kembalian."
            ),
            example = WorkedExample(
                question = "Berapa jumlah uang Yosep: 5 × Rp100.000, 4 × Rp20.000, 3 × Rp10.000, 1 × Rp5.000, dan 4 × Rp2.000?",
                steps = listOf(
                    "Hitung subtotal: Rp500.000, Rp80.000, Rp30.000, Rp5.000, dan Rp8.000.",
                    "Jumlahkan Rp500.000 + Rp80.000 = Rp580.000.",
                    "Tambahkan Rp30.000 + Rp5.000 + Rp8.000 = Rp43.000.",
                    "Gabungkan kedua subtotal."
                ),
                answer = "Jumlah uang Yosep adalah Rp623.000."
            )
        )
    )
}
