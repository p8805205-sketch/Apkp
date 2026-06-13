package com.sumberilmu.app.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class IndonesianNumberFormatterTest {
    @Test
    fun formatsBoundaryValues() {
        assertEquals("nol", formatIndonesianNumber(0))
        assertEquals("seribu", formatIndonesianNumber(1_000))
        assertEquals("satu juta", formatIndonesianNumber(1_000_000))
    }

    @Test
    fun formatsSourceExamples() {
        assertEquals(
            "seratus empat puluh sembilan ribu enam ratus empat puluh satu",
            formatIndonesianNumber(149_641)
        )
        assertEquals(
            "sembilan ratus tujuh puluh sembilan ribu delapan ratus tujuh puluh lima",
            formatIndonesianNumber(979_875)
        )
    }

    @Test
    fun formatsZeroPlaceValuesWithoutExtraSpaces() {
        assertEquals("lima ratus lima puluh ribu tiga ratus tiga", formatIndonesianNumber(550_303))
        assertEquals("sembilan ratus tiga puluh tiga ribu empat ratus tiga", formatIndonesianNumber(933_403))
    }

    @Test
    fun rejectsValuesOutsideSupportedRange() {
        assertThrows(IllegalArgumentException::class.java) {
            formatIndonesianNumber(-1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            formatIndonesianNumber(1_000_001)
        }
    }
}
