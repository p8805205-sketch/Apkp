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
                steps = listOf(
                    "Satu ubin mewakili 1 m².",
                    "Hitung banyak ubin: 7 × 5 = 35.",
                    "Luas sama dengan jumlah petak satuan.",
                    "Tuliskan hasil menggunakan m²."
                ),
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
                steps = listOf(
                    "Gunakan L = p × l.",
                    "Substitusikan 96 = 12 × l.",
                    "Hitung l = 96 ÷ 12.",
                    "Periksa dengan 12 × 8 = 96."
                ),
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
                steps = listOf(
                    "Tentukan alas 14 cm dan tinggi 8 cm.",
                    "Gunakan L = 1/2 × alas × tinggi.",
                    "Hitung 1/2 × 14 = 7.",
                    "Kalikan 7 × 8 = 56."
                ),
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
                steps = listOf(
                    "Tentukan alas dan tinggi yang saling tegak lurus.",
                    "Gunakan L = alas × tinggi.",
                    "Hitung 15 × 9.",
                    "Tuliskan hasil dalam cm²."
                ),
                answer = "Luas jajargenjang adalah 135 cm²."
            )
        )
    )
}
