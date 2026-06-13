package com.sumberilmu.app.data

object ChapterSevenQuizTriangles {
    val questions = listOf(
        q(1, "Tiga batang berukuran 3 cm, 5 cm, dan 7 cm dapat membentuk segitiga karena ...", listOf("Jumlah dua sisi terpendek lebih besar dari sisi terpanjang", "Ketiga sisinya sama panjang", "Salah satu sisinya dua kali sisi lain", "Jumlah ketiga sisinya kurang dari 10 cm"), "Jumlah dua sisi terpendek lebih besar dari sisi terpanjang", "Syarat segitiga terpenuhi karena 3 + 5 = 8 lebih besar daripada 7.", "sedang", 195),
        q(2, "Tiga batang berukuran 2 cm, 3 cm, dan 6 cm tidak dapat membentuk segitiga karena ...", listOf("2 + 3 lebih kecil dari 6", "Semua sisinya berbeda", "6 adalah bilangan genap", "2 dan 3 merupakan bilangan prima"), "2 + 3 lebih kecil dari 6", "Jumlah dua sisi terpendek harus lebih besar dari sisi terpanjang. Nilai 2 + 3 = 5, masih lebih kecil dari 6.", "sedang", 195),
        q(3, "Segitiga yang ketiga sisinya sama panjang disebut ...", listOf("Segitiga sama sisi", "Segitiga sama kaki", "Segitiga sembarang", "Segitiga siku-siku"), "Segitiga sama sisi", "Segitiga sama sisi memiliki tiga sisi sama panjang dan tiga sudut sama besar.", "mudah", 198),
        q(4, "Segitiga yang mempunyai tepat dua sisi sama panjang disebut ...", listOf("Segitiga sama kaki", "Segitiga sama sisi", "Segitiga sembarang", "Segitiga tumpul"), "Segitiga sama kaki", "Dua sisi yang sama panjang disebut kaki, sedangkan sisi lainnya menjadi alas.", "mudah", 198),
        q(5, "Segitiga yang ketiga sisinya berbeda panjang disebut ...", listOf("Segitiga sembarang", "Segitiga sama kaki", "Segitiga sama sisi", "Segitiga lancip"), "Segitiga sembarang", "Segitiga sembarang tidak mempunyai pasangan sisi yang sama panjang.", "mudah", 199),
        q(6, "Segitiga yang mempunyai satu sudut 90° disebut ...", listOf("Segitiga siku-siku", "Segitiga lancip", "Segitiga tumpul", "Segitiga sama sisi"), "Segitiga siku-siku", "Satu sudutnya tepat 90°, sedangkan dua sudut lainnya lancip.", "mudah", 201),
        q(7, "Segitiga yang ketiga sudutnya kurang dari 90° disebut ...", listOf("Segitiga lancip", "Segitiga siku-siku", "Segitiga tumpul", "Segitiga refleks"), "Segitiga lancip", "Semua sudut dalam segitiga lancip berukuran kurang dari 90°.", "mudah", 201),
        q(8, "Segitiga yang mempunyai satu sudut lebih dari 90° disebut ...", listOf("Segitiga tumpul", "Segitiga lancip", "Segitiga siku-siku", "Segitiga sama sisi"), "Segitiga tumpul", "Sebuah segitiga hanya dapat mempunyai satu sudut tumpul karena jumlah seluruh sudutnya 180°.", "mudah", 202),
        q(9, "Jumlah besar ketiga sudut dalam setiap segitiga adalah ...", listOf("180°", "90°", "270°", "360°"), "180°", "Apa pun bentuk segitiganya, jumlah ketiga sudut dalam selalu 180°.", "mudah", 204),
        q(10, "Dua sudut sebuah segitiga berukuran 50° dan 60°. Sudut ketiganya adalah ...", listOf("70°", "60°", "80°", "110°"), "70°", "Sudut ketiga = 180° - 50° - 60° = 70°.", "sedang", 205)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(7, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
