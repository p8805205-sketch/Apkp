package com.sumberilmu.app.data

object ChapterNineQuizReadingA {
    val questions = listOf(
        q(1, "Bilangan 979.875 dibaca ...", listOf("Sembilan ratus tujuh puluh sembilan ribu delapan ratus tujuh puluh lima", "Sembilan puluh tujuh ribu sembilan ratus delapan puluh lima", "Sembilan ratus tujuh puluh sembilan ribu delapan ratus lima puluh tujuh", "Sembilan juta tujuh ratus sembilan puluh delapan ribu tujuh puluh lima"), "Sembilan ratus tujuh puluh sembilan ribu delapan ratus tujuh puluh lima", "Pisahkan menjadi 979 ribu dan 875, lalu baca setiap kelompok tiga angka.", "mudah", 276),
        q(2, "Sembilan ratus enam puluh tiga ribu ditulis ...", listOf("963.000", "936.000", "963.300", "96.300"), "963.000", "Sembilan ratus enam puluh tiga ribu berarti 963 kelompok ribuan.", "mudah", 277),
        q(3, "Pada bilangan 324.569, angka 3 menempati nilai tempat ...", listOf("Ratus ribuan", "Puluh ribuan", "Ribuan", "Ratusan"), "Ratus ribuan", "Angka 3 bernilai 300.000 sehingga menempati ratus ribuan.", "mudah", 281),
        q(4, "Pada harga Rp296.575,00, angka 9 menempati nilai tempat ...", listOf("Puluh ribuan", "Ratus ribuan", "Ribuan", "Ratusan"), "Puluh ribuan", "Angka 9 bernilai 90.000 sehingga menempati puluh ribuan.", "sedang", 283),
        q(5, "Nilai angka 4 pada bilangan 834.759 adalah ...", listOf("4.000", "40.000", "400", "400.000"), "4.000", "Angka 4 berada pada tempat ribuan sehingga nilainya 4.000.", "sedang", 282)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(9, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
