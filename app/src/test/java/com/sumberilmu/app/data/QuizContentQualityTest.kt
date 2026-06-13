package com.sumberilmu.app.data

import java.io.File
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class QuizContentQualityTest {
    private val chapters = listOf(
        CuratedChapterOne.chapter,
        CuratedChapterTwo.chapter,
        CuratedChapterThree.chapter,
        CuratedChapterFour.chapter,
        CuratedChapterFive.chapter,
        CuratedChapterSix.chapter,
        CuratedChapterSeven.chapter,
        CuratedChapterEight.chapter,
        CuratedChapterNine.chapter
    ).map(QuizContentFormatter::formatChapter)

    @Test
    fun allQuestionsAreStructurallyAndSemanticallyComplete() {
        val issues = mutableListOf<String>()
        val allowedDifficulties = setOf("mudah", "sedang", "menantang")
        val placeholderTokens = listOf(
            "lorem ipsum",
            "pilihan a",
            "pilihan b",
            "jawaban benar",
            "soal latihan ke-",
            "pertanyaan belum tersedia"
        )
        val missingContextTokens = listOf(
            "gambar berikut",
            "gambar di samping",
            "gambar di bawah",
            "gambar di atas",
            "pada gambar",
            "berdasarkan gambar",
            "diagram berikut",
            "diagram di samping",
            "diagram di bawah",
            "diagram di atas",
            "pada diagram",
            "berdasarkan diagram",
            "tabel berikut",
            "tabel di samping",
            "tabel di bawah",
            "tabel di atas",
            "pada tabel",
            "berdasarkan tabel",
            "piktogram berikut",
            "pada piktogram",
            "bangun berikut",
            "bangun di samping",
            "bangun di bawah",
            "bangun di atas"
        )

        assertEquals("Jumlah bab terkurasi harus 9", 9, chapters.size)
        assertEquals("Total soal terkurasi harus 225", 225, chapters.sumOf { it.quiz.size })

        chapters.forEach { chapter ->
            if (chapter.quiz.size != 25) {
                issues += "${chapter.id}: jumlah soal ${chapter.quiz.size}, seharusnya 25"
            }

            chapter.quiz.forEachIndexed { index, question ->
                val label = "${chapter.id}/soal-${index + 1}/${question.id}"
                val prompt = question.prompt.trim()
                val normalizedPrompt = prompt.lowercase()

                if (question.id != "${chapter.id}-soal-${index + 1}") {
                    issues += "$label: ID tidak sesuai urutan"
                }
                if (prompt.length < 20) {
                    issues += "$label: prompt terlalu pendek (${prompt.length} karakter): '$prompt'"
                }
                if ("..." in prompt || "…" in prompt) {
                    issues += "$label: prompt masih mengandung elipsis yang ambigu: '$prompt'"
                }
                if (prompt.endsWith(":") || prompt.endsWith(",")) {
                    issues += "$label: prompt berakhir menggantung: '$prompt'"
                }
                if (placeholderTokens.any { it in normalizedPrompt }) {
                    issues += "$label: mengandung placeholder: '$prompt'"
                }
                val missingContext = missingContextTokens.firstOrNull { it in normalizedPrompt }
                if (missingContext != null) {
                    issues += "$label: merujuk konteks visual '$missingContext' yang tidak tersedia pada model Question: '$prompt'"
                }
                if (Regex("\\b(gambar|diagram|tabel|bangun)\\s+[A-Z0-9]\\b", RegexOption.IGNORE_CASE)
                        .containsMatchIn(prompt)
                ) {
                    issues += "$label: merujuk label visual tanpa media pendamping: '$prompt'"
                }
                if (question.options.size != 4) {
                    issues += "$label: opsi berjumlah ${question.options.size}, seharusnya 4"
                }
                if (question.options.map { it.text.trim().lowercase() }.toSet().size != 4) {
                    issues += "$label: opsi kosong atau duplikat"
                }
                question.options.forEachIndexed { optionIndex, option ->
                    if (option.text.trim().isEmpty()) {
                        issues += "$label/opsi-${optionIndex + 1}: teks kosong"
                    }
                    if (option.explanation.trim().length < 18) {
                        issues += "$label/opsi-${optionIndex + 1}: pembahasan terlalu pendek: '${option.explanation}'"
                    }
                    if (placeholderTokens.any { it in option.text.lowercase() || it in option.explanation.lowercase() }) {
                        issues += "$label/opsi-${optionIndex + 1}: placeholder pada opsi atau pembahasan"
                    }
                }
                if (question.correctIndex !in question.options.indices) {
                    issues += "$label: correctIndex ${question.correctIndex} di luar rentang"
                }
                if (question.explanation.trim().length < 20) {
                    issues += "$label: penjelasan umum terlalu pendek: '${question.explanation}'"
                }
                if (question.difficulty !in allowedDifficulties) {
                    issues += "$label: tingkat kesulitan tidak valid '${question.difficulty}'"
                }
                if (question.sourcePage !in chapter.sourcePageStart..chapter.sourcePageEnd) {
                    issues += "$label: halaman sumber ${question.sourcePage} di luar ${chapter.sourcePageStart}..${chapter.sourcePageEnd}"
                }
            }
        }

        val catalog = buildString {
            appendLine("===== FULL QUIZ CATALOG =====")
            chapters.forEach { chapter ->
                appendLine("## ${chapter.id} | ${chapter.title}")
                chapter.quiz.forEachIndexed { index, question ->
                    appendLine("${index + 1}. [${question.id}] p.${question.sourcePage} ${question.prompt.replace("\n", " ")}")
                    appendLine("   Opsi: ${question.options.joinToString(" | ") { it.text }}")
                    appendLine("   Jawaban: ${question.options[question.correctIndex].text}")
                    appendLine("   Pembahasan: ${question.explanation}")
                }
            }
            appendLine("===== END FULL QUIZ CATALOG =====")
        }
        val report = buildString {
            appendLine()
            appendLine("===== QUIZ CONTENT QUALITY AUDIT =====")
            appendLine("Total soal: ${chapters.sumOf { it.quiz.size }}")
            appendLine("Total masalah: ${issues.size}")
            appendLine(issues.joinToString("\n"))
            appendLine("===== END QUIZ CONTENT QUALITY AUDIT =====")
            appendLine(catalog)
        }
        val workspace = System.getenv("GITHUB_WORKSPACE") ?: System.getProperty("user.dir")
        File(workspace, "lint-debug.log").appendText(report)

        val lintHtml = File(workspace, "app/build/reports/lint-results-debug.html")
        if (lintHtml.exists()) {
            lintHtml.appendText(
                "\n<!-- QUIZ_AUDIT_START -->\n<pre>${escapeHtml(report)}</pre>\n<!-- QUIZ_AUDIT_END -->\n"
            )
        }

        assertTrue(
            "Ditemukan ${issues.size} masalah kualitas quiz:\n${issues.joinToString("\n")}",
            issues.isEmpty()
        )
    }

    @Test
    fun fragmentedPromptBecomesAnExplicitCompletionTask() {
        val result = QuizContentFormatter.completePrompt("57.500 + 22.000 = ...")

        assertTrue(result.startsWith("Pilih jawaban yang paling tepat"))
        assertTrue("57.500 + 22.000 = _____." in result)
        assertFalse("..." in result)
    }

    @Test
    fun multipleBlankMarkersAreConvertedConsistently() {
        val result = QuizContentFormatter.completePrompt(
            "Pada pecahan 3/5, angka 3 disebut ... dan angka 5 disebut ..."
        )

        assertEquals(2, Regex("_____").findAll(result).count())
        assertFalse("..." in result)
    }

    @Test
    fun completePromptIsPreservedAndPunctuated() {
        assertEquals(
            "Manakah bilangan yang paling besar?",
            QuizContentFormatter.completePrompt("Manakah bilangan yang paling besar?")
        )
        assertEquals(
            "Pilih jawaban yang benar.",
            QuizContentFormatter.completePrompt("Pilih jawaban yang benar")
        )
    }

    private fun escapeHtml(value: String): String = value
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
}
