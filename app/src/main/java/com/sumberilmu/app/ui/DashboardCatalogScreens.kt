package com.sumberilmu.app.ui

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.EmojiEvents
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress
import com.sumberilmu.app.data.LearningCatalog

private enum class CatalogFilter(val label: String) {
    ALL("Semua"),
    IN_PROGRESS("Berjalan"),
    MASTERED("Dikuasai")
}

@Composable
fun DashboardScreen(
    catalog: LearningCatalog,
    progress: Map<String, ChapterProgress>,
    contentPadding: PaddingValues,
    onOpenCatalog: () -> Unit,
    onOpenChapter: (String) -> Unit
) {
    val completed = catalog.chapters.count { progress[it.id]?.materialCompleted == true }
    val mastered = catalog.chapters.count {
        progress[it.id]?.isMastered(catalog.passScore) == true
    }
    val attempted = progress.values.filter { it.attempts > 0 }
    val averageBest = if (attempted.isEmpty()) 0 else attempted.map { it.bestScore }.average().toInt()
    val nextChapter = catalog.chapters.firstOrNull {
        progress[it.id]?.isMastered(catalog.passScore) != true
    } ?: catalog.chapters.first()
    val totalProgress = if (catalog.chapters.isEmpty()) 0f else {
        (mastered + (completed - mastered).coerceAtLeast(0) * 0.55f) / catalog.chapters.size
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            DashboardHero(
                catalog = catalog,
                progress = totalProgress,
                mastered = mastered,
                onOpenCatalog = onOpenCatalog
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                MetricTile(
                    value = "$completed/${catalog.chapters.size}",
                    label = "Materi selesai",
                    accent = BrandIndigo,
                    modifier = Modifier.weight(1f)
                )
                MetricTile(
                    value = mastered.toString(),
                    label = "Bab dikuasai",
                    accent = BrandTeal,
                    modifier = Modifier.weight(1f)
                )
                MetricTile(
                    value = if (attempted.isEmpty()) "-" else averageBest.toString(),
                    label = "Rata-rata",
                    accent = BrandOrange,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            SectionTitle(
                text = "Lanjutkan belajar",
                supportingText = "Rekomendasi berdasarkan progres terakhir"
            )
        }

        item {
            ContinueLearningCard(
                chapter = nextChapter,
                progress = progress[nextChapter.id],
                passScore = catalog.passScore,
                onClick = { onOpenChapter(nextChapter.id) }
            )
        }

        item {
            SectionTitle(
                text = "Perjalanan belajarmu",
                supportingText = "Selesaikan materi dan capai nilai minimal ${catalog.passScore}"
            )
        }

        items(catalog.chapters.take(3), key = { "dashboard-${it.id}" }) { chapter ->
            ChapterCard(
                chapter = chapter,
                progress = progress[chapter.id],
                passScore = catalog.passScore,
                onClick = { onOpenChapter(chapter.id) }
            )
        }

        item {
            Button(
                onClick = onOpenCatalog,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(18.dp)
            ) {
                Icon(Icons.Rounded.AutoStories, contentDescription = null)
                Spacer(Modifier.size(8.dp))
                Text("Lihat semua bab")
            }
        }

        item {
            SectionTitle("Pencapaian terbaru")
        }

        item {
            AchievementCard(
                text = when {
                    mastered == catalog.chapters.size -> "Penjelajah Matematika: seluruh bab telah kamu kuasai."
                    progress.values.any { it.bestScore >= 90 } -> "Nilai Gemilang: kamu pernah meraih nilai minimal 90."
                    progress.values.any { it.materialCompleted } -> "Langkah Pertama: satu materi sudah berhasil diselesaikan."
                    else -> "Mulai bab pertama untuk membuka pencapaian pertamamu."
                },
                accent = if (mastered > 0) BrandTeal else BrandAmber
            )
        }
    }
}

@Composable
private fun DashboardHero(
    catalog: LearningCatalog,
    progress: Float,
    mastered: Int,
    onOpenCatalog: () -> Unit
) {
    val gradient = Brush.linearGradient(
        listOf(Color(0xFF4F46E5), Color(0xFF7C3AED), Color(0xFF2563EB))
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
                .padding(top = 18.dp, end = 18.dp)
                .size(92.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.08f))
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 110.dp, bottom = 12.dp)
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.07f))
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(13.dp))
                            .background(Color.White.copy(alpha = 0.17f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Rounded.School,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                    Spacer(Modifier.size(10.dp))
                    Text(
                        "${catalog.level} • ${catalog.grade}",
                        color = Color.White.copy(alpha = 0.86f),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Spacer(Modifier.height(18.dp))
                Text(
                    "Belajar ${catalog.subject}\nlebih seru hari ini",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "$mastered bab dikuasai • ${catalog.curriculum}",
                    color = Color.White.copy(alpha = 0.82f),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.height(18.dp))
                Button(
                    onClick = onOpenCatalog,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = BrandIndigo
                    ),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Icon(Icons.Rounded.PlayArrow, contentDescription = null)
                    Spacer(Modifier.size(6.dp))
                    Text("Mulai belajar")
                }
            }
            Spacer(Modifier.size(16.dp))
            ProgressRing(progress = progress, label = "progres")
        }
    }
}

