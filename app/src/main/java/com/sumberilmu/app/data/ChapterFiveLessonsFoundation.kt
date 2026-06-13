package com.sumberilmu.app.data

object ChapterFiveLessonsFoundation {
    val items = listOf(
        Subchapter(
            title = "Konsep Luas dan Satuan Persegi",
            explanation = listOf(
                "Luas menunjukkan besar daerah yang ditempati suatu bangun, sedangkan keliling mengukur panjang batasnya.",
                "Petak persegi satuan digunakan sebagai pembanding. Persegi 1 cm × 1 cm mempunyai luas 1 cm².",
                "Pengubinan menentukan luas dengan menghitung petak yang menutupi daerah tanpa celah.",
                "Bangun yang dipotong dan disusun kembali tetap memiliki luas sama jika tidak ada bagian yang hilang."
            ),
            example = WorkedExample(
                question = "Lantai tertutup oleh 7 baris ubin dan setiap baris berisi 5 ubin berukuran 1 m². Berapa luasnya?",
                steps = listOf("Satu ubin mewakili 1 m².", "Hitung 7 × 5 = 35.", "Luas sama dengan jumlah petak satuan.", "Tuliskan hasil menggunakan m²."),
                answer = "Luas lantai adalah 35 m²."
            )
        ),
        Subchapter(
            title = "Luas Persegi Panjang dan Persegi",
            explanation = listOf(
                "Luas persegi panjang dihitung dari jumlah kolom × jumlah baris, sehingga L = p × l.",
                "Persegi mempunyai panjang dan lebar sama, sehingga L = s × s.",
                "Jika luas dan satu ukuran persegi panjang diketahui, ukuran lainnya diperoleh dengan pembagian.",
                "Jika luas persegi diketahui, panjang sisi adalah bilangan yang kuadratnya menghasilkan luas tersebut."
            ),
            example = WorkedExample(
                question = "Luas persegi panjang 96 cm² dan panjangnya 12 cm. Berapa lebarnya?",
                steps = listOf("Gunakan L = p × l.", "Substitusikan 96 = 12 × l.", "Hitung l = 96 ÷ 12.", "Periksa dengan 12 × 8 = 96."),
                answer = "Lebarnya 8 cm."
            )
        ),
        Subchapter(
            title = "Luas Segitiga",
            explanation = listOf(
                "Segitiga dapat disusun ulang menjadi persegi panjang atau dipasangkan menjadi jajargenjang.",
                "Luas segitiga adalah L = 1/2 × alas × tinggi.",
                "Tinggi harus tegak lurus terhadap alas, bukan selalu sisi miring.",
                "Jika luas dan alas diketahui, tinggi dapat dicari dengan t = 2 × L ÷ alas."
            ),
            example = WorkedExample(
                question = "Segitiga mempunyai alas 14 cm dan tinggi 8 cm. Berapa luasnya?",
                steps = listOf("Tentukan alas 14 cm dan tinggi 8 cm.", "Gunakan L = 1/2 × alas × tinggi.", "Hitung 1/2 × 14 = 7.", "Kalikan 7 × 8 = 56."),
                answer = "Luas segitiga adalah 56 cm²."
            )
        ),
        Subchapter(
            title = "Luas Jajargenjang",
            explanation = listOf(
                "Jajargenjang dapat dipotong dan disusun menjadi persegi panjang tanpa mengubah luas.",
                "Panjang hasil susunan sama dengan alas, sedangkan lebarnya sama dengan tinggi jajargenjang.",
                "Rumus luas jajargenjang adalah L = alas × tinggi.",
                "Sisi miring tidak digunakan sebagai tinggi kecuali tegak lurus terhadap alas."
            ),
            example = WorkedExample(
                question = "Jajargenjang mempunyai alas 15 cm dan tinggi 9 cm. Tentukan luasnya.",
                steps = listOf("Tentukan alas dan tinggi yang saling tegak lurus.", "Gunakan L = alas × tinggi.", "Hitung 15 × 9.", "Tuliskan hasil dalam cm²."),
                answer = "Luas jajargenjang adalah 135 cm²."
            )
        ),
        Subchapter(
            title = "Luas Trapesium",
            explanation = listOf(
                "Trapesium mempunyai sepasang sisi sejajar yang disebut sisi atas dan sisi alas.",
                "Luas trapesium adalah L = 1/2 × (sisi atas + sisi alas) × tinggi.",
                "Tinggi adalah jarak tegak lurus antara kedua sisi sejajar.",
                "Rumus diperoleh dengan menyusun ulang trapesium menjadi persegi panjang."
            ),
            example = WorkedExample(
                question = "Trapesium memiliki sisi sejajar 9 cm dan 15 cm serta tinggi 6 cm. Berapa luasnya?",
                steps = listOf("Jumlahkan 9 + 15 = 24.", "Hitung setengah dari 24 = 12.", "Kalikan 12 × 6.", "Tuliskan hasil dalam cm²."),
                answer = "Luas trapesium adalah 72 cm²."
            )
        ),
        Subchapter(
            title = "Luas Belah Ketupat dan Layang-Layang",
            explanation = listOf(
                "Belah ketupat dan layang-layang menggunakan dua diagonal untuk menentukan luas.",
                "Rumus keduanya adalah L = 1/2 × diagonal 1 × diagonal 2.",
                "Urutan diagonal tidak memengaruhi hasil perkalian.",
                "Pastikan ukuran yang digunakan adalah kedua diagonal, bukan panjang sisi."
            ),
            example = WorkedExample(
                question = "Layang-layang mempunyai diagonal 18 cm dan 12 cm. Berapa luasnya?",
                steps = listOf("Gunakan L = 1/2 × d1 × d2.", "Hitung setengah dari 18 = 9.", "Kalikan 9 × 12.", "Tuliskan hasil dalam cm²."),
                answer = "Luas layang-layang adalah 108 cm²."
            )
        ),
        Subchapter(
            title = "Luas Bangun Gabungan",
            explanation = listOf(
                "Bangun gabungan dapat dibagi menjadi bentuk-bentuk yang rumus luasnya sudah dikenal.",
                "Jika seluruh bagian termasuk daerah yang dicari, jumlahkan luasnya.",
                "Jika ada bagian yang dipotong, kurangi luas bagian tersebut dari bentuk besar.",
                "Gunakan garis bantu agar setiap bagian hanya dihitung satu kali."
            ),
            example = WorkedExample(
                question = "Bangun rumah terdiri atas persegi panjang 12 cm × 8 cm dan atap segitiga beralas 12 cm dengan tinggi 5 cm. Berapa luasnya?",
                steps = listOf("Luas persegi panjang = 96 cm².", "Luas segitiga = 30 cm².", "Jumlahkan kedua bagian.", "Hitung 96 + 30."),
                answer = "Luas bangun gabungan adalah 126 cm²."
            )
        ),
        Subchapter(
            title = "Hubungan Keliling dan Luas",
            explanation = listOf(
                "Keliling mengukur batas, sedangkan luas mengukur daerah.",
                "Persegi panjang dengan keliling sama dapat memiliki luas berbeda.",
                "Jika keliling tetap, jumlah panjang dan lebar juga tetap.",
                "Ukuran yang lebih seimbang menghasilkan luas lebih besar; persegi memberikan luas maksimum."
            ),
            example = WorkedExample(
                question = "Bandingkan luas persegi panjang 20 cm × 10 cm dan 18 cm × 12 cm yang sama-sama berkeliling 60 cm.",
                steps = listOf("Periksa keliling keduanya = 60 cm.", "Luas pertama = 200 cm².", "Luas kedua = 216 cm².", "Hitung selisihnya."),
                answer = "Ukuran 18 cm × 12 cm lebih luas 16 cm²."
            )
        )
    )
}

