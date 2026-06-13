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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.Flag
import androidx.compose.material.icons.rounded.Lightbulb
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress
import com.sumberilmu.app.data.Subchapter

@Composable
fun ChapterScreen(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    contentPadding: PaddingValues,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit
) {
    val accent = chapterAccent(chapter.number)

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ChapterHero(
                chapter = chapter,
                chapterProgress = chapterProgress,
                passScore = passScore,
                accent = accent
            )
        }

        item {
            SectionTitle(
                text = "Tujuan pembelajaran",
                supportingText = "Kemampuan yang akan kamu kuasai setelah menyelesaikan bab ini"
            )
        }

        item {
            InfoCard(chapter.objective, accent)
        }

        item {
            SectionTitle("Kata kunci")
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(end = 18.dp)
            ) {
                items(chapter.keywords) { keyword ->
                    KeywordChip(keyword, accent)
                }
            }
        }

        item {
            SectionTitle(
                text = "Ringkasan konsep",
                supportingText = "Baca gambaran besarnya sebelum masuk ke setiap topik"
            )
        }

        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                shape = RoundedCornerShape(24.dp)
            ) {
                Column(Modifier.padding(18.dp)) {
                    chapter.summary.forEach { text ->
                        BulletText(text, accent)
                    }
                }
            }
        }

        item {
            SectionTitle(
                text = "Materi dan contoh",
                supportingText = "Ketuk setiap topik untuk membuka penjelasan"
            )
        }

        itemsIndexed(chapter.subchapters, key = { index, item -> "$index-${item.title}" }) { index, subchapter ->
            ExpandableSubchapterCard(
                chapterNumber = chapter.number,
                index = index,
                subchapter = subchapter,
                accent = accent
            )
        }

        item {
            ChapterActionCard(
                chapterProgress = chapterProgress,
                passScore = passScore,
                accent = accent,
                onMarkCompleted = onMarkCompleted,
                onStartQuiz = onStartQuiz
            )
        }
    }
}

@Composable
private fun ChapterHero(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    accent: Color
) {
    val gradient = Brush.linearGradient(
        listOf(accent, accent.copy(alpha = 0.74f), BrandViolet.copy(alpha = 0.88f))
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(gradient)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp)
                .size(94.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.09f))
        )
        Column(modifier = Modifier.fillMaxWidth().padding(22.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(58.dp)
                        .clip(RoundedCornerShape(19.dp))
                        .background(Color.White.copy(alpha = 0.18f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        chapterIcon(chapter.number),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(31.dp)
                    )
                }
                Spacer(Modifier.width(13.dp))
                Column {
                    Text(
                        "BAB ${chapter.number}",
                        color = Color.White.copy(alpha = 0.84f),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        "Halaman ${chapter.sourcePageStart}-${chapter.sourcePageEnd}",
                        color = Color.White.copy(alpha = 0.74f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(Modifier.weight(1f))
                StatusPill(
                    text = when {
                        chapterProgress?.isMastered(passScore) == true -> "Dikuasai"
                        chapterProgress?.materialCompleted == true -> "Materi selesai"
                        else -> "Pelajari"
                    },
                    accent = Color.White
                )
            }
            Spacer(Modifier.height(22.dp))
            Text(
                chapter.title,
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "${chapter.subchapters.size} topik terstruktur • ${chapter.quiz.size} soal quiz",
                color = Color.White.copy(alpha = 0.82f),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
private fun ExpandableSubchapterCard(
    chapterNumber: Int,
    index: Int,
    subchapter: Subchapter,
    accent: Color
) {
    var expanded by rememberSaveable(chapterNumber, index) {
        mutableStateOf(index == 0)
    }

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(Modifier.padding(17.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(accent.copy(alpha = 0.12f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        (index + 1).toString(),
                        color = accent,
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        subchapter.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        if (expanded) "Ketuk untuk menutup" else "Ketuk untuk membaca",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        if (expanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
                        contentDescription = if (expanded) "Tutup topik" else "Buka topik"
                    )
                }
            }

            if (expanded) {
                Spacer(Modifier.height(14.dp))
                HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                Spacer(Modifier.height(14.dp))
                subchapter.explanation.forEach { explanation ->
                    BulletText(explanation, accent)
                }
                Spacer(Modifier.height(14.dp))
                ExamplePanel(subchapter, accent)
            }
        }
    }
}

@Composable
private fun ExamplePanel(subchapter: Subchapter, accent: Color) {
    Surface(
        color = accent.copy(alpha = 0.08f),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, accent.copy(alpha = 0.17f))
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Rounded.Lightbulb,
                    contentDescription = null,
                    tint = accent
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    "Contoh terarah",
                    color = accent,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(Modifier.height(10.dp))
            Text(
                subchapter.example.question,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(12.dp))
            subchapter.example.steps.forEachIndexed { stepIndex, step ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .size(26.dp)
                            .clip(CircleShape)
                            .background(accent),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            (stepIndex + 1).toString(),
                            color = Color.White,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                    Spacer(Modifier.width(10.dp))
                    Text(step, modifier = Modifier.weight(1f))
                }
            }
            Spacer(Modifier.height(12.dp))
            Surface(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(13.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Rounded.CheckCircle,
                        contentDescription = null,
                        tint = BrandTeal
                    )
                    Spacer(Modifier.width(9.dp))
                    Text(
                        "Jawaban: ${subchapter.example.answer}",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
private fun ChapterActionCard(
    chapterProgress: ChapterProgress?,
    passScore: Int,
    accent: Color,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = accent.copy(alpha = 0.09f)
        ),
        border = BorderStroke(1.dp, accent.copy(alpha = 0.18f)),
        shape = RoundedCornerShape(26.dp)
    ) {
        Column(Modifier.fillMaxWidth().padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(accent),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Rounded.Flag,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Siap menguji pemahaman?",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Batas kelulusan $passScore • 25 soal",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            if ((chapterProgress?.attempts ?: 0) > 0) {
                Spacer(Modifier.height(12.dp))
                Text(
                    "Nilai terakhir ${chapterProgress?.lastScore} • nilai terbaik ${chapterProgress?.bestScore} • ${chapterProgress?.attempts} percobaan",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(Modifier.height(16.dp))
            if (chapterProgress?.materialCompleted != true) {
                OutlinedButton(
                    onClick = onMarkCompleted,
                    modifier = Modifier.fillMaxWidth().height(52.dp),
                    shape = RoundedCornerShape(17.dp)
                ) {
                    Icon(Icons.Rounded.MenuBook, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Tandai materi selesai")
                }
                Spacer(Modifier.height(10.dp))
            }
            Button(
                onClick = onStartQuiz,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(17.dp)
            ) {
                Icon(Icons.Rounded.Quiz, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Mulai quiz 25 soal")
            }
        }
    }
}
