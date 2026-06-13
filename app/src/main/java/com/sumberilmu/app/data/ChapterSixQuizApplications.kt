package com.sumberilmu.app.data

object ChapterSixQuizApplications {
    val questions = listOf(
        q(19, "Jika kaki awal berimpit dengan 0° di sebelah kanan, skala yang dibaca adalah ...", listOf("Skala yang dimulai dari 0° di kanan", "Skala yang dimulai dari 180° di kanan", "Selalu skala luar", "Selalu skala dalam"), "Skala yang dimulai dari 0° di kanan", "Pembacaan dimulai dari 0° yang berimpit dengan kaki awal.", "sedang", 179),
        q(20, "Sudut 150° termasuk ...", listOf("Lancip", "Siku-siku", "Tumpul", "Refleks"), "Tumpul", "150° berada di antara 90° dan 180°.", "mudah", 183),
        q(21, "Sudut refleks yang melengkapi 125° menjadi satu putaran adalah ...", listOf("55°", "125°", "235°", "305°"), "235°", "Satu putaran penuh berukuran 360°. Sudut refleks yang melengkapi 125° adalah 360° − 125° = 235°.", "menantang", 180),
        q(22, "Setelah membuat satu kaki sudut, langkah berikutnya saat melukis 150° adalah ...", listOf("Meletakkan pusat busur pada titik sudut", "Menggambar lingkaran", "Menghapus kaki sudut", "Membagi garis"), "Meletakkan pusat busur pada titik sudut", "Pusat busur harus berimpit dengan titik sudut.", "mudah", 183),
        q(23, "Sudut antara dua jalan berukuran 130°. Jenisnya adalah ...", listOf("Lancip", "Siku-siku", "Tumpul", "Refleks"), "Tumpul", "130° lebih besar dari 90° dan lebih kecil dari 180°.", "sedang", 189),
        q(24, "Persimpangan ideal membentuk sudut siku-siku. Besarnya ...", listOf("45°", "90°", "130°", "180°"), "90°", "Sudut siku-siku berukuran 90°.", "mudah", 189),
        q(25, "Tiga sudut 108° bertemu pada satu titik. Besar celah yang tersisa ...", listOf("18°", "36°", "54°", "108°"), "36°", "360° - 3 × 108° = 36°.", "menantang", 190)
    )

    private fun q(id: Int, prompt: String, options: List<String>, correct: String, explanation: String, difficulty: String, sourcePage: Int) =
        CuratedQuestionFactory.create(6, id, prompt, options, correct, explanation, difficulty, sourcePage)
}
