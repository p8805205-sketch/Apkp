package com.sumberilmu.app.data

object CuratedChapterEight {
    val chapter = Chapter(
        id = "bab-8",
        number = 8,
        title = "Data",
        sourcePageStart = 235,
        sourcePageEnd = 272,
        objective = "Mengumpulkan data sederhana, menyajikannya dalam tabel frekuensi, piktogram, diagram batang vertikal, horizontal, dan ganda, lalu membaca serta menganalisisnya untuk mengambil keputusan.",
        keywords = listOf(
            "data",
            "turus",
            "frekuensi",
            "tabel frekuensi",
            "piktogram",
            "diagram batang vertikal",
            "diagram batang horizontal",
            "diagram batang ganda",
            "skala",
            "analisis data"
        ),
        summary = listOf(
            "Data adalah sekumpulan informasi atau fakta yang dapat ditulis menggunakan kata, angka, gambar, atau simbol.",
            "Turus membantu mencatat hasil pengamatan tanpa melewatkan atau menghitung data dua kali; frekuensi menunjukkan banyaknya suatu nilai atau peristiwa muncul.",
            "Tabel frekuensi merangkum kategori, turus, dan frekuensi sehingga data lebih mudah dibaca dan dibandingkan.",
            "Piktogram menggunakan gambar atau simbol yang mewakili nilai tertentu; bagian simbol dibaca sebagai pecahan dari nilai penuh.",
            "Diagram batang vertikal dan horizontal menampilkan frekuensi melalui panjang atau tinggi batang pada skala yang konsisten.",
            "Diagram batang ganda membandingkan dua kelompok yang memiliki kategori dan skala yang sama.",
            "Saat membandingkan diagram, periksa judul, kategori, legenda, satuan, dan skala sumbu agar kesimpulan tidak menyesatkan.",
            "Data dapat digunakan untuk menentukan nilai tertinggi, terendah, total, selisih, perubahan, urutan, dan keputusan yang masuk akal."
        ),
        subchapters = listOf(
            Subchapter(
                title = "Data dan Pengambilan Keputusan",
                explanation = listOf(
                    "Data membantu kita memahami keadaan berdasarkan catatan, bukan hanya perkiraan.",
                    "Data penjualan donat pada halaman 237 menunjukkan rasa cokelat meningkat, sedangkan rasa kacang terus menurun.",
                    "Sebelum mengambil keputusan, periksa pola, nilai tertinggi, nilai terendah, dan perubahan dari waktu ke waktu.",
                    "Kesimpulan harus sesuai dengan data yang tersedia dan tidak boleh melebihi informasi yang ditampilkan."
                ),
                example = WorkedExample(
                    question = "Jumlah donat cokelat yang terjual dari Senin sampai Sabtu adalah 3, 4, 5, 5, 6, dan 7. Apa kesimpulan yang tepat?",
                    steps = listOf(
                        "Urutkan data berdasarkan hari.",
                        "Amati perubahan: 3 → 4 → 5 → 5 → 6 → 7.",
                        "Nilai tidak pernah turun dan cenderung meningkat.",
                        "Gunakan pola tersebut untuk membuat keputusan persediaan."
                    ),
                    answer = "Penjualan donat cokelat cenderung meningkat, sehingga persediaannya dapat ditambah."
                )
            ),
            Subchapter(
                title = "Mengumpulkan Data dengan Turus",
                explanation = listOf(
                    "Pengumpulan data dapat dilakukan melalui pengamatan, pengukuran, pencatatan, atau pertanyaan langsung.",
                    "Satu hasil pengamatan diwakili satu turus.",
                    "Turus dikelompokkan lima-lima: empat garis tegak dan satu garis miring.",
                    "Pengelompokan turus membuat pencatatan lebih teliti dan frekuensi lebih cepat dihitung."
                ),
                example = WorkedExample(
                    question = "Sebuah kategori memiliki dua kelompok turus lengkap dan tiga turus tambahan. Berapa frekuensinya?",
                    steps = listOf(
                        "Satu kelompok lengkap bernilai 5.",
                        "Dua kelompok lengkap bernilai 2 × 5 = 10.",
                        "Tambahkan tiga turus: 10 + 3.",
                        "Tulis hasil sebagai frekuensi."
                    ),
                    answer = "Frekuensinya 13."
                )
            ),
            Subchapter(
                title = "Tabel Frekuensi",
                explanation = listOf(
                    "Tabel frekuensi memuat kategori data, turus, dan banyaknya kemunculan.",
                    "Kategori harus ditulis satu kali dan tidak boleh tumpang tindih.",
                    "Jumlah seluruh frekuensi harus sesuai dengan jumlah data yang dikumpulkan.",
                    "Dari tabel, kita dapat menentukan kategori terbanyak, tersedikit, total, dan urutan."
                ),
                example = WorkedExample(
                    question = "Frekuensi sayuran favorit adalah wortel 8, bayam 7, kangkung 6, tomat 6, sawi 5, buncis 4, dan kol 3. Mana yang paling banyak dan paling sedikit?",
                    steps = listOf(
                        "Bandingkan semua frekuensi.",
                        "Nilai terbesar adalah 8.",
                        "Nilai terkecil adalah 3.",
                        "Hubungkan nilai tersebut dengan kategorinya."
                    ),
                    answer = "Wortel paling banyak disukai dan kol paling sedikit disukai."
                )
            ),
            Subchapter(
                title = "Piktogram dan Simbol Parsial",
                explanation = listOf(
                    "Piktogram menyajikan data menggunakan gambar atau simbol.",
                    "Keterangan harus menjelaskan nilai satu simbol penuh.",
                    "Setengah simbol bernilai setengah dari nilai penuh; seperempat simbol bernilai seperempatnya.",
                    "Piktogram menarik secara visual, tetapi skala simbol harus dibaca dengan teliti."
                ),
                example = WorkedExample(
                    question = "Satu lingkaran mewakili Rp4.000,00. Berapa nilai 4 lingkaran penuh dan seperempat lingkaran?",
                    steps = listOf(
                        "Empat lingkaran penuh = 4 × Rp4.000,00 = Rp16.000,00.",
                        "Seperempat lingkaran = 1/4 × Rp4.000,00 = Rp1.000,00.",
                        "Jumlahkan kedua nilai.",
                        "Periksa bahwa bagian simbol dibaca sebagai pecahan."
                    ),
                    answer = "Nilainya Rp17.000,00."
                )
            ),
            Subchapter(
                title = "Diagram Batang Vertikal",
                explanation = listOf(
                    "Pada diagram batang vertikal, kategori biasanya berada pada sumbu mendatar dan nilai pada sumbu tegak.",
                    "Tinggi setiap batang harus sesuai dengan skala.",
                    "Semua batang memiliki lebar dan jarak yang konsisten.",
                    "Judul, nama sumbu, satuan, dan skala wajib dicantumkan."
                ),
                example = WorkedExample(
                    question = "Data medali emas 2013–2021 adalah 65, 47, 38, 72, dan 69. Tahun mana yang tertinggi dan terendah?",
                    steps = listOf(
                        "Cari batang tertinggi atau nilai terbesar: 72.",
                        "Hubungkan 72 dengan tahun 2019.",
                        "Cari batang terendah atau nilai terkecil: 38.",
                        "Hubungkan 38 dengan tahun 2017."
                    ),
                    answer = "Tertinggi pada 2019 dan terendah pada 2017."
                )
            ),
            Subchapter(
                title = "Diagram Batang Horizontal",
                explanation = listOf(
                    "Pada diagram batang horizontal, kategori biasanya berada pada sumbu tegak dan nilai pada sumbu mendatar.",
                    "Panjang batang menunjukkan besar nilai.",
                    "Diagram horizontal berguna ketika nama kategori panjang atau jumlah kategori cukup banyak.",
                    "Cara membaca nilai tetap sama: ikuti ujung batang menuju skala."
                ),
                example = WorkedExample(
                    question = "Batang hasil panen Kolam 2 berakhir pada 28 kg dan Kolam 4 pada 16 kg. Berapa selisihnya?",
                    steps = listOf(
                        "Baca nilai Kolam 2: 28 kg.",
                        "Baca nilai Kolam 4: 16 kg.",
                        "Kurangkan 28 - 16.",
                        "Tuliskan satuannya."
                    ),
                    answer = "Selisihnya 12 kg."
                )
            ),
            Subchapter(
                title = "Diagram Batang Ganda",
                explanation = listOf(
                    "Diagram batang ganda membandingkan dua kelompok pada kategori yang sama.",
                    "Kedua kelompok harus memakai sumbu dan skala yang sama.",
                    "Legenda membedakan warna atau pola setiap kelompok.",
                    "Perbandingan dilakukan per kategori maupun secara keseluruhan."
                ),
                example = WorkedExample(
                    question = "Pada 2019 terdapat 16 siswa laki-laki dan 12 siswa perempuan. Berapa selisihnya?",
                    steps = listOf(
                        "Pastikan kedua batang menggunakan skala yang sama.",
                        "Baca nilai laki-laki: 16.",
                        "Baca nilai perempuan: 12.",
                        "Hitung 16 - 12."
                    ),
                    answer = "Selisihnya 4 siswa."
                )
            ),
            Subchapter(
                title = "Membaca, Menganalisis, dan Menguji Kesimpulan",
                explanation = listOf(
                    "Analisis data dapat meliputi total, selisih, kenaikan, penurunan, nilai maksimum, minimum, dan urutan.",
                    "Dua diagram hanya dapat dibandingkan secara langsung jika skala, satuan, dan kategorinya sepadan.",
                    "Pernyataan benar atau salah harus diuji dengan perhitungan yang dapat ditelusuri.",
                    "Gunakan hasil analisis untuk memberikan saran atau mengambil keputusan yang relevan."
                ),
                example = WorkedExample(
                    question = "Pengunjung perpustakaan Kamis 36 orang dan Jumat 24 orang. Berapa penurunannya?",
                    steps = listOf(
                        "Tentukan nilai awal: 36.",
                        "Tentukan nilai akhir: 24.",
                        "Hitung penurunan 36 - 24.",
                        "Nyatakan hasil dalam orang."
                    ),
                    answer = "Jumlah pengunjung turun 12 orang."
                )
            )
        ),
        quiz = ChapterEightQuiz.questions
    )
}
