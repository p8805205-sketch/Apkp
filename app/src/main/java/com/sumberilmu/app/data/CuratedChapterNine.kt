package com.sumberilmu.app.data

object CuratedChapterNine {
    val chapter = Chapter(
        id = "bab-9",
        number = 9,
        title = "Bilangan Cacah Sampai 1.000.000",
        sourcePageStart = 273,
        sourcePageEnd = 292,
        objective = "Membaca, menulis, menentukan nilai tempat, membandingkan, mengurutkan, menyusun, dan menguraikan bilangan cacah sampai 1.000.000.",
        keywords = listOf(
            "bilangan cacah",
            "satu juta",
            "ratus ribuan",
            "nilai tempat",
            "nilai angka",
            "membandingkan",
            "mengurutkan",
            "komposisi",
            "dekomposisi",
            "pecahan uang"
        ),
        summary = listOf(
            "Bilangan cacah sampai 1.000.000 menggunakan enam nilai tempat dari ratus ribuan sampai satuan; 1.000.000 dibaca satu juta.",
            "Bilangan besar lebih mudah dibaca dengan memisahkan setiap tiga digit menggunakan titik.",
            "Nilai tempat menunjukkan posisi digit, sedangkan nilai angka adalah digit dikalikan nilai tempatnya.",
            "Untuk membandingkan bilangan dengan jumlah digit sama, periksa digit dari nilai tempat terbesar menuju terkecil.",
            "Urutan naik bergerak dari bilangan terkecil ke terbesar, sedangkan urutan turun bergerak dari terbesar ke terkecil.",
            "Komposisi menyusun bilangan dari nilai tempatnya; dekomposisi menguraikan bilangan menjadi penjumlahan nilai digit.",
            "Pecahan uang merupakan penerapan komposisi dan dekomposisi dalam kehidupan sehari-hari.",
            "Setiap hasil harus diperiksa kembali dengan membaca angka, tabel nilai tempat, atau menjumlahkan hasil dekomposisinya."
        ),
        subchapters = ChapterNineLessonsReading.lessons +
            ChapterNineLessonsOrdering.lessons +
            ChapterNineLessonsComposition.lessons,
        quiz = ChapterNineQuiz.questions
    )
}
