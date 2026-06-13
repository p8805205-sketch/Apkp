package com.sumberilmu.app.data

fun formatIndonesianNumber(value: Int): String {
    require(value in 0..1_000_000) { "Bilangan harus berada pada rentang 0 sampai 1.000.000" }
    return spell(value).replace(Regex("\\s+"), " ").trim()
}

private fun spell(value: Int): String = when {
    value == 0 -> "nol"
    value < 12 -> listOf(
        "", "satu", "dua", "tiga", "empat", "lima",
        "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"
    )[value]
    value < 20 -> "${spell(value - 10)} belas"
    value < 100 -> "${spell(value / 10)} puluh ${if (value % 10 == 0) "" else spell(value % 10)}"
    value < 200 -> "seratus ${if (value == 100) "" else spell(value - 100)}"
    value < 1_000 -> "${spell(value / 100)} ratus ${if (value % 100 == 0) "" else spell(value % 100)}"
    value < 2_000 -> "seribu ${if (value == 1_000) "" else spell(value - 1_000)}"
    value < 1_000_000 -> "${spell(value / 1_000)} ribu ${if (value % 1_000 == 0) "" else spell(value % 1_000)}"
    else -> "satu juta"
}
