package com.sumberilmu.app.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

@Composable
fun ShapeEnhancedChapterScreen(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    contentPadding: PaddingValues,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit
) {
    var labExpanded by rememberSaveable { mutableStateOf(true) }
    val accent = chapterAccent(chapter.number)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 10.dp)
                .animateContentSize(),
            colors = CardDefaults.cardColors(
                containerColor = accent.copy(alpha = 0.08f)
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { labExpanded = !labExpanded }
                        .padding(horizontal = 17.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "◇",
                        color = accent,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(Modifier.size(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "Laboratorium Pembanding",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            if (labExpanded) "Ketuk untuk mengecilkan" else "Ketuk untuk membandingkan dua bangun",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Icon(
                        imageVector = if (labExpanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
                        contentDescription = if (labExpanded) "Tutup laboratorium" else "Buka laboratorium",
                        tint = accent
                    )
                }

                AnimatedVisibility(visible = labExpanded) {
                    Box(modifier = Modifier.padding(start = 12.dp, end = 12.dp, bottom = 12.dp)) {
                        ShapeComparisonShowcase(accent = accent)
                    }
                }
            }
        }

        Box(modifier = Modifier.weight(1f)) {
            ChapterScreen(
                chapter = chapter,
                chapterProgress = chapterProgress,
                passScore = passScore,
                contentPadding = PaddingValues(0.dp),
                onMarkCompleted = onMarkCompleted,
                onStartQuiz = onStartQuiz
            )
        }
    }
}
