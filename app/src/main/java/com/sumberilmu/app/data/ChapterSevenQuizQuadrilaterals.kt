package com.sumberilmu.app.data

object ChapterSevenQuizQuadrilaterals {
    val questions = listOf(
        q(11, "Ciri yang selalu dimiliki persegi adalah ...", listOf("Empat sisi sama panjang dan empat sudut siku-siku", "Hanya dua sisi sama panjang", "Tepat satu pasang sisi sejajar", "Tidak mempunyai diagonal"), "Empat sisi sama panjang dan empat sudut siku-siku", "Persegi mempunyai empat sisi sama panjang, empat sudut 90°, dan dua pasang sisi sejajar.", "mudah", 210),
        q(12, "Ciri utama persegi panjang adalah ...", listOf("Sisi berhadapan sama panjang dan empat sudut siku-siku", "Empat sisi selalu sama panjang", "Tidak mempunyai sisi sejajar", "Semua sudutnya lancip"), "Sisi berhadapan sama panjang dan empat sudut siku-siku", "Persegi panjang mempunyai dua pasang sisi berhadapan sama panjang dan sejajar serta empat sudut 90°.", "mudah", 211),
        q(13, "Jajargenjang mempunyai ...", listOf("Dua pasang sisi berhadapan sejajar dan sama panjang", "Empat sudut siku-siku", "Empat sisi selalu sama panjang", "Tepat satu pasang sisi sejajar"), "Dua pasang sisi berhadapan sejajar dan sama panjang", "Sisi berhadapan pada jajargenjang sejajar dan sama panjang, sedangkan sudut berhadapan sama besar.", "mudah", 214),
        q(14, "Belah ketupat mempunyai ...", listOf("Empat sisi sama panjang", "Empat sudut siku-siku", "Tidak mempunyai sisi sejajar", "Hanya satu diagonal"), "Empat sisi sama panjang", "Belah ketupat mempunyai empat sisi sama panjang dan dua pasang sisi berhadapan sejajar.", "mudah", 216),
        q(15, "Layang-layang mempunyai ...", listOf("Dua pasang sisi berdekatan sama panjang", "Dua pasang sisi berhadapan selalu sejajar", "Empat sudut siku-siku", "Empat sisi selalu sama panjang"), "Dua pasang sisi berdekatan sama panjang", "Pada layang-layang, sisi-sisi yang sama panjang bertemu pada titik sudut yang sama.", "mudah", 218),
        q(16, "Trapesium mempunyai ciri ...", listOf("Paling sedikit satu pasang sisi sejajar", "Empat sisi sama panjang", "Empat sudut siku-siku", "Tidak mempunyai sisi sejajar"), "Paling sedikit satu pasang sisi sejajar", "Trapesium dikenali dari adanya satu pasang sisi sejajar; jenis khusus dapat memiliki sifat tambahan.", "mudah", 220),
        q(17, "Diagonal persegi panjang mempunyai sifat ...", listOf("Sama panjang dan saling membagi dua", "Saling tegak lurus tetapi tidak sama panjang", "Hanya satu diagonal", "Tidak saling berpotongan"), "Sama panjang dan saling membagi dua", "Kedua diagonal persegi panjang sama panjang dan berpotongan di titik tengah masing-masing.", "sedang", 212),
        q(18, "Diagonal belah ketupat mempunyai sifat ...", listOf("Saling tegak lurus dan saling membagi dua", "Selalu sama panjang", "Tidak berpotongan", "Sejajar satu sama lain"), "Saling tegak lurus dan saling membagi dua", "Diagonal belah ketupat berpotongan tegak lurus dan masing-masing terbagi menjadi dua sama panjang.", "sedang", 217),
        q(19, "Pada layang-layang, diagonal-diagonalnya ...", listOf("Saling tegak lurus dan salah satunya membagi diagonal lain", "Selalu sama panjang dan sejajar", "Tidak pernah berpotongan", "Membentuk empat sudut lancip"), "Saling tegak lurus dan salah satunya membagi diagonal lain", "Salah satu diagonal layang-layang menjadi sumbu simetri dan membagi diagonal lainnya menjadi dua.", "sedang", 219)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(7, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
