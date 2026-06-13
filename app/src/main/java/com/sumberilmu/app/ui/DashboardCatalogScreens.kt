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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.ChapterProgress
import com.sumberilmu.app.data.LearningCatalog

@Composable
fun DashboardScreen(
    catalog: LearningCatalog,
    progress: Map<String, ChapterProgress>,
    contentPadding: PaddingValues,
    onOpenCatalog: () -> Unit,
    onOpenChapter: (String) -> Unit
) {
    val mastered = catalog.chapters.count {
        progress[it.id]?.isMastered(catalog.passScore) == true
    }
    val nextChapter = catalog.chapters.firstOrNull {
        progress[it.id]?.isMastered(catalog.passScore) != true
    } ?: catalog.chapters.first()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ElevatedCard(
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text("${catalog.level} • ${catalog.grade}")
                    Text(
                        catalog.subject,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text("${catalog.curriculum} • Semester ${catalog.semester}")
                    Spacer(Modifier.height(16.dp))
                    Text("$mastered dari ${catalog.chapters.size} bab dikuasai")
                    Spacer(Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { mastered.toFloat() / catalog.chapters.size.coerceAtLeast(1) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = onOpenCatalog, modifier = Modifier.fillMaxWidth()) {
                        Text("Buka Katalog Materi")
                    }
                }
            }
        }
        item { SectionTitle("Rekomendasi berikutnya") }
        item {
            ChapterCard(
                chapter = nextChapter,
                progress = progress[nextChapter.id],
                passScore = catalog.passScore,
                onClick = { onOpenChapter(nextChapter.id) }
            )
        }
        item { SectionTitle("Pencapaian") }
        item {
            InfoCard(
                when {
                    mastered == catalog.chapters.size -> "🏆 Penjelajah Matematika: seluruh bab telah dikuasai."
                    progress.values.any { it.bestScore >= 90 } -> "⭐ Nilai Gemilang: pernah memperoleh nilai minimal 90."
                    progress.values.any { it.materialCompleted } -> "✅ Langkah Pertama: satu materi telah diselesaikan."
                    else -> "Mulai bab pertama untuk membuka badge pertamamu."
                }
            )
        }
    }
}

@Composable
fun CatalogScreen(
    catalog: LearningCatalog,
    progress: Map<String, ChapterProgress>,
    contentPadding: PaddingValues,
    onOpenChapter: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                "${catalog.level} → ${catalog.grade} → ${catalog.subject}",
                style = MaterialTheme.typography.titleMedium
            )
        }
        items(catalog.chapters, key = { it.id }) { chapter ->
            ChapterCard(
                chapter = chapter,
                progress = progress[chapter.id],
                passScore = catalog.passScore,
                onClick = { onOpenChapter(chapter.id) }
            )
        }
    }
}
