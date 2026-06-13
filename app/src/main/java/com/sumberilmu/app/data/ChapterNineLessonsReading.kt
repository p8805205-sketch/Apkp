package com.sumberilmu.app.data

object ChapterNineLessonsReading {
    val lessons = listOf(
        Subchapter(
            title = "Mengenal Bilangan Cacah Sampai 1.000.000",
            explanation = listOf(
                "Bilangan cacah dimulai dari 0, 1, 2, 3, dan seterusnya tanpa pecahan atau bilangan negatif.",
                "Pada bab ini, bilangan mempunyai tempat ratus ribuan, puluh ribuan, ribuan, ratusan, puluhan, dan satuan.",
                "Bilangan 1.000.000 dibaca satu juta dan menjadi batas terbesar yang dipelajari pada bab ini.",
                "Titik memisahkan kelompok tiga digit agar bilangan besar lebih mudah dibaca, misalnya 720.736."
            ),
            example = WorkedExample(
                question = "Bagaimana membagi bilangan 720.736 agar mudah dibaca?",
                steps = listOf(
                    "Pisahkan tiga digit dari kanan: 720 | 736.",
                    "Kelompok kiri berada pada kelompok ribuan.",
                    "Baca 720 sebagai tujuh ratus dua puluh ribu.",
                    "Baca 736 sebagai tujuh ratus tiga puluh enam."
                ),
                answer = "720.736 dibaca tujuh ratus dua puluh ribu tujuh ratus tiga puluh enam."
            )
        ),
        Subchapter(
            title = "Membaca dan Menulis Bilangan",
            explanation = listOf(
                "Baca kelompok ribuan terlebih dahulu, kemudian kelompok ratusan, puluhan, dan satuan.",
                "Bilangan 875.428 dibaca delapan ratus tujuh puluh lima ribu empat ratus dua puluh delapan.",
                "Saat menulis dari kata-kata, tentukan kelompok ribuan dan kelompok satuan secara terpisah.",
                "Tempat yang tidak disebutkan tetap ditulis dengan angka 0 agar nilai tempat digit lain tidak bergeser."
            ),
            example = WorkedExample(
                question = "Tuliskan sembilan ratus enam puluh tiga ribu dalam bentuk angka.",
                steps = listOf(
                    "Sembilan ratus enam puluh tiga berarti 963.",
                    "Kata ribu berarti kelompok tersebut dikalikan 1.000.",
                    "Tidak ada ratusan, puluhan, atau satuan tambahan.",
                    "Isi tiga tempat terakhir dengan nol."
                ),
                answer = "Bilangan tersebut ditulis 963.000."
            )
        ),
        Subchapter(
            title = "Nilai Tempat dan Nilai Angka",
            explanation = listOf(
                "Nilai tempat menunjukkan posisi digit, sedangkan nilai angka menunjukkan hasil digit dikalikan nilai tempatnya.",
                "Pada 324.569, digit 3 berada di ratus ribuan dan bernilai 300.000.",
                "Digit yang sama dapat mempunyai nilai berbeda apabila posisinya berbeda.",
                "Tabel nilai tempat membantu mencegah digit berpindah posisi ketika bilangan dibaca atau ditulis."
            ),
            example = WorkedExample(
                question = "Tentukan nilai tempat dan nilai angka 9 pada 296.575.",
                steps = listOf(
                    "Tuliskan digit pada tabel nilai tempat.",
                    "Digit 9 berada pada kolom puluh ribuan.",
                    "Nilai satu tempat puluh ribuan adalah 10.000.",
                    "Hitung 9 × 10.000."
                ),
                answer = "Nilai tempatnya puluh ribuan dan nilai angkanya 90.000."
            )
        )
    )
}