@Composable
private fun ContinueLearningCard(
    chapter: Chapter,
    progress: ChapterProgress?,
    passScore: Int,
    onClick: () -> Unit
) {
    val accent = chapterAccent(chapter.number)
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = accent.copy(alpha = 0.10f)
        ),
        shape = RoundedCornerShape(26.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(accent),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    chapterIcon(chapter.number),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(Modifier.size(15.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "LANJUTKAN BAB ${chapter.number}",
                    style = MaterialTheme.typography.labelLarge,
                    color = accent
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    chapter.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    when {
                        progress?.isMastered(passScore) == true -> "Sudah dikuasai, ulangi untuk mempertajam kemampuan"
                        (progress?.attempts ?: 0) > 0 -> "Nilai terbaik ${progress?.bestScore} • coba tingkatkan lagi"
                        progress?.materialCompleted == true -> "Materi selesai • quiz sudah menunggu"
                        else -> "${chapter.subchapters.size} topik dan ${chapter.quiz.size} soal"
                    },
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Icon(
                Icons.Rounded.PlayArrow,
                contentDescription = "Lanjutkan Bab ${chapter.number}",
                tint = accent,
                modifier = Modifier.size(30.dp)
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
    var selectedFilter by rememberSaveable { mutableStateOf(CatalogFilter.ALL) }
    val completed = catalog.chapters.count { progress[it.id]?.materialCompleted == true }
    val mastered = catalog.chapters.count { progress[it.id]?.isMastered(catalog.passScore) == true }
    val filteredChapters = catalog.chapters.filter { chapter ->
        val chapterProgress = progress[chapter.id]
        when (selectedFilter) {
            CatalogFilter.ALL -> true
            CatalogFilter.IN_PROGRESS -> chapterProgress?.materialCompleted == true ||
                (chapterProgress?.attempts ?: 0) > 0
            CatalogFilter.MASTERED -> chapterProgress?.isMastered(catalog.passScore) == true
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            CatalogHeader(
                catalog = catalog,
                completed = completed,
                mastered = mastered
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CatalogFilter.entries.forEach { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter.label) }
                    )
                }
            }
        }

        if (filteredChapters.isEmpty()) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(28.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            Icons.Rounded.EmojiEvents,
                            contentDescription = null,
                            tint = BrandAmber,
                            modifier = Modifier.size(42.dp)
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Belum ada bab pada kategori ini",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            "Selesaikan materi dan quiz untuk membuka status baru.",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        } else {
            items(filteredChapters, key = { it.id }) { chapter ->
                ChapterCard(
                    chapter = chapter,
                    progress = progress[chapter.id],
                    passScore = catalog.passScore,
                    onClick = { onOpenChapter(chapter.id) }
                )
            }
        }
    }
}

@Composable
private fun CatalogHeader(
    catalog: LearningCatalog,
    completed: Int,
    mastered: Int
) {
    val gradient = Brush.linearGradient(
        listOf(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.tertiaryContainer
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(28.dp))
            .background(gradient)
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "KATALOG BELAJAR",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "${catalog.subject} ${catalog.grade}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.height(7.dp))
                Text(
                    "${catalog.chapters.size} bab • $completed selesai • $mastered dikuasai",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Box(
                modifier = Modifier
                    .size(62.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.72f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Rounded.AutoStories,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
