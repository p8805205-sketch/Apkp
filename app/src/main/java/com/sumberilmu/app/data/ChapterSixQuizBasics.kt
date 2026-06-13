package com.sumberilmu.app.data

object ChapterSixQuizBasics {
    val questions = listOf(
        q(1, "Sudut adalah daerah yang dibentuk oleh ...", listOf("Dua garis yang bertemu di satu titik", "Satu garis lurus tanpa titik", "Tiga garis sejajar", "Dua lingkaran yang berpotongan"), "Dua garis yang bertemu di satu titik", "Sudut dibentuk oleh dua kaki sudut yang bertemu pada satu titik sudut.", "mudah", 171),
        q(2, "Titik tempat dua kaki sudut bertemu disebut ...", listOf("Titik sudut", "Garis dasar", "Skala luar", "Pusat lingkaran"), "Titik sudut", "Pertemuan kedua kaki sudut dinamakan titik sudut.", "mudah", 171),
        q(3, "Besar sudut siku-siku adalah ...", listOf("45°", "90°", "180°", "360°"), "90°", "Sudut siku-siku berukuran tepat 90°.", "mudah", 179),
        q(4, "Sudut yang besarnya lebih dari 0° dan kurang dari 90° disebut ...", listOf("Sudut lancip", "Sudut siku-siku", "Sudut tumpul", "Sudut lurus"), "Sudut lancip", "Sudut lancip berada di antara 0° dan 90°.", "mudah", 172),
        q(5, "Sudut 125° termasuk jenis ...", listOf("Lancip", "Siku-siku", "Tumpul", "Refleks"), "Tumpul", "125° lebih besar dari 90° dan lebih kecil dari 180°, sehingga termasuk sudut tumpul.", "mudah", 179),
        q(6, "Sudut lurus mempunyai besar ...", listOf("0°", "90°", "180°", "360°"), "180°", "Dua kaki sudut yang berlawanan arah membentuk sudut lurus 180°.", "mudah", 181),
        q(7, "Sudut refleks adalah sudut yang besarnya ...", listOf("Lebih dari 180° dan kurang dari 360°", "Lebih dari 90° dan kurang dari 180°", "Tepat 90°", "Tepat 360°"), "Lebih dari 180° dan kurang dari 360°", "Rentang sudut refleks adalah lebih dari 180° tetapi kurang dari 360°.", "sedang", 180),
        q(8, "Sudut penuh mempunyai besar ...", listOf("90°", "180°", "270°", "360°"), "360°", "Satu putaran penuh sama dengan 360°.", "mudah", 181),
        q(9, "Sudut yang kedua kakinya berimpit dan tidak membentuk bukaan disebut ...", listOf("Sudut nol", "Sudut lancip", "Sudut tumpul", "Sudut refleks"), "Sudut nol", "Sudut nol mempunyai besar 0°.", "sedang", 181)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(6, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
