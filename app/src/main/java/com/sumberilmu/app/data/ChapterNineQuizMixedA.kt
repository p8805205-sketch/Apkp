package com.sumberilmu.app.data

object ChapterNineQuizMixedA {
    val questions = listOf(
        q(16, "Urutan wisatawan dari terbesar adalah ...", listOf("433.027, 416.373, 397.951, 355.313, 69.968", "69.968, 355.313, 397.951, 416.373, 433.027", "433.027, 397.951, 416.373, 355.313, 69.968", "416.373, 433.027, 397.951, 355.313, 69.968"), "433.027, 416.373, 397.951, 355.313, 69.968", "Bandingkan mulai dari ratus ribuan lalu digit berikutnya.", "menantang", 286),
        q(17, "Urutan dari terkecil yang benar adalah ...", listOf("676.785, 786.897, 789.867, 789.876", "676.785, 786.897, 789.876, 789.867", "789.867, 789.876, 786.897, 676.785", "786.897, 676.785, 789.867, 789.876"), "676.785, 786.897, 789.867, 789.876", "Pada dua bilangan terakhir, 789.867 lebih kecil daripada 789.876.", "menantang", 291),
        q(18, "3 ratus ribuan + 2 puluh ribuan + 7 ribuan + 1 ratusan adalah ...", listOf("327.100", "327.010", "320.710", "372.100"), "327.100", "300.000 + 20.000 + 7.000 + 100 = 327.100.", "sedang", 291),
        q(19, "5 ratus ribuan + 5 ribuan + 4 ratusan + 1 satuan adalah ...", listOf("505.401", "550.401", "505.041", "500.541"), "505.401", "500.000 + 5.000 + 400 + 1 = 505.401.", "sedang", 291),
        q(20, "8 ratus ribuan + 5 puluh ribuan + 7 ribuan + 2 ratusan + 5 puluhan + 9 satuan adalah ...", listOf("857.259", "875.259", "857.529", "850.729"), "857.259", "Jumlah nilai tempatnya adalah 857.259.", "menantang", 291)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(9, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
