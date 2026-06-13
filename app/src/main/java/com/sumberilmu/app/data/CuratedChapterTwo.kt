package com.sumberilmu.app.data

object CuratedChapterTwo {
    val chapter = Chapter(
        id = "bab-2",
        number = 2,
        title = "KPK dan FPB",
        sourcePageStart = 29,
        sourcePageEnd = 62,
        objective = "Menentukan kelipatan, kelipatan persekutuan, KPK, faktor, faktor persekutuan, FPB, bilangan prima, faktorisasi prima, serta menggunakan KPK dan FPB untuk menyelesaikan masalah sehari-hari.",
        keywords = listOf(
            "kelipatan",
            "kelipatan persekutuan",
            "KPK",
            "faktor",
            "faktor persekutuan",
            "FPB",
            "bilangan prima",
            "Saringan Eratosthenes",
            "faktorisasi prima",
            "pohon faktor"
        ),
        summary = listOf(
            "Kelipatan suatu bilangan diperoleh dengan mengalikan bilangan tersebut dengan 1, 2, 3, dan seterusnya.",
            "Kelipatan persekutuan adalah kelipatan yang sama dari dua bilangan atau lebih. Kelipatan persekutuan yang paling kecil disebut KPK.",
            "Faktor adalah bilangan yang membagi suatu bilangan tanpa sisa. Faktor yang sama disebut faktor persekutuan, dan yang paling besar disebut FPB.",
            "KPK digunakan pada kejadian berulang yang ingin diketahui waktu bertemunya kembali, sedangkan FPB digunakan untuk membagi benda ke dalam kelompok identik sebanyak mungkin.",
            "Bilangan prima mempunyai tepat dua faktor, yaitu 1 dan bilangan itu sendiri. Faktorisasi prima menguraikan bilangan menjadi hasil kali faktor-faktor prima.",
            "KPK dapat ditentukan dengan mengambil seluruh faktor prima berpangkat terbesar, sedangkan FPB menggunakan faktor prima yang sama dengan pangkat terkecil."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Kelipatan",
                explanation = listOf(
                    "Kelipatan bilangan diperoleh melalui perkalian berurutan. Kelipatan 3 adalah 3, 6, 9, 12, 15, dan seterusnya.",
                    "Untuk memeriksa apakah suatu bilangan merupakan kelipatan, bagi bilangan tersebut dengan bilangan yang dimaksud. Jika tidak bersisa, bilangan itu merupakan kelipatan.",
                    "Pada pembahasan buku, daftar kelipatan dimulai dari hasil perkalian dengan 1, sehingga 0 tidak dimasukkan dalam daftar kelipatan."
                ),
                example = WorkedExample(
                    question = "Tuliskan lima bilangan kelipatan 7 yang pertama.",
                    steps = listOf(
                        "Hitung 1 × 7 = 7.",
                        "Lanjutkan dengan 2 × 7 = 14 dan 3 × 7 = 21.",
                        "Hitung 4 × 7 = 28 dan 5 × 7 = 35.",
                        "Susun hasil perkalian secara berurutan."
                    ),
                    answer = "7, 14, 21, 28, dan 35."
                )
            ),
            Subchapter(
                title = "Kelipatan Persekutuan dan KPK",
                explanation = listOf(
                    "Kelipatan persekutuan adalah bilangan yang muncul pada daftar kelipatan dua bilangan atau lebih.",
                    "KPK adalah kelipatan persekutuan yang nilainya paling kecil.",
                    "KPK dapat dicari dengan menulis beberapa kelipatan setiap bilangan lalu memilih bilangan sama yang paling kecil.",
                    "KPK berguna untuk menentukan kapan beberapa kegiatan dengan periode berbeda akan terjadi bersamaan lagi."
                ),
                example = WorkedExample(
                    question = "Nisa berenang setiap 3 hari dan Yohana setiap 4 hari. Mereka berenang bersama pada 3 Agustus. Kapan mereka bertemu lagi?",
                    steps = listOf(
                        "Tuliskan kelipatan 3: 3, 6, 9, 12, 15, ....",
                        "Tuliskan kelipatan 4: 4, 8, 12, 16, ....",
                        "Kelipatan persekutuan terkecilnya adalah 12.",
                        "Tambahkan 12 hari pada tanggal 3 Agustus."
                    ),
                    answer = "Mereka berenang bersama lagi pada 15 Agustus."
                )
            ),
            Subchapter(
                title = "Faktor dan Pasangan Faktor",
                explanation = listOf(
                    "Faktor suatu bilangan adalah bilangan cacah yang membagi bilangan tersebut tanpa sisa.",
                    "Faktor dapat ditemukan melalui pasangan perkalian. Pasangan faktor 18 adalah 1 dan 18, 2 dan 9, serta 3 dan 6.",
                    "Pencarian pasangan faktor cukup dilakukan sampai pasangan mulai berulang."
                ),
                example = WorkedExample(
                    question = "Tentukan semua faktor dari 18.",
                    steps = listOf(
                        "Cari pasangan perkalian yang menghasilkan 18.",
                        "1 × 18 = 18.",
                        "2 × 9 = 18.",
                        "3 × 6 = 18, lalu susun semua angka dari pasangan tersebut."
                    ),
                    answer = "Faktor 18 adalah 1, 2, 3, 6, 9, dan 18."
                )
            ),
            Subchapter(
                title = "Faktor Persekutuan dan FPB",
                explanation = listOf(
                    "Faktor persekutuan adalah faktor yang dimiliki bersama oleh dua bilangan atau lebih.",
                    "FPB adalah faktor persekutuan dengan nilai terbesar.",
                    "Untuk mencari FPB dengan daftar faktor, tuliskan faktor setiap bilangan, tandai yang sama, lalu pilih yang paling besar.",
                    "FPB dapat menentukan jumlah kelompok identik paling banyak tanpa ada benda yang tersisa."
                ),
                example = WorkedExample(
                    question = "Ada 24 mawar merah dan 18 mawar putih. Berapa vas identik paling banyak yang dapat dibuat?",
                    steps = listOf(
                        "Cari faktor 24: 1, 2, 3, 4, 6, 8, 12, 24.",
                        "Cari faktor 18: 1, 2, 3, 6, 9, 18.",
                        "Faktor persekutuannya 1, 2, 3, dan 6.",
                        "Pilih faktor persekutuan terbesar, yaitu 6."
                    ),
                    answer = "Dapat dibuat 6 vas; setiap vas berisi 4 mawar merah dan 3 mawar putih."
                )
            ),
            Subchapter(
                title = "Bilangan Prima dan Saringan Eratosthenes",
                explanation = listOf(
                    "Bilangan prima mempunyai tepat dua faktor berbeda: 1 dan bilangan itu sendiri.",
                    "Bilangan 1 bukan bilangan prima karena hanya mempunyai satu faktor.",
                    "Saringan Eratosthenes mencari bilangan prima dengan menghapus 1, lalu menghapus kelipatan 2, 3, 5, 7, dan bilangan prima berikutnya.",
                    "Bilangan yang belum terhapus setelah proses penyaringan merupakan bilangan prima."
                ),
                example = WorkedExample(
                    question = "Tentukan bilangan prima di antara 21, 29, 39, dan 51.",
                    steps = listOf(
                        "21 dapat dibagi 3 dan 7, sehingga bukan prima.",
                        "29 hanya dapat dibagi 1 dan 29.",
                        "39 dapat dibagi 3 dan 13.",
                        "51 dapat dibagi 3 dan 17."
                    ),
                    answer = "Bilangan primanya adalah 29."
                )
            ),
            Subchapter(
                title = "Faktorisasi Prima dan Pohon Faktor",
                explanation = listOf(
                    "Faktorisasi prima adalah penulisan suatu bilangan sebagai hasil kali bilangan-bilangan prima.",
                    "Pohon faktor memecah bilangan menjadi dua faktor, kemudian faktor komposit terus dipecah hingga seluruh ujungnya bilangan prima.",
                    "Bentuk pohon faktor dapat berbeda, tetapi hasil akhir faktorisasi primanya harus sama."
                ),
                example = WorkedExample(
                    question = "Tentukan faktorisasi prima dari 196.",
                    steps = listOf(
                        "196 = 2 × 98.",
                        "98 = 2 × 49.",
                        "49 = 7 × 7.",
                        "Seluruh faktor akhirnya adalah bilangan prima."
                    ),
                    answer = "196 = 2 × 2 × 7 × 7 = 2² × 7²."
                )
            ),
            Subchapter(
                title = "Menentukan KPK dan FPB dengan Faktorisasi Prima",
                explanation = listOf(
                    "Untuk KPK, ambil semua faktor prima yang muncul dengan pangkat terbesar.",
                    "Untuk FPB, ambil hanya faktor prima yang sama dengan pangkat terkecil.",
                    "Pada pembagian berulang, KPK diperoleh dari perkalian seluruh pembagi prima, sedangkan FPB hanya dari pembagi prima yang membagi semua bilangan pada baris yang sama.",
                    "Jika tidak ada faktor prima yang sama, FPB kedua bilangan adalah 1."
                ),
                example = WorkedExample(
                    question = "Tentukan KPK dan FPB dari 72 dan 150 dengan faktorisasi prima.",
                    steps = listOf(
                        "72 = 2³ × 3².",
                        "150 = 2 × 3 × 5².",
                        "KPK mengambil 2³, 3², dan 5²: 8 × 9 × 25.",
                        "FPB mengambil faktor sama berpangkat terkecil: 2 × 3."
                    ),
                    answer = "KPK = 1.800 dan FPB = 6."
                )
            )
        ),
        quiz = ChapterTwoQuiz.questions
    )
}
