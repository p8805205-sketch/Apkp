package com.sumberilmu.app.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.NavigateNext
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Question
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
    val accent = BrandIndigo
    val progressValue = (session.currentIndex + 1f) / session.questions.size

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            QuizProgressHeader(
                current = session.currentIndex + 1,
                total = session.questions.size,
                progress = progressValue,
                question = question,
                accent = accent
            )
        }

        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                shape = RoundedCornerShape(26.dp)
            ) {
                Column(Modifier.padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(accent.copy(alpha = 0.12f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                Icons.Rounded.Quiz,
                                contentDescription = null,
                                tint = accent
                            )
                        }
                        Spacer(Modifier.width(11.dp))
                        Text(
                            "Pilih jawaban paling tepat",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(Modifier.height(18.dp))
                    Text(
                        question.prompt,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }

        itemsIndexed(question.options) { index, option ->
            QuizOptionCard(
                index = index,
                text = option.text,
                selected = session.selectedIndex == index,
                submitted = session.submitted,
                correct = index == question.correctIndex,
                onClick = { onSelectAnswer(index) }
            )
        }

        if (session.submitted) {
            item {
                val selected = requireNotNull(session.selectedIndex)
                val isCorrect = selected == question.correctIndex
                FeedbackCard(
                    isCorrect = isCorrect,
                    text = question.options[selected].explanation
                )
            }
        }

        item {
            Button(
                onClick = if (session.submitted) onNext else onSubmitAnswer,
                enabled = session.submitted || session.selectedIndex != null,
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(18.dp)
            ) {
                Text(
                    when {
                        !session.submitted -> "Periksa jawaban"
                        session.isLastQuestion -> "Lihat hasil quiz"
                        else -> "Soal berikutnya"
                    },
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(7.dp))
                Icon(Icons.Rounded.NavigateNext, contentDescription = null)
            }
        }
    }
}

@Composable
private fun QuizProgressHeader(
    current: Int,
    total: Int,
    progress: Float,
    question: Question,
    accent: Color
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Soal $current dari $total",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "Halaman sumber ${question.sourcePage}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            StatusPill(
                text = question.difficulty.replaceFirstChar { it.uppercase() },
                accent = when (question.difficulty) {
                    "mudah" -> BrandTeal
                    "sedang" -> BrandAmber
                    else -> BrandPink
                }
            )
        }
        Spacer(Modifier.height(10.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth().height(9.dp).clip(CircleShape),
            color = accent,
            trackColor = MaterialTheme.colorScheme.surfaceVariant
        )
    }
}

