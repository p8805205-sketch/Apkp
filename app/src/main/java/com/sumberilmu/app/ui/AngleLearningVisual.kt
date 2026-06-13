package com.sumberilmu.app.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

@Composable
fun AngleLearningShowcase(accent: Color) {
    val choices = listOf(0, 30, 90, 125, 180, 235, 360)
    var selectedDegree by rememberSaveable { mutableStateOf(90) }
    val type = angleType(selectedDegree)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(26.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(accent.copy(alpha = 0.14f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "∠",
                        color = accent,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Laboratorium Sudut",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "Pilih ukuran untuk melihat bentuk dan jenisnya",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = accent.copy(alpha = 0.07f),
                shape = RoundedCornerShape(22.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(14.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(230.dp)
                            .semantics {
                                contentDescription = "Visual sudut $selectedDegree derajat, jenis $type"
                            }
                    ) {
                        val center = Offset(size.width / 2f, size.height / 2f)
                        val radius = min(size.width, size.height) * 0.37f
                        val guideRadius = radius * 1.08f
                        val arcRadius = radius * 0.58f
                        val stroke = 7.dp.toPx()

                        drawCircle(
                            color = accent.copy(alpha = 0.10f),
                            radius = guideRadius,
                            center = center,
                            style = Stroke(width = 2.dp.toPx())
                        )

                        for (degree in 0 until 360 step 30) {
                            val radians = Math.toRadians(degree.toDouble())
                            val outer = Offset(
                                x = center.x + guideRadius * cos(radians).toFloat(),
                                y = center.y + guideRadius * sin(radians).toFloat()
                            )
                            val inner = Offset(
                                x = center.x + (guideRadius - 10.dp.toPx()) * cos(radians).toFloat(),
                                y = center.y + (guideRadius - 10.dp.toPx()) * sin(radians).toFloat()
                            )
                            drawLine(
                                color = accent.copy(alpha = 0.28f),
                                start = inner,
                                end = outer,
                                strokeWidth = 2.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }

                        val baseEnd = Offset(center.x + radius, center.y)
                        val endRadians = Math.toRadians(-selectedDegree.toDouble())
                        val secondEnd = Offset(
                            x = center.x + radius * cos(endRadians).toFloat(),
                            y = center.y + radius * sin(endRadians).toFloat()
                        )

                        drawLine(
                            color = accent,
                            start = center,
                            end = baseEnd,
                            strokeWidth = stroke,
                            cap = StrokeCap.Round
                        )
                        drawLine(
                            color = accent,
                            start = center,
                            end = secondEnd,
                            strokeWidth = stroke,
                            cap = StrokeCap.Round
                        )

                        if (selectedDegree > 0) {
                            drawArc(
                                color = accent.copy(alpha = 0.72f),
                                startAngle = 0f,
                                sweepAngle = -selectedDegree.toFloat(),
                                useCenter = false,
                                topLeft = Offset(center.x - arcRadius, center.y - arcRadius),
                                size = Size(arcRadius * 2f, arcRadius * 2f),
                                style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                            )
                        }

                        drawCircle(
                            color = accent,
                            radius = 8.dp.toPx(),
                            center = center
                        )
                    }

                    Text(
                        "$selectedDegree°",
                        color = accent,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        type,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        angleRangeDescription(selectedDegree),
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(Modifier.height(14.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 2.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(choices) { degree ->
                    FilterChip(
                        selected = selectedDegree == degree,
                        onClick = { selectedDegree = degree },
                        label = { Text("$degree°") }
                    )
                }
            }
        }
    }
}

private fun angleType(degree: Int): String = when {
    degree == 0 -> "Sudut nol"
    degree in 1..89 -> "Sudut lancip"
    degree == 90 -> "Sudut siku-siku"
    degree in 91..179 -> "Sudut tumpul"
    degree == 180 -> "Sudut lurus"
    degree in 181..359 -> "Sudut refleks"
    else -> "Sudut penuh"
}

private fun angleRangeDescription(degree: Int): String = when {
    degree == 0 -> "Kedua kaki sudut berimpit."
    degree in 1..89 -> "Lebih dari 0° dan kurang dari 90°."
    degree == 90 -> "Tepat seperempat putaran."
    degree in 91..179 -> "Lebih dari 90° dan kurang dari 180°."
    degree == 180 -> "Kedua kaki berlawanan arah."
    degree in 181..359 -> "Lebih dari 180° dan kurang dari 360°."
    else -> "Satu putaran lengkap."
}
