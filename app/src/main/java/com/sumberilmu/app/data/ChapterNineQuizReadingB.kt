package com.sumberilmu.app.data

object ChapterNineQuizReadingB {
    val questions = listOf(
        q(6, "Pada bilangan 179.500, angka 9 menempati nilai tempat ...", listOf("Ribuan", "Puluh ribuan", "Ratusan", "Puluhan"), "Ribuan", "Angka 9 pada 179.500 bernilai 9.000.", "sedang", 283),
        q(7, "Lima ratus lima puluh ribu tiga ratus tiga ditulis ...", listOf("550.303", "550.330", "505.303", "553.003"), "550.303", "550.000 + 303 = 550.303.", "sedang", 291),
        q(8, "900.000 + 33.000 + 403 adalah ...", listOf("933.403", "903.343", "930.403", "933.043"), "933.403", "Jumlahnya 933.403.", "menantang", 291)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(9, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