@Composable
private fun QuizOptionCard(
    index: Int,
    text: String,
    selected: Boolean,
    submitted: Boolean,
    correct: Boolean,
    onClick: () -> Unit
) {
    val isWrongSelection = submitted && selected && !correct
    val containerColor = when {
        submitted && correct -> MaterialTheme.colorScheme.tertiaryContainer
        isWrongSelection -> MaterialTheme.colorScheme.errorContainer
        selected -> MaterialTheme.colorScheme.primaryContainer
        else -> MaterialTheme.colorScheme.surface
    }
    val borderColor = when {
        submitted && correct -> MaterialTheme.colorScheme.tertiary
        isWrongSelection -> MaterialTheme.colorScheme.error
        selected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outlineVariant
    }
    val badgeColor = when {
        submitted && correct -> MaterialTheme.colorScheme.tertiary
        isWrongSelection -> MaterialTheme.colorScheme.error
        selected -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = !submitted, onClick = onClick),
        color = containerColor,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(if (selected || submitted && correct) 2.dp else 1.dp, borderColor)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(badgeColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    ('A' + index).toString(),
                    color = if (selected || submitted && correct || isWrongSelection) {
                        Color.White
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    },
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Spacer(Modifier.width(13.dp))
            Text(
                text,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
            )
            if (submitted && correct) {
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Rounded.CheckCircle,
                    contentDescription = "Jawaban benar",
                    tint = MaterialTheme.colorScheme.tertiary
                )
            } else if (isWrongSelection) {
                Spacer(Modifier.width(8.dp))
                Icon(
                    Icons.Rounded.Cancel,
                    contentDescription = "Jawaban salah",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
private fun FeedbackCard(isCorrect: Boolean, text: String) {
    val accent = if (isCorrect) BrandTeal else MaterialTheme.colorScheme.error
    Card(
        colors = CardDefaults.cardColors(
            containerColor = accent.copy(alpha = 0.09f)
        ),
        border = BorderStroke(1.dp, accent.copy(alpha = 0.22f)),
        shape = RoundedCornerShape(22.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(17.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                if (isCorrect) Icons.Rounded.CheckCircle else Icons.Rounded.Cancel,
                contentDescription = null,
                tint = accent,
                modifier = Modifier.size(28.dp)
            )
            Spacer(Modifier.width(11.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    if (isCorrect) "Jawaban tepat" else "Mari perbaiki",
                    color = accent,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(5.dp))
                Text(text, style = MaterialTheme.typography.bodyLarge)
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
    val wrongAnswers = result.totalQuestions - result.correctAnswers
    val accent = if (result.passed) BrandTeal else BrandOrange

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ResultHero(result, passScore, accent)
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MetricTile(
                    value = result.correctAnswers.toString(),
                    label = "Benar",
                    accent = BrandTeal,
                    modifier = Modifier.weight(1f)
                )
                MetricTile(
                    value = wrongAnswers.toString(),
                    label = "Perlu ditinjau",
                    accent = MaterialTheme.colorScheme.error,
                    modifier = Modifier.weight(1f)
                )
                MetricTile(
                    value = passScore.toString(),
                    label = "Batas lulus",
                    accent = BrandIndigo,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            Row(horizontalArrangement = Arrangement.spacedBy(9.dp)) {
                OutlinedButton(
                    onClick = onBackToChapter,
                    modifier = Modifier.weight(1f).height(52.dp),
                    shape = RoundedCornerShape(17.dp)
                ) {
                    Icon(Icons.Rounded.MenuBook, contentDescription = null)
                    Spacer(Modifier.width(6.dp))
                    Text("Pelajari")
                }
                Button(
                    onClick = onRepeat,
                    modifier = Modifier.weight(1f).height(52.dp),
                    shape = RoundedCornerShape(17.dp)
                ) {
                    Icon(Icons.Rounded.Refresh, contentDescription = null)
                    Spacer(Modifier.width(6.dp))
                    Text("Ulangi")
                }
            }
            Spacer(Modifier.height(9.dp))
            OutlinedButton(
                onClick = onDashboard,
                modifier = Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(17.dp)
            ) {
                Icon(Icons.Rounded.Home, contentDescription = null)
                Spacer(Modifier.width(7.dp))
                Text("Kembali ke dashboard")
            }
        }

        item {
            SectionTitle(
                text = "Pembahasan jawaban",
                supportingText = "Tinjau alasan di balik setiap jawaban"
            )
        }

        itemsIndexed(result.answers) { index, answer ->
            ReviewAnswerCard(index = index, answer = answer)
        }
    }
}

@Composable
private fun ResultHero(result: QuizResult, passScore: Int, accent: Color) {
    val gradient = Brush.linearGradient(
        if (result.passed) {
            listOf(Color(0xFF0F9F7F), Color(0xFF14B8A6), Color(0xFF2563EB))
        } else {
            listOf(Color(0xFFF59E0B), Color(0xFFF97316), Color(0xFFDB2777))
        }
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(gradient)
            .padding(22.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Icon(
                    Icons.Rounded.EmojiEvents,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(38.dp)
                )
                Spacer(Modifier.height(13.dp))
                Text(
                    if (result.passed) "Hebat, kamu tuntas!" else "Sedikit lagi, tetap semangat!",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    result.chapterTitle,
                    color = Color.White.copy(alpha = 0.82f),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "${result.correctAnswers} dari ${result.totalQuestions} jawaban benar • batas lulus $passScore",
                    color = Color.White.copy(alpha = 0.82f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(Modifier.width(14.dp))
            ProgressRing(
                progress = result.score / 100f,
                label = "nilai",
                progressColor = Color.White,
                trackColor = Color.White.copy(alpha = 0.2f)
            )
        }
    }
}

@Composable
private fun ReviewAnswerCard(index: Int, answer: com.sumberilmu.app.data.QuizAnswer) {
    val accent = if (answer.isCorrect) BrandTeal else MaterialTheme.colorScheme.error
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(1.dp, accent.copy(alpha = 0.24f)),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(Modifier.padding(17.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(accent.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        (index + 1).toString(),
                        color = accent,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    if (answer.isCorrect) "Jawaban benar" else "Perlu diperbaiki",
                    color = accent,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    if (answer.isCorrect) Icons.Rounded.CheckCircle else Icons.Rounded.Cancel,
                    contentDescription = null,
                    tint = accent
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                answer.question.prompt,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(10.dp))
            Text(
                "Jawabanmu: ${answer.question.options[answer.selectedIndex].text}",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (!answer.isCorrect) {
                Spacer(Modifier.height(4.dp))
                Text(
                    "Jawaban benar: ${answer.question.options[answer.question.correctIndex].text}",
                    color = BrandTeal,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(Modifier.height(12.dp))
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Spacer(Modifier.height(12.dp))
            Text(answer.question.explanation, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
