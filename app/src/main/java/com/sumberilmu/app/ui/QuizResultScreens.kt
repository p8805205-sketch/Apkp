package com.sumberilmu.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.QuizResult
import com.sumberilmu.app.data.QuizSession

@Composable
fun QuizScreen(
    session: QuizSession,
    contentPadding: PaddingValues,
    onSelectAnswer: (Int) -> Unit,
    onSubmitAnswer: () -> Unit,
    onNext: () -> Unit
) {
    val question = session.currentQuestion
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text("Soal ${session.currentIndex + 1} dari ${session.questions.size}")
            LinearProgressIndicator(
                progress = { (session.currentIndex + 1f) / session.questions.size },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Text(
                question.prompt,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        itemsIndexed(question.options) { index, option ->
            val selected = session.selectedIndex == index
            val correct = index == question.correctIndex
            val container = when {
                session.submitted && correct -> MaterialTheme.colorScheme.tertiaryContainer
                session.submitted && selected && !correct -> MaterialTheme.colorScheme.errorContainer
                selected -> MaterialTheme.colorScheme.primaryContainer
                else -> MaterialTheme.colorScheme.surface
            }
            OutlinedCard(
                modifier = Modifier.fillMaxWidth().clickable(
                    enabled = !session.submitted,
                    onClick = { onSelectAnswer(index) }
                ),
                colors = CardDefaults.outlinedCardColors(containerColor = container),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selected, onClick = null)
                    Spacer(Modifier.width(8.dp))
                    Text(option.text, modifier = Modifier.weight(1f))
                }
            }
        }
        if (session.submitted) {
            item {
                val selected = requireNotNull(session.selectedIndex)
                InfoCard(question.options[selected].explanation)
            }
        }
        item {
            Button(
                onClick = if (session.submitted) onNext else onSubmitAnswer,
                enabled = session.submitted || session.selectedIndex != null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    when {
                        !session.submitted -> "Periksa Jawaban"
                        session.isLastQuestion -> "Lihat Hasil"
                        else -> "Soal Berikutnya"
                    }
                )
            }
        }
    }
}

@Composable
fun ResultScreen(
    result: QuizResult,
    passScore: Int,
    contentPadding: PaddingValues,
    onRepeat: () -> Unit,
    onBackToChapter: () -> Unit,
    onDashboard: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            ElevatedCard(
                colors = CardDefaults.elevatedCardColors(
                    containerColor = if (result.passed) {
                        MaterialTheme.colorScheme.tertiaryContainer
                    } else {
                        MaterialTheme.colorScheme.errorContainer
                    }
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        result.score.toString(),
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(if (result.passed) "Tuntas" else "Perlu Belajar Ulang")
                    Text("${result.correctAnswers}/${result.totalQuestions} benar • batas lulus $passScore")
                }
            }
        }
        item {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = onBackToChapter, modifier = Modifier.weight(1f)) {
                    Text("Pelajari Lagi")
                }
                Button(onClick = onRepeat, modifier = Modifier.weight(1f)) {
                    Text("Ulangi Quiz")
                }
            }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = onDashboard, modifier = Modifier.fillMaxWidth()) {
                Text("Dashboard")
            }
        }
        item { SectionTitle("Pembahasan Jawaban") }
        itemsIndexed(result.answers) { index, answer ->
            OutlinedCard(shape = RoundedCornerShape(16.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text("Soal ${index + 1}", fontWeight = FontWeight.Bold)
                    Text(answer.question.prompt)
                    Spacer(Modifier.height(6.dp))
                    Text("Jawabanmu: ${answer.question.options[answer.selectedIndex].text}")
                    if (!answer.isCorrect) {
                        Text(
                            "Jawaban benar: ${answer.question.options[answer.question.correctIndex].text}",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(Modifier.height(8.dp))
                    HorizontalDivider()
                    Spacer(Modifier.height(8.dp))
                    Text(answer.question.explanation)
                }
            }
        }
    }
}
