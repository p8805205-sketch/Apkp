package com.sumberilmu.app.data

object CuratedChapterSix {
    val chapter = Chapter(
        id = "bab-6",
        number = 6,
        title = "Sudut",
        sourcePageStart = 163,
        sourcePageEnd = 190,
        objective = "Menemukan sudut siku-siku di lingkungan sekitar, memahami bagian dan jenis sudut, mengukur serta membandingkan sudut dengan busur derajat, dan melukis sudut dengan ukuran tertentu.",
        keywords = listOf(
            "sudut", "titik sudut", "kaki sudut", "siku-siku", "lancip",
            "tumpul", "lurus", "refleks", "busur derajat", "derajat"
        ),
        summary = listOf(
            "Sudut dibentuk oleh dua kaki sudut yang bertemu pada satu titik sudut.",
            "Sudut lancip lebih dari 0° dan kurang dari 90°, sudut siku-siku tepat 90°, dan sudut tumpul lebih dari 90° serta kurang dari 180°.",
            "Sudut lurus berukuran 180°, sudut refleks lebih dari 180° dan kurang dari 360°, sedangkan sudut penuh berukuran 360°.",
            "Busur derajat digunakan dengan meletakkan pusatnya pada titik sudut dan garis dasarnya pada salah satu kaki sudut.",
            "Skala dibaca dari angka 0° yang berimpit dengan kaki awal sudut.",
            "Pada jam analog, jarak antarang­ka yang berdekatan mewakili 30°.",
            "Untuk melukis sudut, buat satu kaki sudut, tandai ukuran pada busur, lalu hubungkan tanda tersebut dengan titik sudut."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Menemukan Sudut Siku-Siku",
                explanation = listOf(
                    "Sudut siku-siku sering ditemukan pada sudut meja, buku, ubin, jendela, dan bingkai.",
                    "Lipatan kertas yang dibuat mendatar lalu tegak dapat digunakan sebagai pembanding sudut siku-siku.",
                    "Sebuah sudut termasuk siku-siku jika bukaannya sama dengan sudut 90°.",
                    "Penggaris siku-siku membantu tukang memeriksa ketepatan sudut pada benda."
                ),
                example = WorkedExample(
                    question = "Sebuah pojok bingkai tepat berimpit dengan lipatan kertas siku-siku. Jenis sudutnya apa?",
                    steps = listOf(
                        "Letakkan titik lipatan pada pojok bingkai.",
                        "Impitkan satu sisi lipatan dengan satu sisi bingkai.",
                        "Periksa apakah sisi lainnya juga berimpit.",
                        "Jika keduanya berimpit, bukaannya 90°."
                    ),
                    answer = "Pojok tersebut membentuk sudut siku-siku."
                )
            ),
            Subchapter(
                title = "Bagian-Bagian dan Pengertian Sudut",
                explanation = listOf(
                    "Sudut adalah daerah yang dibentuk oleh dua garis atau sinar garis yang bertemu.",
                    "Dua garis pembentuk sudut disebut kaki sudut.",
                    "Titik pertemuan kedua kaki disebut titik sudut.",
                    "Nama sudut dapat ditentukan dari titik sudut dan kedua kaki yang membentuknya."
                ),
                example = WorkedExample(
                    question = "Dua garis OA dan OB bertemu di O. Tentukan titik sudut dan kaki sudutnya.",
                    steps = listOf(
                        "Cari titik tempat kedua garis bertemu.",
                        "Titik pertemuan tersebut adalah O.",
                        "Garis OA merupakan kaki pertama.",
                        "Garis OB merupakan kaki kedua."
                    ),
                    answer = "Titik sudut O, dengan kaki sudut OA dan OB."
                )
            ),
            Subchapter(
                title = "Mengenal Jenis-Jenis Sudut",
                explanation = listOf(
                    "Sudut nol berukuran 0° dan kedua kakinya berimpit.",
                    "Sudut lancip berada antara 0° dan 90°; sudut siku-siku tepat 90°.",
                    "Sudut tumpul berada antara 90° dan 180°; sudut lurus tepat 180°.",
                    "Sudut refleks berada antara 180° dan 360°; sudut penuh tepat 360°."
                ),
                example = WorkedExample(
                    question = "Klasifikasikan sudut 35°, 90°, 140°, 180°, dan 225°.",
                    steps = listOf(
                        "Bandingkan setiap ukuran dengan 90°.",
                        "Periksa apakah ukurannya sama dengan 180°.",
                        "Untuk ukuran di atas 180°, gunakan kelompok refleks.",
                        "Tulis jenis sesuai rentangnya."
                    ),
                    answer = "35° lancip, 90° siku-siku, 140° tumpul, 180° lurus, dan 225° refleks."
                )
            ),
            Subchapter(
                title = "Mengukur Sudut dengan Busur Derajat",
                explanation = listOf(
                    "Pusat busur derajat harus tepat berada pada titik sudut.",
                    "Garis dasar busur harus berimpit dengan salah satu kaki sudut.",
                    "Mulailah membaca dari skala 0° pada kaki awal.",
                    "Angka yang dipotong kaki sudut kedua adalah besar sudutnya."
                ),
                example = WorkedExample(
                    question = "Kaki awal berada pada 0° di kanan dan kaki kedua memotong angka 125°. Berapa besar dan jenis sudutnya?",
                    steps = listOf(
                        "Pastikan pusat busur berada pada titik sudut.",
                        "Mulai dari skala 0° di kanan.",
                        "Baca angka yang dipotong kaki kedua, yaitu 125°.",
                        "Bandingkan dengan 90° dan 180°."
                    ),
                    answer = "Besar sudut 125° dan termasuk sudut tumpul."
                )
            ),
            Subchapter(
                title = "Membandingkan Sudut dan Sudut pada Jam",
                explanation = listOf(
                    "Sudut yang lebih besar mempunyai bukaan lebih lebar.",
                    "Satu putaran jam dibagi menjadi 12 bagian sama besar, sehingga setiap bagian bernilai 30°.",
                    "Pada waktu tepat, jarum menit berada di angka 12 dan sudut dihitung dari jarak posisi jarum jam.",
                    "Gunakan sudut terkecil jika soal menanyakan sudut terkecil antara kedua jarum."
                ),
                example = WorkedExample(
                    question = "Berapa sudut terkecil pada pukul 08.00?",
                    steps = listOf(
                        "Jarak dari angka 12 ke 8 adalah delapan interval.",
                        "Delapan interval = 8 × 30° = 240°.",
                        "Sudut lainnya = 360° - 240°.",
                        "Pilih ukuran yang lebih kecil."
                    ),
                    answer = "Sudut terkecilnya 120°."
                )
            ),
            Subchapter(
                title = "Melukis Sudut dengan Ukuran Tertentu",
                explanation = listOf(
                    "Buat titik sudut dan satu kaki sudut terlebih dahulu.",
                    "Letakkan pusat busur pada titik sudut dan garis dasar pada kaki awal.",
                    "Tandai angka ukuran yang diminta pada skala yang dimulai dari 0° kaki awal.",
                    "Hubungkan titik sudut dengan tanda, lalu ukur ulang untuk memeriksa hasilnya."
                ),
                example = WorkedExample(
                    question = "Bagaimana melukis sudut 150°?",
                    steps = listOf(
                        "Buat titik O dan kaki OA.",
                        "Tempatkan pusat busur pada O dan garis dasar pada OA.",
                        "Beri tanda pada angka 150°.",
                        "Tarik garis OB dari O melewati tanda tersebut."
                    ),
                    answer = "Sudut AOB yang terbentuk berukuran 150°."
                )
            ),
            Subchapter(
                title = "Sudut dalam Persimpangan dan Pola Keramik",
                explanation = listOf(
                    "Sudut pada persimpangan menentukan ruang yang tersedia bagi kendaraan untuk berbelok.",
                    "Sudut siku-siku sering dianggap ideal karena menghasilkan pertemuan jalan yang teratur.",
                    "Semakin kecil sudut persimpangan, semakin tajam arah belok kendaraan.",
                    "Sudut-sudut yang mengelilingi satu titik berjumlah 360°, sehingga celah pola dapat dicari dengan pengurangan."
                ),
                example = WorkedExample(
                    question = "Tiga sudut keramik masing-masing 108° bertemu pada satu titik. Berapa besar celahnya?",
                    steps = listOf(
                        "Jumlah sudut di sekitar satu titik adalah 360°.",
                        "Jumlah tiga sudut keramik = 3 × 108° = 324°.",
                        "Kurangkan 360° - 324°.",
                        "Gunakan hasilnya sebagai sudut potongan pengisi."
                    ),
                    answer = "Besar celah adalah 36°."
                )
            )
        ),
        quiz = ChapterSixQuiz.questions
    )
}
