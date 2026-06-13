package com.sumberilmu.app.ui

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.ChapterProgress
import com.sumberilmu.app.data.LearningCatalog

private enum class SearchCatalogFilter(val label: String) {
    ALL("Semua"),
    NEW("Belum mulai"),
    ACTIVE("Berjalan"),
    MASTERED("Dikuasai")
}

private data class PathStep(
    val label: String,
    val value: String,
    val icon: ImageVector,
    val color: Color
)

@Composable
internal fun LearningPathStrip(
    catalog: LearningCatalog,
    selectedChapterNumber: Int? = null
) {
    val steps = listOf(
        PathStep("Jenjang", catalog.level, Icons.Rounded.School, BrandTeal),
        PathStep("Kelas", catalog.grade, Icons.Rounded.Stars, BrandBlue),
        PathStep("Mapel", catalog.subject, Icons.Rounded.Calculate, BrandOrange),
        PathStep("Periode", "Semester ${catalog.semester}", Icons.Rounded.CalendarMonth, BrandViolet),
        PathStep("Bab", selectedChapterNumber?.let { "Bab $it" } ?: "Pilih bab", Icons.Rounded.MenuBook, BrandPink)
    )

    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 2.dp,
        shadowElevation = 2.dp
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 9.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(steps) { step ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = step.color.copy(alpha = 0.11f),
                        contentColor = step.color,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, step.color.copy(alpha = 0.16f))
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 11.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(29.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(step.color),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = step.icon,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(17.dp)
                                )
                            }
                            Spacer(Modifier.width(8.dp))
                            Column {
                                Text(
                                    step.label,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    step.value,
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ReferenceInspiredCatalogScreen(
    catalog: LearningCatalog,
    progress: Map<String, ChapterProgress>,
    contentPadding: PaddingValues,
    onOpenChapter: (String) -> Unit
) {
    var query by rememberSaveable { mutableStateOf("") }
    var selectedFilter by rememberSaveable { mutableStateOf(SearchCatalogFilter.ALL) }

    val normalizedQuery = query.trim().lowercase()
    val visibleChapters = catalog.chapters.filter { chapter ->
        val chapterProgress = progress[chapter.id]
        val matchesQuery = normalizedQuery.isBlank() ||
            chapter.title.lowercase().contains(normalizedQuery) ||
            chapter.keywords.any { it.lowercase().contains(normalizedQuery) } ||
            chapter.subchapters.any { it.title.lowercase().contains(normalizedQuery) }
        val matchesFilter = when (selectedFilter) {
            SearchCatalogFilter.ALL -> true
            SearchCatalogFilter.NEW -> chapterProgress?.materialCompleted != true &&
                (chapterProgress?.attempts ?: 0) == 0
            SearchCatalogFilter.ACTIVE -> chapterProgress?.materialCompleted == true ||
                (chapterProgress?.attempts ?: 0) > 0
            SearchCatalogFilter.MASTERED -> chapterProgress?.isMastered(catalog.passScore) == true
        }
        matchesQuery && matchesFilter
    }

    val completed = catalog.chapters.count { progress[it.id]?.materialCompleted == true }
    val mastered = catalog.chapters.count { progress[it.id]?.isMastered(catalog.passScore) == true }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(contentPadding),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            ReferenceCatalogHero(
                subject = catalog.subject,
                grade = catalog.grade,
                completed = completed,
                mastered = mastered,
                total = catalog.chapters.size
            )
        }

        item {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(18.dp),
                leadingIcon = {
                    Icon(Icons.Rounded.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (query.isNotBlank()) {
                        IconButton(onClick = { query = "" }) {
                            Icon(Icons.Rounded.Clear, contentDescription = "Hapus pencarian")
                        }
                    }
                },
                placeholder = { Text("Cari bab, subbab, atau topik...") }
            )
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(end = 18.dp)
            ) {
                items(SearchCatalogFilter.entries) { filter ->
                    FilterChip(
                        selected = selectedFilter == filter,
                        onClick = { selectedFilter = filter },
                        label = { Text(filter.label) }
                    )
                }
            }
        }

        item {
            SectionTitle(
                text = "Daftar bab",
                supportingText = "${visibleChapters.size} bab sesuai pencarian dan filter"
            )
        }

        if (visibleChapters.isEmpty()) {
            item {
                EmptyCatalogSearch(query = query)
            }
        } else {
            items(visibleChapters, key = { it.id }) { chapter ->
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
private fun ReferenceCatalogHero(
    subject: String,
    grade: String,
    completed: Int,
    mastered: Int,
    total: Int
) {
    val gradient = Brush.linearGradient(
        listOf(Color(0xFFEEF2FF), Color(0xFFE0F2FE), Color(0xFFF5F3FF))
    )
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(28.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradient)
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "BELAJAR TERSTRUKTUR",
                    style = MaterialTheme.typography.labelLarge,
                    color = BrandIndigo
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    "$subject • $grade",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF172554)
                )
                Spacer(Modifier.height(7.dp))
                Text(
                    "$completed/$total materi selesai • $mastered bab dikuasai",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF475569)
                )
            }
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(23.dp))
                    .background(
                        Brush.linearGradient(listOf(BrandIndigo, BrandViolet))
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Rounded.AutoStories,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(38.dp)
                )
            }
        }
    }
}

@Composable
private fun EmptyCatalogSearch(query: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(BrandIndigo.copy(alpha = 0.11f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = null,
                    tint = BrandIndigo,
                    modifier = Modifier.size(29.dp)
                )
            }
            Spacer(Modifier.height(12.dp))
            Text(
                "Topik belum ditemukan",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(5.dp))
            Text(
                if (query.isBlank()) {
                    "Ubah filter untuk melihat bab lainnya."
                } else {
                    "Coba kata kunci yang lebih singkat atau berbeda."
                },
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
