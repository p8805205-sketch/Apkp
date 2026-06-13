package com.sumberilmu.app.domain

object ScoreCalculator {
    fun percentage(correctAnswers: Int, totalQuestions: Int): Int {
        require(correctAnswers >= 0) { "correctAnswers must not be negative" }
        require(totalQuestions > 0) { "totalQuestions must be greater than zero" }
        require(correctAnswers <= totalQuestions) {
            "correctAnswers must not exceed totalQuestions"
        }
        return ((correctAnswers.toDouble() / totalQuestions) * 100).toInt()
    }
}
