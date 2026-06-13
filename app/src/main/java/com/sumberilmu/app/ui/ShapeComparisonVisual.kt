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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

private enum class LearningShape(
    val label: String,
    val sides: Int,
    val equalSides: String,
    val parallelPairs: Int,
    val rightAngles: Int,
    val symmetryAxes: Int,
    val diagonalProperty: String
) {
    SQUARE(
        "Persegi", 4, "4 sisi", 2, 4, 4,
        "Sama panjang, tegak lurus, saling membagi dua"
    ),
    RECTANGLE(
        "Persegi panjang", 4, "2 pasang", 2, 4, 2,
        "Sama panjang dan saling membagi dua"
    ),
    PARALLELOGRAM(
        "Jajargenjang", 4, "2 pasang berhadapan", 2, 0, 0,
        "Saling membagi dua"
    ),
    RHOMBUS(
        "Belah ketupat", 4, "4 sisi", 2, 0, 2,
        "Tegak lurus dan saling membagi dua"
    ),
    KITE(
        "Layang-layang", 4, "2 pasang berdekatan", 0, 0, 1,
        "Tegak lurus; satu membagi diagonal lain"
    ),
    TRAPEZOID(
        "Trapesium", 4, "Bergantung jenis", 1, 0, 0,
        "Tidak memiliki sifat umum khusus"
    ),
    EQUILATERAL_TRIANGLE(
        "Segitiga sama sisi", 3, "3 sisi", 0, 0, 3,
        "Tidak memiliki diagonal"
    ),
    ISOSCELES_TRIANGLE(
        "Segitiga sama kaki", 3, "2 sisi", 0, 0, 1,
        "Tidak memiliki diagonal"
    )
}

@Composable
fun ShapeComparisonShowcase(accent: Color) {
    var firstName by rememberSaveable { mutableStateOf(LearningShape.SQUARE.name) }
    var secondName by rememberSaveable { mutableStateOf(LearningShape.RECTANGLE.name) }
    val first = LearningShape.valueOf(firstName)
    val second = LearningShape.valueOf(secondName)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(26.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(accent.copy(alpha = 0.14f), RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "◇",
                        color = accent,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Laboratorium Pembanding",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "Pilih dua bangun dan telusuri cirinya",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            ShapeSelector(
                title = "Bangun pertama",
                selected = first,
                accent = accent,
                onSelect = { firstName = it.name }
            )
            Spacer(Modifier.height(10.dp))
            ShapeSelector(
                title = "Bangun kedua",
                selected = second,
                accent = BrandTeal,
                onSelect = { secondName = it.name }
            )
            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                ShapeDiagramCard(
                    shape = first,
                    accent = accent,
                    modifier = Modifier.weight(1f)
                )
                ShapeDiagramCard(
                    shape = second,
                    accent = BrandTeal,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(16.dp))
            Text(
                "Tabel perbandingan",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(9.dp))

            ComparisonHeader(first.label, second.label, accent)
            ComparisonRow("Jumlah sisi", first.sides.toString(), second.sides.toString())
            ComparisonRow("Sisi sama panjang", first.equalSides, second.equalSides)
            ComparisonRow("Pasang sisi sejajar", first.parallelPairs.toString(), second.parallelPairs.toString())
            ComparisonRow("Sudut siku-siku", first.rightAngles.toString(), second.rightAngles.toString())
            ComparisonRow("Sumbu simetri", first.symmetryAxes.toString(), second.symmetryAxes.toString())
            ComparisonRow("Diagonal", first.diagonalProperty, second.diagonalProperty)

            Spacer(Modifier.height(14.dp))
            SimilaritySummary(first = first, second = second, accent = accent)
        }
    }
}

@Composable
private fun ShapeSelector(
    title: String,
    selected: LearningShape,
    accent: Color,
    onSelect: (LearningShape) -> Unit
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.weight(1f))
            Text(
                selected.label,
                style = MaterialTheme.typography.labelLarge,
                color = accent,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(Modifier.height(7.dp))
        LazyRow(
            contentPadding = PaddingValues(end = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            items(LearningShape.entries) { shape ->
                FilterChip(
                    selected = selected == shape,
                    onClick = { onSelect(shape) },
                    label = { Text(shape.label) }
                )
            }
        }
    }
}

