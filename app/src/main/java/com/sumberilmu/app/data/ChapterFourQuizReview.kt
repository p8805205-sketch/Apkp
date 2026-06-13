package com.sumberilmu.app.data

object ChapterFourQuizReview {
    val questions = listOf(
        CuratedQuestionFactory.create(4, 23, "Kebun berukuran 30 m × 20 m akan dipagari seluruhnya. Panjang pagar yang dibutuhkan ...", listOf("50 m", "80 m", "100 m", "600 m"), "100 m", "Keliling kebun = 2 × (30 + 20) = 100 m.", "sedang", 108),
        CuratedQuestionFactory.create(4, 24, "Persegi bersisi 15 cm dan persegi panjang 20 cm × 10 cm mempunyai keliling yang ...", listOf("Persegi lebih besar", "Persegi panjang lebih besar", "Sama besar", "Tidak dapat dibandingkan"), "Sama besar", "Keliling keduanya 60 cm.", "sedang", 124),
        CuratedQuestionFactory.create(4, 25, "Pernyataan yang benar tentang rumus 4 × sisi adalah ...", listOf("Berlaku untuk semua segi empat", "Berlaku untuk trapesium sembarang", "Berlaku ketika keempat sisi sama panjang", "Berlaku untuk semua bangun gabungan"), "Berlaku ketika keempat sisi sama panjang", "Rumus 4 × sisi hanya tepat untuk bangun yang keempat sisinya sama panjang.", "sedang", 121)
    )
}
