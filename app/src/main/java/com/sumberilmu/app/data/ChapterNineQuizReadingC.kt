package com.sumberilmu.app.data

object ChapterNineQuizReadingC {
    val questions = listOf(
        q(9, "Bilangan 149.641 dibaca ...", listOf("Seratus empat puluh sembilan ribu enam ratus empat puluh satu", "Seratus sembilan puluh empat ribu enam ratus empat puluh satu", "Empat belas ribu sembilan ratus enam puluh empat", "Seratus empat puluh sembilan ribu enam ratus empat belas"), "Seratus empat puluh sembilan ribu enam ratus empat puluh satu", "Pisahkan bilangan menjadi 149 ribu dan 641.", "sedang", 291),
        q(10, "Harga Rp345.675,00 dibaca ...", listOf("Tiga ratus empat puluh lima ribu enam ratus tujuh puluh lima rupiah", "Tiga ratus lima puluh empat ribu enam ratus tujuh puluh lima rupiah", "Tiga puluh empat ribu lima ratus enam puluh tujuh rupiah", "Tiga ratus empat puluh lima ribu tujuh ratus enam puluh lima rupiah"), "Tiga ratus empat puluh lima ribu enam ratus tujuh puluh lima rupiah", "Bilangan 345.675 terdiri atas 345 ribu dan 675.", "sedang", 291)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(9, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
