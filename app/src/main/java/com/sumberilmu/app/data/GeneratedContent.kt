package com.sumberilmu.app.data

/**
 * Konten awal aplikasi. Data ini sengaja disusun sebagai objek Kotlin agar versi
 * pertama dapat dibangun tanpa backend. Pada iterasi berikutnya sumber data akan
 * dipindahkan ke Room dan Supabase.
 */
object GeneratedContent {
    val catalog: LearningCatalog = LearningCatalog(
        appName = "Sumber Ilmu",
        curriculum = "Kurikulum Merdeka",
        level = "SD",
        grade = "Kelas 5",
        subject = "Matematika",
        semester = "1",
        passScore = 75,
        quizQuestionsPerChapter = 25,
        source = ContentSource(
            title = "Matematika untuk SD/MI Kelas V",
            publisher = "Kementerian Pendidikan, Kebudayaan, Riset, dan Teknologi",
            year = 2022,
            isbn = "978-602-427-916-5",
            note = "Materi diringkas dan soal disusun ulang untuk pembelajaran di aplikasi."
        ),
        chapters = listOf(
            chapter(
                number = 1,
                title = "Bilangan Cacah Sampai 100.000",
                pages = 1..28,
                objective = "Membaca, menulis, membandingkan, mengurutkan, menyusun, menguraikan, menjumlahkan, dan mengurangkan bilangan cacah sampai 100.000.",
                keywords = listOf("nilai tempat", "komposisi", "dekomposisi", "penjumlahan", "pengurangan"),
                subchapters = listOf(
                    "Membaca, Menulis, dan Nilai Tempat",
                    "Membandingkan dan Mengurutkan",
                    "Komposisi dan Dekomposisi",
                    "Operasi Hitung"
                )
            ),
            chapter(
                number = 2,
                title = "KPK dan FPB",
                pages = 29..62,
                objective = "Memahami kelipatan, faktor, bilangan prima, KPK, FPB, dan penerapannya.",
                keywords = listOf("kelipatan", "faktor", "bilangan prima", "KPK", "FPB"),
                subchapters = listOf(
                    "Kelipatan",
                    "Kelipatan Persekutuan",
                    "Faktor",
                    "Faktor Persekutuan",
                    "Faktorisasi Prima"
                )
            ),
            chapter(
                number = 3,
                title = "Bilangan Pecahan",
                pages = 63..104,
                objective = "Membandingkan, mengurutkan, menjumlahkan, dan mengurangkan pecahan.",
                keywords = listOf("pecahan senilai", "pembilang", "penyebut", "penjumlahan", "pengurangan"),
                subchapters = listOf(
                    "Membandingkan dan Mengurutkan Pecahan",
                    "Penjumlahan Pecahan",
                    "Pengurangan Pecahan"
                )
            ),
            chapter(
                number = 4,
                title = "Keliling Bangun Datar",
                pages = 105..130,
                objective = "Memahami konsep keliling dan menghitung keliling berbagai bangun datar serta bangun gabungan.",
                keywords = listOf("keliling", "segitiga", "segi empat", "segi banyak", "bangun gabungan"),
                subchapters = listOf(
                    "Konsep Keliling",
                    "Keliling Segitiga",
                    "Keliling Segi Empat",
                    "Keliling Segi Banyak",
                    "Keliling Bangun Gabungan"
                )
            ),
            chapter(
                number = 5,
                title = "Luas Daerah Bangun Datar",
                pages = 131..162,
                objective = "Menemukan dan menggunakan cara menghitung luas berbagai daerah bangun datar.",
                keywords = listOf("luas", "persegi", "persegi panjang", "segitiga", "bangun gabungan"),
                subchapters = listOf(
                    "Konsep Luas",
                    "Luas Bangun Datar",
                    "Luas Bangun Gabungan",
                    "Hubungan Keliling dan Luas"
                )
            ),
            chapter(
                number = 6,
                title = "Sudut",
                pages = 163..190,
                objective = "Mengenali, mengukur, membandingkan, dan melukis sudut.",
                keywords = listOf("sudut siku-siku", "titik sudut", "kaki sudut", "busur derajat", "melukis sudut"),
                subchapters = listOf(
                    "Sudut Siku-Siku",
                    "Pengertian Sudut",
                    "Mengukur dan Membandingkan Sudut",
                    "Melukis Sudut"
                )
            ),
            chapter(
                number = 7,
                title = "Membandingkan Ciri-Ciri Bangun Datar",
                pages = 191..234,
                objective = "Membandingkan segitiga dan segi empat berdasarkan sisi, sudut, dan sifatnya.",
                keywords = listOf("segitiga", "segi empat", "sisi", "sudut", "simetri"),
                subchapters = listOf(
                    "Ciri-Ciri Segitiga",
                    "Ciri-Ciri Segi Empat"
                )
            ),
            chapter(
                number = 8,
                title = "Data",
                pages = 235..272,
                objective = "Mengumpulkan, menyajikan, membaca, dan menganalisis data sederhana.",
                keywords = listOf("data", "tabel frekuensi", "piktogram", "diagram batang", "analisis"),
                subchapters = listOf(
                    "Mengumpulkan Data",
                    "Piktogram",
                    "Diagram Batang"
                )
            ),
            chapter(
                number = 9,
                title = "Bilangan Cacah Sampai 1.000.000",
                pages = 273..292,
                objective = "Membaca, menulis, membandingkan, mengurutkan, menyusun, dan menguraikan bilangan sampai 1.000.000.",
                keywords = listOf("nilai tempat", "ratus ribuan", "membandingkan", "mengurutkan", "dekomposisi"),
                subchapters = listOf(
                    "Membaca, Menulis, dan Nilai Tempat",
                    "Mengurutkan dan Membandingkan",
                    "Komposisi dan Dekomposisi"
                )
            )
        )
    )