@Composable
private fun ShapeDiagramCard(
    shape: LearningShape,
    accent: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = accent.copy(alpha = 0.07f),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(145.dp)
                    .semantics {
                        contentDescription = "Diagram ${shape.label} dengan ${shape.sides} sisi"
                    }
            ) {
                val points = shapePoints(shape, size.width, size.height)
                val path = Path().apply {
                    moveTo(points.first().x, points.first().y)
                    points.drop(1).forEach { lineTo(it.x, it.y) }
                    close()
                }
                drawPath(
                    path = path,
                    color = accent.copy(alpha = 0.18f)
                )
                drawPath(
                    path = path,
                    color = accent,
                    style = Stroke(width = 5.dp.toPx(), cap = StrokeCap.Round)
                )

                if (shape.sides == 4) {
                    drawLine(
                        color = accent.copy(alpha = 0.42f),
                        start = points[0],
                        end = points[2],
                        strokeWidth = 2.dp.toPx()
                    )
                    drawLine(
                        color = accent.copy(alpha = 0.42f),
                        start = points[1],
                        end = points[3],
                        strokeWidth = 2.dp.toPx()
                    )
                }

                points.forEach { point ->
                    drawCircle(color = accent, radius = 5.dp.toPx(), center = point)
                }
            }
            Text(
                shape.label,
                style = MaterialTheme.typography.labelLarge,
                color = accent,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

private fun shapePoints(shape: LearningShape, width: Float, height: Float): List<Offset> {
    val left = width * 0.17f
    val right = width * 0.83f
    val top = height * 0.16f
    val bottom = height * 0.82f
    val middleX = width * 0.5f
    return when (shape) {
        LearningShape.SQUARE -> listOf(
            Offset(width * 0.25f, top), Offset(width * 0.75f, top),
            Offset(width * 0.75f, bottom), Offset(width * 0.25f, bottom)
        )
        LearningShape.RECTANGLE -> listOf(
            Offset(left, height * 0.25f), Offset(right, height * 0.25f),
            Offset(right, height * 0.74f), Offset(left, height * 0.74f)
        )
        LearningShape.PARALLELOGRAM -> listOf(
            Offset(width * 0.30f, top), Offset(right, top),
            Offset(width * 0.70f, bottom), Offset(left, bottom)
        )
        LearningShape.RHOMBUS -> listOf(
            Offset(middleX, top), Offset(right, height * 0.5f),
            Offset(middleX, bottom), Offset(left, height * 0.5f)
        )
        LearningShape.KITE -> listOf(
            Offset(middleX, top), Offset(right, height * 0.48f),
            Offset(middleX, bottom), Offset(width * 0.24f, height * 0.48f)
        )
        LearningShape.TRAPEZOID -> listOf(
            Offset(width * 0.34f, top), Offset(width * 0.69f, top),
            Offset(right, bottom), Offset(left, bottom)
        )
        LearningShape.EQUILATERAL_TRIANGLE -> listOf(
            Offset(middleX, top), Offset(right, bottom), Offset(left, bottom)
        )
        LearningShape.ISOSCELES_TRIANGLE -> listOf(
            Offset(middleX, top), Offset(width * 0.75f, bottom), Offset(width * 0.25f, bottom)
        )
    }
}

@Composable
private fun ComparisonHeader(first: String, second: String, accent: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(accent.copy(alpha = 0.08f), RoundedCornerShape(14.dp))
            .padding(horizontal = 10.dp, vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Ciri", modifier = Modifier.weight(0.8f), fontWeight = FontWeight.Bold)
        Text(first, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Text(second, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
private fun ComparisonRow(label: String, first: String, second: String) {
    val same = first == second
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            modifier = Modifier.weight(0.8f),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            first,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (same) FontWeight.Bold else FontWeight.Normal
        )
        Text(
            second,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (same) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun SimilaritySummary(
    first: LearningShape,
    second: LearningShape,
    accent: Color
) {
    val similarities = buildList {
        if (first.sides == second.sides) add("jumlah sisi")
        if (first.parallelPairs == second.parallelPairs) add("pasangan sisi sejajar")
        if (first.rightAngles == second.rightAngles) add("jumlah sudut siku-siku")
        if (first.symmetryAxes == second.symmetryAxes) add("jumlah sumbu simetri")
        if (first.equalSides == second.equalSides) add("pola sisi sama panjang")
    }
    Surface(
        color = if (similarities.isEmpty()) BrandAmber.copy(alpha = 0.10f) else accent.copy(alpha = 0.09f),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(34.dp)
                    .background(accent.copy(alpha = 0.16f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("=", color = accent, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.size(10.dp))
            Text(
                if (similarities.isEmpty()) {
                    "Kedua bangun berbeda pada seluruh ciri utama yang dibandingkan."
                } else {
                    "Persamaan utama: ${similarities.joinToString()}."
                },
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
