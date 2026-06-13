package com.sumberilmu.app.data

object ChapterNineLessonsOrdering {
    val lessons = listOf(
        Subchapter(
            title = "Membandingkan Bilangan",
            explanation = listOf(
                "Bandingkan jumlah digit terlebih dahulu; bilangan dengan lebih banyak digit bernilai lebih besar.",
                "Jika jumlah digit sama, bandingkan dari nilai tempat terbesar, yaitu ratus ribuan.",
                "Jika digit pada suatu tempat sama, lanjutkan ke tempat berikutnya sampai ditemukan perbedaan.",
                "Gunakan tanda > untuk lebih besar, < untuk lebih kecil, dan = untuk sama dengan."
            ),
            example = WorkedExample(
                question = "Bandingkan 599.198 dan 599.047.",
                steps = listOf(
                    "Ratus ribuan, puluh ribuan, dan ribuannya sama: 599 ribu.",
                    "Bandingkan ratusan: 1 pada 599.198 dan 0 pada 599.047.",
                    "Karena 1 lebih besar dari 0, perbandingan selesai.",
                    "Letakkan tanda yang sesuai."
                ),
                answer = "599.198 > 599.047."
            )
        ),
        Subchapter(
            title = "Mengurutkan Bilangan",
            explanation = listOf(
                "Urutan naik dimulai dari bilangan terkecil menuju terbesar.",
                "Urutan turun dimulai dari bilangan terbesar menuju terkecil.",
                "Gunakan tabel nilai tempat agar setiap digit dibandingkan pada kolom yang sama.",
                "Setelah mengurutkan, periksa kembali setiap pasangan bilangan yang berdekatan."
            ),
            example = WorkedExample(
                question = "Urutkan 432.543, 342.231, dan 232.231 dari terbesar.",
                steps = listOf(
                    "Bandingkan digit ratus ribuan: 4, 3, dan 2.",
                    "Digit 4 menghasilkan bilangan terbesar.",
                    "Digit 3 lebih besar dari digit 2.",
                    "Tuliskan urutan dari digit ratus ribuan terbesar."
                ),
                answer = "432.543, 342.231, 232.231."
            )
        )
    )
}
