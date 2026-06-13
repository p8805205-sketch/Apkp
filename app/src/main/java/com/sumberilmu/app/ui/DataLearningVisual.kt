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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.Locale
import kotlin.math.floor
import kotlin.math.max

private enum class DataViewMode(val label: String) {
    TABLE("Tabel"),
    PICTOGRAM("Piktogram"),
    VERTICAL("Batang Vertikal"),
    HORIZONTAL("Batang Horizontal"),
    DOUBLE("Batang Ganda")
}

private data class DataSeries(
    val label: String,
    val values: List<Float>
)

private data class LearningDataset(
    val label: String,
    val categories: List<String>,
    val primary: DataSeries,
    val secondary: DataSeries? = null,
    val unit: String,
    val pictogramScale: Int? = null
)

private val learningDatasets = listOf(
    LearningDataset(
        label = "Donat",
        categories = listOf("Cokelat", "Keju", "Stroberi", "Kacang"),
        primary = DataSeries("Terjual", listOf(30f, 25f, 26f, 10f)),
        unit = "kue",
        pictogramScale = 5
    ),
    LearningDataset(
        label = "Medali",
        categories = listOf("2013", "2015", "2017", "2019", "2021"),
        primary = DataSeries("Emas", listOf(65f, 47f, 38f, 72f, 69f)),
        unit = "medali",
        pictogramScale = 10
    ),
    LearningDataset(
        label = "Perpustakaan",
        categories = listOf("Sen", "Sel", "Rab", "Kam", "Jum", "Sab"),
        primary = DataSeries("Pengunjung", listOf(42f, 60f, 50f, 36f, 24f, 48f)),
        unit = "orang",
        pictogramScale = 6
    ),
    LearningDataset(
        label = "Internet",
        categories = listOf("13–17", "18–24", "25–34", "35–44", "45–54", "55–64", "65+"),
        primary = DataSeries("Laki-laki", listOf(5.7f, 15.9f, 19.3f, 7.4f, 3.2f, 1.0f, 1.5f)),
        secondary = DataSeries("Perempuan", listOf(6.8f, 14.8f, 14.8f, 5.7f, 2.4f, 0.7f, 0.9f)),
        unit = "%"
    )
)

