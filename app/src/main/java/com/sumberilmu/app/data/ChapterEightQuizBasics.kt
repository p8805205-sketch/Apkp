package com.sumberilmu.app.data

object ChapterEightQuizBasics {
    val questions = listOf(
        q(1, "Data adalah ...", listOf("Sekumpulan informasi atau fakta", "Satu angka tanpa keterangan", "Gambar yang selalu berwarna", "Perkiraan yang tidak dicatat"), "Sekumpulan informasi atau fakta", "Data dapat dituliskan menggunakan kata, kalimat, angka, gambar, atau simbol.", "mudah", 238),
        q(2, "Frekuensi menyatakan ...", listOf("Banyaknya suatu peristiwa atau nilai muncul", "Urutan kategori dalam tabel", "Warna yang dipakai pada diagram", "Selisih antara nilai terbesar dan terkecil"), "Banyaknya suatu peristiwa atau nilai muncul", "Frekuensi adalah bilangan yang menunjukkan berapa kali suatu peristiwa atau nilai terjadi.", "mudah", 244),
        q(3, "Turus biasanya dikelompokkan lima-lima agar ...", listOf("Lebih mudah dihitung dan diperiksa", "Semua data bernilai lima", "Tabel menjadi lebih panjang", "Tidak perlu menulis frekuensi"), "Lebih mudah dihitung dan diperiksa", "Empat garis tegak dan satu garis miring membentuk kelompok lima sehingga penghitungan lebih teliti.", "mudah", 244),
        q(4, "Pada data sayuran favorit, sayuran yang paling banyak disukai adalah ...", listOf("Wortel", "Bayam", "Kangkung", "Kol"), "Wortel", "Wortel disukai 8 siswa, paling banyak dibandingkan sayuran lain.", "mudah", 245),
        q(5, "Frekuensi siswa yang menyukai tomat adalah ...", listOf("6", "8", "4", "3"), "6", "Tomat dipilih oleh Lukas, Komang, Randi, Tomi, Ucok, dan Farah, sehingga frekuensinya 6.", "sedang", 245),
        q(6, "Sayuran yang paling sedikit disukai siswa adalah ...", listOf("Kol", "Buncis", "Sawi", "Tomat"), "Kol", "Kol dipilih 3 siswa, lebih sedikit daripada buncis 4, sawi 5, dan tomat 6.", "mudah", 245),
        q(7, "Nilai tertinggi pada data ulangan Matematika SD Mekarsari adalah ...", listOf("100", "90", "80", "70"), "100", "Nilai terbesar yang tercatat pada data adalah 100.", "mudah", 247),
        q(8, "Siswa dengan nilai kurang dari 70 harus mengikuti remedi. Banyak siswa yang remedi adalah ...", listOf("8 siswa", "6 siswa", "7 siswa", "10 siswa"), "8 siswa", "Nilai 40 muncul 2 kali, 50 muncul 1 kali, dan 60 muncul 5 kali. Totalnya 2 + 1 + 5 = 8 siswa.", "sedang", 247)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(8, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
