package com.sumberilmu.app.data

object ChapterFiveQuizBasics {
    val questions = listOf(
        q(1, "Luas daerah bangun datar adalah ...", listOf("Ukuran daerah yang ditempati bangun", "Jumlah panjang semua sisi", "Banyak titik sudut", "Panjang sisi terpanjang"), "Ukuran daerah yang ditempati bangun", "Luas menyatakan ukuran daerah yang ditempati suatu bangun datar.", "mudah", 133),
        q(2, "Satuan yang tepat untuk menyatakan luas lantai adalah ...", listOf("meter", "meter persegi", "liter", "kilogram"), "meter persegi", "Luas menggunakan satuan persegi, misalnya cm² atau m².", "mudah", 137),
        q(3, "Sebuah lantai tertutup oleh 6 baris ubin dan setiap baris berisi 4 ubin berukuran 1 m². Luas lantai adalah ...", listOf("10 m²", "20 m²", "24 m²", "48 m²"), "24 m²", "Banyak petak satuan = 6 × 4 = 24.", "mudah", 139),
        q(4, "Sebuah bangun dipotong lalu disusun kembali tanpa bagian hilang. Luasnya ...", listOf("Tetap", "Menjadi dua kali", "Menjadi setengah", "Tidak dapat ditentukan"), "Tetap", "Penyusunan ulang tanpa menambah atau mengurangi bagian tidak mengubah luas.", "sedang", 143),
        q(5, "Persegi panjang berukuran 8 cm × 5 cm memiliki luas ...", listOf("13 cm²", "26 cm²", "40 cm²", "80 cm²"), "40 cm²", "Luas persegi panjang = 8 × 5 = 40 cm².", "mudah", 145),
        q(6, "Persegi dengan panjang sisi 9 cm memiliki luas ...", listOf("18 cm²", "36 cm²", "72 cm²", "81 cm²"), "81 cm²", "Luas persegi = 9 × 9 = 81 cm².", "mudah", 146),
        q(7, "Luas persegi panjang 72 cm² dan panjangnya 9 cm. Lebarnya adalah ...", listOf("6 cm", "8 cm", "9 cm", "12 cm"), "8 cm", "Lebar = 72 ÷ 9 = 8 cm.", "sedang", 145),
        q(8, "Luas sebuah persegi 64 cm². Panjang sisinya adalah ...", listOf("4 cm", "8 cm", "16 cm", "32 cm"), "8 cm", "Luas persegi dihitung dengan sisi × sisi. Karena 8 × 8 = 64, panjang sisinya adalah 8 cm.", "sedang", 146),
        q(9, "Segitiga mempunyai alas 12 cm dan tinggi 7 cm. Luasnya ...", listOf("42 cm²", "84 cm²", "19 cm²", "38 cm²"), "42 cm²", "Luas = 1/2 × 12 × 7 = 42 cm².", "mudah", 150),
        q(10, "Luas segitiga 54 cm² dan panjang alasnya 12 cm. Tingginya ...", listOf("4,5 cm", "8 cm", "9 cm", "12 cm"), "9 cm", "54 = 6 × tinggi, sehingga tinggi 9 cm.", "menantang", 150),
        q(11, "Jajargenjang mempunyai alas 14 cm dan tinggi 6 cm. Luasnya ...", listOf("40 cm²", "42 cm²", "84 cm²", "168 cm²"), "84 cm²", "Luas jajargenjang = 14 × 6 = 84 cm².", "mudah", 152),
        q(12, "Luas jajargenjang 96 cm² dan tingginya 8 cm. Panjang alasnya ...", listOf("8 cm", "10 cm", "12 cm", "16 cm"), "12 cm", "Alas = 96 ÷ 8 = 12 cm.", "sedang", 152),
        q(13, "Trapesium mempunyai sisi sejajar 10 cm dan 16 cm serta tinggi 7 cm. Luasnya ...", listOf("91 cm²", "182 cm²", "70 cm²", "112 cm²"), "91 cm²", "Luas = 1/2 × 26 × 7 = 91 cm².", "sedang", 154)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(5, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
