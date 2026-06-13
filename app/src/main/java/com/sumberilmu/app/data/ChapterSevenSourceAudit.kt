package com.sumberilmu.app.data

data class SourceAuditStatement(
    val number: Int,
    val statement: String,
    val isTrue: Boolean,
    val explanation: String,
    val sourcePage: Int
)

object ChapterSevenSourceAudit {
    val ujiKompetensi = listOf(
        SourceAuditStatement(1, "Ruas garis 5 cm, 7 cm, dan 1 cm dapat membentuk segitiga.", false, "Tidak, karena 5 + 1 = 6 lebih kecil dari 7.", 234),
        SourceAuditStatement(2, "Semua sudut pada segitiga siku-siku adalah sudut siku-siku.", false, "Hanya satu sudut yang 90°; dua sudut lainnya lancip.", 234),
        SourceAuditStatement(3, "Jumlah tiga sudut dalam segitiga adalah 180°.", true, "Jumlah sudut dalam setiap segitiga selalu 180°.", 234),
        SourceAuditStatement(4, "Segitiga sama sisi dapat digolongkan sebagai segitiga sama kaki.", true, "Segitiga sama sisi mempunyai setidaknya dua sisi sama panjang.", 234),
        SourceAuditStatement(5, "Jajargenjang merupakan trapesium sama kaki.", false, "Jajargenjang termasuk trapesium menurut definisi inklusif, tetapi bukan trapesium sama kaki karena tidak mempunyai satu sumbu simetri.", 234),
        SourceAuditStatement(6, "Persegi panjang adalah jajargenjang yang salah satu sudutnya siku-siku.", true, "Semua ciri jajargenjang dimiliki persegi panjang; sudut siku-siku adalah ciri tambahannya.", 234),
        SourceAuditStatement(7, "Belah ketupat dapat digolongkan sebagai jajargenjang dan layang-layang.", true, "Sisi berhadapan sejajar dan dua pasang sisi berurutan sama panjang memenuhi kedua kelompok.", 234),
        SourceAuditStatement(8, "Persegi tidak dapat disebut persegi panjang.", false, "Persegi memenuhi seluruh ciri persegi panjang.", 234),
        SourceAuditStatement(9, "Persegi bukan belah ketupat.", false, "Persegi memenuhi seluruh ciri belah ketupat dan memiliki sudut siku-siku sebagai ciri tambahan.", 234),
        SourceAuditStatement(10, "Salah satu diagonal layang-layang merupakan sumbu simetri.", true, "Salah satu diagonal membagi layang-layang menjadi dua bagian yang berimpit.", 234)
    )

    val expectedAnswers = listOf(false, false, true, true, false, true, true, false, false, true)
}
