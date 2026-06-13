package com.sumberilmu.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.Chapter
import com.sumberilmu.app.data.ChapterProgress

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Konten gagal dimuat", style = MaterialTheme.typography.headlineSmall)
            Spacer(Modifier.height(8.dp))
            Text(message, textAlign = TextAlign.Center)
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
    ElevatedCard(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Bab ${chapter.number}", style = MaterialTheme.typography.labelLarge)
            Text(
                chapter.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                when {
                    progress?.isMastered(passScore) == true -> "Dikuasai • Nilai terbaik ${progress.bestScore}"
                    (progress?.attempts ?: 0) > 0 -> "Nilai terbaik ${progress?.bestScore}"
                    progress?.materialCompleted == true -> "Materi selesai • Quiz belum tuntas"
                    else -> "Belum dipelajari"
                },
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
internal fun SectionTitle(text: String) {
    Text(text, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
}

@Composable
internal fun InfoCard(text: String) {
    Card(shape = RoundedCornerShape(16.dp)) {
        Text(text, modifier = Modifier.padding(16.dp))
    }
}

@Composable
internal fun BulletText(text: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)) {
        Text("•", fontWeight = FontWeight.Bold)
        Spacer(Modifier.width(8.dp))
        Text(text, modifier = Modifier.weight(1f))
    }
}
