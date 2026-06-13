package com.sumberilmu.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

@Composable
fun ChapterScreen(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    contentPadding: PaddingValues,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Text(
                "Bab ${chapter.number}: ${chapter.title}",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text("Referensi halaman ${chapter.sourcePageStart}–${chapter.sourcePageEnd}")
        }
        item {
            SectionTitle("Tujuan Pembelajaran")
            InfoCard(chapter.objective)
        }
        item {
            SectionTitle("Kata Kunci")
            Text(chapter.keywords.joinToString(" • "))
        }
        item { SectionTitle("Ringkasan") }
        items(chapter.summary) { text -> BulletText(text) }

        items(chapter.subchapters) { subchapter ->
            ElevatedCard(shape = RoundedCornerShape(18.dp)) {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        subchapter.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(8.dp))
                    subchapter.explanation.forEach { BulletText(it) }
                    Spacer(Modifier.height(8.dp))
                    Text("Contoh soal", fontWeight = FontWeight.Bold)
                    Text(subchapter.example.question)
                    subchapter.example.steps.forEachIndexed { index, step ->
                        Text("${index + 1}. $step")
                    }
                    Text("Jawaban: ${subchapter.example.answer}", fontWeight = FontWeight.Bold)
                }
            }
        }

        item {
            if (chapterProgress?.materialCompleted != true) {
                OutlinedButton(onClick = onMarkCompleted, modifier = Modifier.fillMaxWidth()) {
                    Text("Tandai Materi Selesai")
                }
            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = onStartQuiz, modifier = Modifier.fillMaxWidth()) {
                Text("Mulai Quiz 25 Soal")
            }
            if ((chapterProgress?.attempts ?: 0) > 0) {
                Spacer(Modifier.height(8.dp))
                Text(
                    "Nilai terakhir ${chapterProgress?.lastScore} • terbaik ${chapterProgress?.bestScore} • batas lulus $passScore",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