    private fun chapter(
        number: Int,
        title: String,
        pages: IntRange,
        objective: String,
        keywords: List<String>,
        subchapters: List<String>
    ): Chapter {
        val id = "bab-$number"
        return Chapter(
            id = id,
            number = number,
            title = title,
            sourcePageStart = pages.first,
            sourcePageEnd = pages.last,
            objective = objective,
            keywords = keywords,
            summary = listOf(
                objective,
                "Pelajari konsep melalui contoh kontekstual, kemudian kerjakan latihan secara bertahap.",
                "Gunakan pembahasan jawaban untuk menemukan konsep yang masih perlu diperkuat."
            ),
            subchapters = subchapters.mapIndexed { index, name ->
                Subchapter(
                    title = name,
                    explanation = listOf(
                        "Subbab ini membahas $name dengan bahasa sederhana dan contoh yang dekat dengan kehidupan sehari-hari.",
                        "Perhatikan informasi yang diketahui, tentukan konsep yang tepat, lalu periksa kembali hasilnya."
                    ),
                    example = WorkedExample(
                        question = exampleQuestion(number, index),
                        steps = exampleSteps(number, index),
                        answer = exampleAnswer(number, index)
                    )
                )
            },
            quiz = buildQuiz(number, pages.first)
        )
    }

    private fun buildQuiz(chapter: Int, sourcePage: Int): List<Question> =
        List(25) { index -> questionFor(chapter, index + 1, sourcePage) }