object CuratedChapterFive {
    val chapter = Chapter(
        id = "bab-5",
        number = 5,
        title = "Luas Daerah Bangun Datar",
        sourcePageStart = 131,
        sourcePageEnd = 162,
        objective = "Memahami konsep luas dan satuan persegi, menemukan rumus luas berbagai bangun datar, menghitung luas bangun gabungan, dan menganalisis hubungan keliling dengan luas.",
        keywords = listOf("luas daerah", "satuan persegi", "petak satuan", "alas", "tinggi", "diagonal", "dekomposisi", "bangun gabungan", "keliling dan luas"),
        summary = listOf(
            "Luas daerah adalah ukuran daerah yang ditempati sebuah bangun.",
            "Luas dapat ditemukan melalui petak persegi satuan dan ditulis dalam cm², m², atau satuan luas.",
            "Memotong dan menyusun kembali tanpa bagian hilang tidak mengubah luas.",
            "Rumus dasar: persegi panjang p × l, persegi s × s, segitiga 1/2 × a × t, dan jajargenjang a × t.",
            "Luas trapesium = 1/2 × jumlah sisi sejajar × tinggi; luas belah ketupat dan layang-layang = 1/2 × d1 × d2.",
            "Luas bangun gabungan dihitung dengan menjumlahkan atau mengurangkan luas bangun penyusunnya.",
            "Bangun dengan keliling sama dapat memiliki luas berbeda; ukuran yang lebih seimbang menghasilkan luas lebih besar."
        ),
        subchapters = ChapterFiveLessonsFoundation.items,
        quiz = ChapterFiveQuiz.questions
    )
}
