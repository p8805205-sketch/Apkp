package com.sumberilmu.app.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.BarChart
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Functions
import androidx.compose.material.icons.rounded.GridOn
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Numbers
import androidx.compose.material.icons.rounded.PieChart
import androidx.compose.material.icons.rounded.Straighten
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

internal val BrandIndigo = Color(0xFF4F46E5)
internal val BrandViolet = Color(0xFF7C3AED)
internal val BrandBlue = Color(0xFF2563EB)
internal val BrandCyan = Color(0xFF0891B2)
internal val BrandTeal = Color(0xFF0F9F7F)
internal val BrandGreen = Color(0xFF16A34A)
internal val BrandAmber = Color(0xFFF59E0B)
internal val BrandOrange = Color(0xFFF97316)
internal val BrandPink = Color(0xFFDB2777)

internal fun chapterAccent(number: Int): Color = when (number) {
    1 -> BrandIndigo
    2 -> BrandTeal
    3 -> BrandOrange
    4 -> BrandViolet
    5 -> BrandGreen
    6 -> BrandAmber
    7 -> BrandBlue
    8 -> BrandPink
    else -> BrandCyan
}

internal fun chapterIcon(number: Int): ImageVector = when (number) {
    1 -> Icons.Rounded.Calculate
    2 -> Icons.Rounded.Functions
    3 -> Icons.Rounded.PieChart
    4 -> Icons.Rounded.Straighten
    5 -> Icons.Rounded.GridOn
    6 -> Icons.Rounded.Explore
    7 -> Icons.Rounded.Category
    8 -> Icons.Rounded.BarChart
    else -> Icons.Rounded.Numbers
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(shape = RoundedCornerShape(28.dp)) {
            Column(
                modifier = Modifier.padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(42.dp)
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    "Konten gagal dimuat",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    message,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
internal fun ChapterCard(
    chapter: Chapter,
    progress: ChapterProgress?,
    passScore: Int,
    onClick: () -> Unit
) {
    val accent = chapterAccent(chapter.number)
    val isMastered = progress?.isMastered(passScore) == true
    val progressValue = when {
        isMastered -> 1f
        progress?.materialCompleted == true -> 0.72f
        (progress?.attempts ?: 0) > 0 -> 0.48f
        else -> 0.08f
    }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(RoundedCornerShape(17.dp))
                        .background(accent.copy(alpha = 0.14f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = chapterIcon(chapter.number),
                        contentDescription = null,
                        tint = accent,
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(Modifier.width(14.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "BAB ${chapter.number}",
                            style = MaterialTheme.typography.labelLarge,
                            color = accent
                        )
                        Spacer(Modifier.weight(1f))
                        StatusPill(
                            text = chapterStatus(progress, passScore),
                            accent = if (isMastered) BrandTeal else accent
                        )
                    }
                    Spacer(Modifier.height(5.dp))
                    Text(
                        chapter.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "${chapter.subchapters.size} topik • ${chapter.quiz.size} soal",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = "Buka Bab ${chapter.number}",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(14.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(7.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(progressValue)
                            .height(7.dp)
                            .clip(CircleShape)
                            .background(accent)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Text(
                    if ((progress?.attempts ?: 0) > 0) "Terbaik ${progress?.bestScore}" else "Mulai",
                    style = MaterialTheme.typography.labelLarge,
                    color = accent
                )
            }
        }
    }
}

private fun chapterStatus(progress: ChapterProgress?, passScore: Int): String = when {
    progress?.isMastered(passScore) == true -> "Dikuasai"
    (progress?.attempts ?: 0) > 0 -> "Berjalan"
    progress?.materialCompleted == true -> "Siap quiz"
    else -> "Baru"
}

@Composable
internal fun StatusPill(text: String, accent: Color) {
    Surface(
        color = accent.copy(alpha = 0.12f),
        contentColor = accent,
        shape = CircleShape
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
internal fun SectionTitle(
    text: String,
    supportingText: String? = null
) {
    Column {
        Text(
            text,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        if (supportingText != null) {
            Spacer(Modifier.height(3.dp))
            Text(
                supportingText,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
internal fun InfoCard(
    text: String,
    accent: Color = MaterialTheme.colorScheme.primary
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = accent.copy(alpha = 0.09f)
        ),
        border = BorderStroke(1.dp, accent.copy(alpha = 0.16f)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(accent.copy(alpha = 0.16f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = null,
                    tint = accent,
                    modifier = Modifier.size(19.dp)
                )
            }
            Spacer(Modifier.width(12.dp))
            Text(
                text,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
internal fun BulletText(text: String, accent: Color = MaterialTheme.colorScheme.primary) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp)) {
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .size(7.dp)
                .clip(CircleShape)
                .background(accent)
        )
        Spacer(Modifier.width(11.dp))
        Text(
            text,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
internal fun KeywordChip(text: String, accent: Color) {
    Surface(
        color = accent.copy(alpha = 0.1f),
        contentColor = accent,
        shape = CircleShape,
        border = BorderStroke(1.dp, accent.copy(alpha = 0.18f))
    ) {
        Text(
            text,
            modifier = Modifier.padding(horizontal = 13.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
internal fun MetricTile(
    value: String,
    label: String,
    accent: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
        shape = RoundedCornerShape(20.dp),
        tonalElevation = 1.dp,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                value,
                style = MaterialTheme.typography.titleLarge,
                color = accent,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
internal fun ProgressRing(
    progress: Float,
    label: String,
    modifier: Modifier = Modifier,
    trackColor: Color = Color.White.copy(alpha = 0.22f),
    progressColor: Color = Color.White
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 1f),
        label = "learning-progress"
    )
    Box(modifier = modifier.size(86.dp), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = { 1f },
            modifier = Modifier.fillMaxSize(),
            color = trackColor,
            strokeWidth = 8.dp,
            strokeCap = StrokeCap.Round
        )
        CircularProgressIndicator(
            progress = { animatedProgress },
            modifier = Modifier.fillMaxSize(),
            color = progressColor,
            strokeWidth = 8.dp,
            strokeCap = StrokeCap.Round
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "${(animatedProgress * 100).toInt()}%",
                color = progressColor,
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                label,
                color = progressColor.copy(alpha = 0.82f),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
internal fun AchievementCard(text: String, accent: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        Brush.linearGradient(
                            listOf(accent, accent.copy(alpha = 0.72f))
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(Modifier.width(14.dp))
            Text(
                text,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
