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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

@Composable
internal fun CollapsibleLabChapterScreen(
    chapter: Chapter,
    chapterProgress: ChapterProgress?,
    passScore: Int,
    contentPadding: PaddingValues,
    labTitle: String,
    collapsedSubtitle: String,
    expandedSubtitle: String,
    labIcon: String,
    onMarkCompleted: () -> Unit,
    onStartQuiz: () -> Unit,
    labContent: @Composable (Color) -> Unit
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    val accent = chapterAccent(chapter.number)
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val maxLabHeight = (screenHeight * 0.50f).coerceIn(260.dp, 520.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 10.dp)
                .animateContentSize()
                .semantics {
                    role = Role.Button
                    stateDescription = if (expanded) "Terbuka" else "Tertutup"
                }
                .clickable { expanded = !expanded },
            colors = CardDefaults.cardColors(
                containerColor = accent.copy(alpha = 0.08f)
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 17.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = labIcon,
                    color = accent,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = labTitle,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = if (expanded) expandedSubtitle else collapsedSubtitle,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
                    contentDescription = if (expanded) "Tutup $labTitle" else "Buka $labTitle",
                    tint = accent
                )
            }
        }

        AnimatedVisibility(visible = expanded) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = maxLabHeight)
                    .verticalScroll(rememberScrollState())
                    .padding(start = 18.dp, end = 18.dp, bottom = 10.dp)
            ) {
                labContent(accent)
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
