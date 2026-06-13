package com.sumberilmu.app.data

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class ContentRepository(private val context: Context) {

    fun loadCatalog(): LearningCatalog {
        val raw = context.assets.open("content.json")
            .bufferedReader()
            .use { it.readText() }
        val root = JSONObject(raw)

        return LearningCatalog(
            appName = root.getString("appName"),
            curriculum = root.getString("curriculum"),
            level = root.getString("level"),
            grade = root.getString("grade"),
            subject = root.getString("subject"),
            semester = root.getString("semester"),
            passScore = root.getInt("passScore"),
            quizQuestionsPerChapter = root.getInt("quizQuestionsPerChapter"),
            source = root.getJSONObject("source").toContentSource(),
            chapters = root.getJSONArray("chapters").mapObjects { it.toChapter() }
        )
    }
}

private fun JSONObject.toContentSource() = ContentSource(
    title = getString("title"),
    publisher = getString("publisher"),
    year = getInt("year"),
    isbn = getString("isbn"),
    note = getString("note")
)

private fun JSONObject.toChapter() = Chapter(
    id = getString("id"),
    number = getInt("number"),
    title = getString("title"),
    sourcePageStart = getInt("sourcePageStart"),
    sourcePageEnd = getInt("sourcePageEnd"),
    objective = getString("objective"),
    keywords = getJSONArray("keywords").toStringList(),
    summary = getJSONArray("summary").toStringList(),
    subchapters = getJSONArray("subchapters").mapObjects { it.toSubchapter() },
    quiz = getJSONArray("quiz").mapObjects { it.toQuestion() }
)

private fun JSONObject.toSubchapter() = Subchapter(
    title = getString("title"),
    explanation = getJSONArray("explanation").toStringList(),
    example = getJSONObject("example").toWorkedExample()
)

private fun JSONObject.toWorkedExample() = WorkedExample(
    question = getString("question"),
    steps = getJSONArray("steps").toStringList(),
    answer = getString("answer")
)

private fun JSONObject.toQuestion() = Question(
    id = getString("id"),
    prompt = getString("prompt"),
    options = getJSONArray("options").mapObjects { it.toQuestionOption() },
    correctIndex = getInt("correctIndex"),
    explanation = getString("explanation"),
    difficulty = getString("difficulty"),
    sourcePage = getInt("sourcePage")
)

private fun JSONObject.toQuestionOption() = QuestionOption(
    text = getString("text"),
    explanation = getString("explanation")
)

private fun JSONArray.toStringList(): List<String> =
    List(length()) { index -> getString(index) }

private inline fun <T> JSONArray.mapObjects(transform: (JSONObject) -> T): List<T> =
    List(length()) { index -> transform(getJSONObject(index)) }
