package com.sumberilmu.app.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class ScoreCalculatorTest {
    @Test
    fun percentageReturnsExpectedScore() {
        assertEquals(80, ScoreCalculator.percentage(20, 25))
        assertEquals(100, ScoreCalculator.percentage(25, 25))
    }
}
