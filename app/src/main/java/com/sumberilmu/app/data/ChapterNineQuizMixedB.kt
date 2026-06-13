package com.sumberilmu.app.data

object ChapterNineQuizMixedB {
    val questions = listOf(
        q(21, "Dekomposisi yang benar untuk 678.987 adalah ...", listOf("600.000 + 70.000 + 8.000 + 900 + 80 + 7", "600.000 + 70.000 + 8.000 + 800 + 80 + 7", "600.000 + 7.000 + 800 + 90 + 7", "60.000 + 70.000 + 8.000 + 900 + 80 + 7"), "600.000 + 70.000 + 8.000 + 900 + 80 + 7", "Digit 6, 7, 8, 9, 8, dan 7 dikalikan nilai tempatnya masing-masing.", "menantang", 292),
        q(22, "2 ratus ribuan + 3 ribuan + 3 puluhan + 5 satuan adalah ...", listOf("203.035", "203.305", "230.035", "200.335"), "203.035", "200.000 + 3.000 + 30 + 5 = 203.035.", "sedang", 292),
        q(23, "Uang Yosep terdiri atas 5 lembar Rp100.000, 4 lembar Rp20.000, 3 lembar Rp10.000, 1 lembar Rp5.000, dan 4 lembar Rp2.000. Jumlahnya ...", listOf("Rp623.000", "Rp613.000", "Rp633.000", "Rp603.000"), "Rp623.000", "500.000 + 80.000 + 30.000 + 5.000 + 8.000 = 623.000.", "menantang", 288),
        q(24, "Uang Komang terdiri atas 4 lembar Rp100.000, 3 lembar Rp20.000, 2 lembar Rp10.000, 1 lembar Rp5.000, dan 4 lembar Rp2.000. Jumlahnya ...", listOf("Rp493.000", "Rp483.000", "Rp503.000", "Rp463.000"), "Rp493.000", "400.000 + 60.000 + 20.000 + 5.000 + 8.000 = 493.000.", "menantang", 289),
        q(25, "Nisa mempunyai Rp250.000 dan menerima kembalian Rp15.400. Harga buku yang dibeli adalah ...", listOf("Rp234.600", "Rp235.400", "Rp265.400", "Rp224.600"), "Rp234.600", "Harga buku = Rp250.000 - Rp15.400 = Rp234.600.", "menantang", 292)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(9, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