    private fun questionFor(chapter: Int, order: Int, sourcePage: Int): Question {
        val seed = order + chapter * 3
        val data = when (chapter) {
            1 -> {
                val a = 12_000 + seed * 317
                val b = 4_000 + seed * 83
                QuestionData("Hasil dari $a + $b adalah ...", a + b, "Jumlahkan berdasarkan nilai tempat.")
            }
            2 -> {
                val a = 2 + seed % 8
                val b = 3 + seed % 7
                val answer = lcm(a, b)
                QuestionData("KPK dari $a dan $b adalah ...", answer, "Tuliskan kelipatan kedua bilangan dan pilih kelipatan persekutuan terkecil.")
            }
            3 -> {
                val denominator = 5 + seed % 6
                val first = 1 + seed % 3
                val second = 1 + (seed + 1) % 3
                QuestionData("$first/$denominator + $second/$denominator = .../$denominator", first + second, "Penyebut sama, sehingga pembilang dapat langsung dijumlahkan.")
            }
            4 -> {
                val length = 5 + seed % 12
                val width = 3 + seed % 8
                QuestionData("Keliling persegi panjang dengan panjang $length cm dan lebar $width cm adalah ... cm", 2 * (length + width), "Keliling persegi panjang adalah 2 × (panjang + lebar).")
            }
            5 -> {
                val length = 6 + seed % 11
                val width = 4 + seed % 9
                QuestionData("Luas persegi panjang dengan panjang $length cm dan lebar $width cm adalah ... cm²", length * width, "Luas persegi panjang adalah panjang × lebar.")
            }
            6 -> {
                val angle = listOf(30, 45, 60, 90, 120, 135)[seed % 6]
                val typeCode = when {
                    angle < 90 -> 1
                    angle == 90 -> 2
                    else -> 3
                }
                QuestionData("Sudut $angle° termasuk jenis sudut dengan kode 1=lancip, 2=siku-siku, 3=tumpul. Jawabannya ...", typeCode, "Bandingkan besar sudut dengan 90°.")
            }
            7 -> {
                val sides = 3 + seed % 3
                QuestionData("Bangun datar dengan $sides sisi mempunyai ... titik sudut", sides, "Pada segi banyak sederhana, banyak sisi sama dengan banyak titik sudut.")
            }
            8 -> {
                val monday = 10 + seed % 8
                val tuesday = 8 + seed % 7
                QuestionData("Data pengunjung: Senin $monday orang dan Selasa $tuesday orang. Jumlahnya ... orang", monday + tuesday, "Jumlahkan frekuensi dari kedua kategori.")
            }
            else -> {
                val a = 120_000 + seed * 3_411
                val b = 20_000 + seed * 191
                QuestionData("Bilangan yang lebih besar antara $a dan $b adalah ...", maxOf(a, b), "Bandingkan nilai tempat mulai dari posisi paling kiri.")
            }
        }

        val correct = data.answer
        val options = listOf(correct, correct + 1, maxOf(0, correct - 1), correct + 10)
            .distinct()
            .let { values -> if (values.size == 4) values else listOf(correct, correct + 2, correct + 5, correct + 10) }
            .shuffled(java.util.Random((chapter * 100 + order).toLong()))
        val correctIndex = options.indexOf(correct)

        return Question(
            id = "bab-$chapter-soal-$order",
            prompt = data.prompt,
            options = options.mapIndexed { index, value ->
                QuestionOption(
                    text = value.toString(),
                    explanation = if (index == correctIndex) {
                        "Tepat. ${data.explanation}"
                    } else {
                        "Belum tepat. ${data.explanation}"
                    }
                )
            },
            correctIndex = correctIndex,
            explanation = data.explanation,
            difficulty = when {
                order <= 8 -> "mudah"
                order <= 17 -> "sedang"
                else -> "menantang"
            },
            sourcePage = sourcePage
        )
    }

    private fun exampleQuestion(chapter: Int, index: Int): String =
        when (chapter) {
            1 -> "Tentukan hasil 24.650 + 13.200."
            2 -> "Tentukan KPK dari 4 dan 6."
            3 -> "Hitung 2/7 + 3/7."
            4 -> "Hitung keliling persegi panjang berukuran 8 cm × 5 cm."
            5 -> "Hitung luas persegi panjang berukuran 9 cm × 4 cm."
            6 -> "Tentukan jenis sudut 120°."
            7 -> "Berapa banyak sisi dan titik sudut sebuah segitiga?"
            8 -> "Jumlahkan data 12 siswa dan 15 siswa."
            else -> "Manakah yang lebih besar: 345.600 atau 354.600?"
        }

    private fun exampleSteps(chapter: Int, index: Int): List<String> =
        listOf(
            "Tuliskan informasi yang diketahui.",
            "Pilih konsep pada bab $chapter yang sesuai.",
            "Lakukan perhitungan secara berurutan.",
            "Periksa kembali hasil dan satuannya."
        )

    private fun exampleAnswer(chapter: Int, index: Int): String =
        when (chapter) {
            1 -> "37.850"
            2 -> "12"
            3 -> "5/7"
            4 -> "26 cm"
            5 -> "36 cm²"
            6 -> "Sudut tumpul"
            7 -> "3 sisi dan 3 titik sudut"
            8 -> "27 siswa"
            else -> "354.600"
        }

    private fun lcm(a: Int, b: Int): Int = a / gcd(a, b) * b

    private tailrec fun gcd(a: Int, b: Int): Int =
        if (b == 0) kotlin.math.abs(a) else gcd(b, a % b)

    private data class QuestionData(
        val prompt: String,
        val answer: Int,
        val explanation: String
    )
}
