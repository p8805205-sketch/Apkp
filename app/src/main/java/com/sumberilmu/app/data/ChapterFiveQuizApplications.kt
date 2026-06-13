package com.sumberilmu.app.data

object ChapterFiveQuizApplications {
    val questions = listOf(
        q(18, "Bangun gabungan terdiri atas persegi panjang 10 cm × 6 cm dan segitiga beralas 10 cm serta tinggi 4 cm. Luas seluruhnya ...", listOf("70 cm²", "80 cm²", "90 cm²", "100 cm²"), "80 cm²", "Luas persegi panjang 60 cm² dan luas segitiga 20 cm², sehingga total 80 cm².", "sedang", 158),
        q(19, "Sebuah bangun gabungan memiliki bagian seluas 72 cm² dan 28 cm². Luas keseluruhan ...", listOf("44 cm²", "90 cm²", "100 cm²", "2.016 cm²"), "100 cm²", "Jumlahkan luas kedua bagian: 72 + 28 = 100 cm².", "mudah", 159),
        q(20, "Pada Uji Kompetensi, sebuah layang-layang mempunyai diagonal 24 cm dan 18 cm. Luasnya ...", listOf("216 cm²", "432 cm²", "84 cm²", "168 cm²"), "216 cm²", "Luas = 1/2 × 24 × 18 = 216 cm².", "sedang", 162),
        q(21, "Bangun gabungan terdiri atas jajargenjang beralas 16 cm dan tinggi 8 cm serta segitiga beralas 16 cm dan tinggi 12 cm. Luas seluruhnya ...", listOf("176 cm²", "208 cm²", "224 cm²", "320 cm²"), "224 cm²", "Luas jajargenjang 128 cm² dan segitiga 96 cm², sehingga total 224 cm².", "menantang", 162)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) = CuratedQuestionFactory.create(5, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