@Composable
fun DataLearningShowcase(accent: Color) {
    var datasetLabel by rememberSaveable { mutableStateOf(learningDatasets.first().label) }
    var modeName by rememberSaveable { mutableStateOf(DataViewMode.VERTICAL.name) }
    val dataset = learningDatasets.first { it.label == datasetLabel }
    val availableModes = buildList {
        add(DataViewMode.TABLE)
        if (dataset.pictogramScale != null) add(DataViewMode.PICTOGRAM)
        add(DataViewMode.VERTICAL)
        add(DataViewMode.HORIZONTAL)
        if (dataset.secondary != null) add(DataViewMode.DOUBLE)
    }
    val selectedMode = DataViewMode.entries.firstOrNull { it.name == modeName && it in availableModes }
        ?: availableModes.first()

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
                        "▥",
                        color = accent,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Laboratorium Data",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "Ubah dataset dan cara penyajiannya",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            Text(
                "Pilih dataset",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(7.dp))
            LazyRow(
                contentPadding = PaddingValues(end = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(learningDatasets) { item ->
                    FilterChip(
                        selected = item.label == dataset.label,
                        onClick = {
                            datasetLabel = item.label
                            modeName = if (item.secondary != null) {
                                DataViewMode.DOUBLE.name
                            } else {
                                DataViewMode.VERTICAL.name
                            }
                        },
                        label = { Text(item.label) }
                    )
                }
            }

            Spacer(Modifier.height(12.dp))
            Text(
                "Pilih penyajian",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(7.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(availableModes) { mode ->
                    FilterChip(
                        selected = mode == selectedMode,
                        onClick = { modeName = mode.name },
                        label = { Text(mode.label) }
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = accent.copy(alpha = 0.06f),
                shape = RoundedCornerShape(22.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(14.dp)) {
                    Text(
                        dataset.label,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "${selectedMode.label} • satuan ${dataset.unit}",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(Modifier.height(14.dp))
                    when (selectedMode) {
                        DataViewMode.TABLE -> DataTable(dataset, accent)
                        DataViewMode.PICTOGRAM -> PictogramView(dataset, accent)
                        DataViewMode.VERTICAL -> VerticalBarChart(dataset, accent)
                        DataViewMode.HORIZONTAL -> HorizontalBarChart(dataset, accent)
                        DataViewMode.DOUBLE -> DoubleBarChart(dataset, accent)
                    }
                }
            }

            Spacer(Modifier.height(14.dp))
            DatasetInsight(dataset = dataset, accent = accent)
        }
    }
}

@Composable
private fun DataTable(dataset: LearningDataset, accent: Color) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(accent.copy(alpha = 0.10f), RoundedCornerShape(12.dp))
                .padding(horizontal = 10.dp, vertical = 9.dp)
        ) {
            Text("Kategori", modifier = Modifier.weight(1.2f), fontWeight = FontWeight.Bold)
            Text(dataset.primary.label, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            dataset.secondary?.let {
                Text(it.label, modifier = Modifier.weight(1f), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
            }
        }
        dataset.categories.forEachIndexed { index, category ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(category, modifier = Modifier.weight(1.2f), style = MaterialTheme.typography.bodyMedium)
                Text(dataset.primary.values[index].pretty(), modifier = Modifier.weight(1f), textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
                dataset.secondary?.let {
                    Text(it.values[index].pretty(), modifier = Modifier.weight(1f), textAlign = TextAlign.Center, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@Composable
private fun PictogramView(dataset: LearningDataset, accent: Color) {
    val scale = requireNotNull(dataset.pictogramScale)
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(
            "● = $scale ${dataset.unit}",
            color = accent,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )
        dataset.categories.forEachIndexed { index, category ->
            val value = dataset.primary.values[index].toInt()
            val full = value / scale
            val remainder = value % scale
            Column {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(category, modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                    Text("$value ${dataset.unit}", color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.labelMedium)
                }
                Spacer(Modifier.height(5.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(5.dp), verticalAlignment = Alignment.CenterVertically) {
                    repeat(full) {
                        Box(Modifier.size(18.dp).background(accent, CircleShape))
                    }
                    if (remainder > 0) {
                        Surface(color = accent.copy(alpha = 0.18f), shape = RoundedCornerShape(8.dp)) {
                            Text(
                                "+ $remainder/$scale simbol",
                                modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp),
                                color = accent,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun VerticalBarChart(dataset: LearningDataset, accent: Color) {
    val values = dataset.primary.values
    val maximum = max(1f, values.maxOrNull() ?: 1f)
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .semantics {
                contentDescription = "Diagram batang vertikal ${dataset.label}: ${dataset.categories.zip(values).joinToString { "${it.first} ${it.second.pretty()}" }}"
            }
    ) {
        val left = 22.dp.toPx()
        val bottom = size.height - 18.dp.toPx()
        val top = 12.dp.toPx()
        val chartWidth = size.width - left - 8.dp.toPx()
        val chartHeight = bottom - top
        val slot = chartWidth / values.size
        val barWidth = slot * 0.58f

        repeat(5) { step ->
            val y = top + chartHeight * step / 4f
            drawLine(
                color = accent.copy(alpha = 0.14f),
                start = Offset(left, y),
                end = Offset(size.width, y),
                strokeWidth = 1.dp.toPx()
            )
        }
        drawLine(accent.copy(alpha = 0.55f), Offset(left, top), Offset(left, bottom), 2.dp.toPx())
        drawLine(accent.copy(alpha = 0.55f), Offset(left, bottom), Offset(size.width, bottom), 2.dp.toPx())

        values.forEachIndexed { index, value ->
            val height = chartHeight * (value / maximum)
            val x = left + slot * index + (slot - barWidth) / 2f
            drawRoundRect(
                color = accent,
                topLeft = Offset(x, bottom - height),
                size = Size(barWidth, height),
                cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx())
            )
        }
    }
    CategoryLegend(dataset, accent)
}

@Composable
private fun HorizontalBarChart(dataset: LearningDataset, accent: Color) {
    val maximum = max(1f, dataset.primary.values.maxOrNull() ?: 1f)
    Column(
        modifier = Modifier.semantics {
            contentDescription = "Diagram batang horizontal ${dataset.label}"
        },
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        dataset.categories.forEachIndexed { index, category ->
            val value = dataset.primary.values[index]
            Column {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(category, modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                    Text("${value.pretty()} ${dataset.unit}", fontWeight = FontWeight.Bold, color = accent)
                }
                Spacer(Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(14.dp)
                        .background(accent.copy(alpha = 0.13f), RoundedCornerShape(7.dp))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth((value / maximum).coerceIn(0f, 1f))
                            .height(14.dp)
                            .background(accent, RoundedCornerShape(7.dp))
                    )
                }
            }
        }
    }
}

@Composable
private fun DoubleBarChart(dataset: LearningDataset, accent: Color) {
    val secondary = dataset.secondary ?: return DataTable(dataset, accent)
    val maximum = max(
        1f,
        max(dataset.primary.values.maxOrNull() ?: 1f, secondary.values.maxOrNull() ?: 1f)
    )
    val secondColor = BrandTeal
    Column(
        modifier = Modifier.semantics {
            contentDescription = "Diagram batang ganda ${dataset.label} membandingkan ${dataset.primary.label} dan ${secondary.label}"
        },
        verticalArrangement = Arrangement.spacedBy(11.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            LegendDot(accent, dataset.primary.label)
            LegendDot(secondColor, secondary.label)
        }
        dataset.categories.forEachIndexed { index, category ->
            Column {
                Text(category, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(4.dp))
                SeriesBar(dataset.primary.label, dataset.primary.values[index], maximum, accent, dataset.unit)
                Spacer(Modifier.height(4.dp))
                SeriesBar(secondary.label, secondary.values[index], maximum, secondColor, dataset.unit)
            }
        }
    }
}

@Composable
private fun SeriesBar(label: String, value: Float, maximum: Float, color: Color, unit: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label.take(1), modifier = Modifier.size(20.dp), color = color, fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier
                .weight(1f)
                .height(12.dp)
                .background(color.copy(alpha = 0.12f), RoundedCornerShape(6.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth((value / maximum).coerceIn(0f, 1f))
                    .height(12.dp)
                    .background(color, RoundedCornerShape(6.dp))
            )
        }
        Spacer(Modifier.size(8.dp))
        Text("${value.pretty()}$unit", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun LegendDot(color: Color, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(Modifier.size(10.dp).background(color, CircleShape))
        Spacer(Modifier.size(5.dp))
        Text(label, style = MaterialTheme.typography.labelMedium)
    }
}

@Composable
private fun CategoryLegend(dataset: LearningDataset, accent: Color) {
    Spacer(Modifier.height(8.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
        items(dataset.categories.indices.toList()) { index ->
            Surface(color = accent.copy(alpha = 0.10f), shape = RoundedCornerShape(10.dp)) {
                Text(
                    "${dataset.categories[index]} ${dataset.primary.values[index].pretty()}",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp),
                    color = accent,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun DatasetInsight(dataset: LearningDataset, accent: Color) {
    val primaryMax = dataset.primary.values.maxOrNull() ?: 0f
    val primaryMin = dataset.primary.values.minOrNull() ?: 0f
    val maxIndex = dataset.primary.values.indexOf(primaryMax).coerceAtLeast(0)
    val minIndex = dataset.primary.values.indexOf(primaryMin).coerceAtLeast(0)
    val summary = if (dataset.secondary == null) {
        "Tertinggi: ${dataset.categories[maxIndex]} ${primaryMax.pretty()} ${dataset.unit}. Terendah: ${dataset.categories[minIndex]} ${primaryMin.pretty()} ${dataset.unit}. Total: ${dataset.primary.values.sum().pretty()} ${dataset.unit}."
    } else {
        val secondary = dataset.secondary
        "Total ${dataset.primary.label}: ${dataset.primary.values.sum().pretty()}${dataset.unit}. Total ${secondary.label}: ${secondary.values.sum().pretty()}${dataset.unit}. Bandingkan kategori dengan skala yang sama."
    }
    Surface(color = accent.copy(alpha = 0.09f), shape = RoundedCornerShape(18.dp)) {
        Row(modifier = Modifier.fillMaxWidth().padding(14.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(34.dp).background(accent.copy(alpha = 0.17f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("i", color = accent, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.size(10.dp))
            Text(summary, modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
        }
    }
}

private fun Float.pretty(): String = if (this % 1f == 0f) {
    toInt().toString()
} else {
    String.format(Locale.US, "%.1f", this)
}
