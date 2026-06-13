package com.sumberilmu.app.ui

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
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sumberilmu.app.data.formatIndonesianNumber
import java.text.NumberFormat
import java.util.Locale

private data class PlaceColumn(val label: String, val divisor: Int)

private val placeColumns = listOf(
    PlaceColumn("Jutaan", 1_000_000),
    PlaceColumn("Ratus ribuan", 100_000),
    PlaceColumn("Puluh ribuan", 10_000),
    PlaceColumn("Ribuan", 1_000),
    PlaceColumn("Ratusan", 100),
    PlaceColumn("Puluhan", 10),
    PlaceColumn("Satuan", 1)
)

private val numberPresets = listOf(149_641, 324_569, 720_736, 979_875, 1_000_000)
private val comparisonPresets = listOf(599_047, 599_198, 963_000, 979_875)
private val idNumberFormat = NumberFormat.getIntegerInstance(Locale("id", "ID"))

@Composable
fun PlaceValueLearningShowcase(accent: Color) {
    var number by rememberSaveable { mutableIntStateOf(720_736) }
    var comparisonIndex by rememberSaveable { mutableIntStateOf(0) }
    val comparison = comparisonPresets[comparisonIndex]
    val relation = when {
        number > comparison -> ">"
        number < comparison -> "<"
        else -> "="
    }

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
                    Text("123", color = accent, fontWeight = FontWeight.ExtraBold)
                }
                Spacer(Modifier.size(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        "Laboratorium Nilai Tempat",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "Susun, baca, bandingkan, dan uraikan bilangan",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(Modifier.height(14.dp))
            Text("Preset dari buku", style = MaterialTheme.typography.labelLarge)
            Spacer(Modifier.height(7.dp))
            LazyRow(
                contentPadding = PaddingValues(end = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(numberPresets) { preset ->
                    AssistChip(
                        onClick = { number = preset },
                        label = { Text(preset.asIdNumber()) }
                    )
                }
            }

            Spacer(Modifier.height(14.dp))
            NumberHero(number = number, accent = accent)
            Spacer(Modifier.height(14.dp))

            LazyRow(
                modifier = Modifier.semantics {
                    contentDescription = "Tabel nilai tempat untuk bilangan ${number.asIdNumber()}"
                },
                horizontalArrangement = Arrangement.spacedBy(9.dp),
                contentPadding = PaddingValues(end = 12.dp)
            ) {
                items(placeColumns) { column ->
                    DigitControlCard(
                        number = number,
                        column = column,
                        accent = accent,
                        onChange = { delta -> number = changeDigit(number, column.divisor, delta) }
                    )
                }
            }

            Spacer(Modifier.height(15.dp))
            DecompositionCard(number = number, accent = accent)
            Spacer(Modifier.height(14.dp))
            ComparisonCard(
                number = number,
                comparison = comparison,
                relation = relation,
                accent = accent,
                onNextComparison = {
                    comparisonIndex = (comparisonIndex + 1) % comparisonPresets.size
                }
            )
            Spacer(Modifier.height(14.dp))
            OrderingCard(accent = accent)
        }
    }
}

@Composable
private fun NumberHero(number: Int, accent: Color) {
    Surface(color = accent.copy(alpha = 0.09f), shape = RoundedCornerShape(20.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                number.asIdNumber(),
                color = accent,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(Modifier.height(5.dp))
            Text(
                formatIndonesianNumber(number).replaceFirstChar { it.uppercase() },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun DigitControlCard(
    number: Int,
    column: PlaceColumn,
    accent: Color,
    onChange: (Int) -> Unit
) {
    val digit = digitAt(number, column.divisor)
    Card(
        modifier = Modifier.size(width = 116.dp, height = 164.dp),
        colors = CardDefaults.cardColors(containerColor = accent.copy(alpha = 0.07f)),
        shape = RoundedCornerShape(18.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(9.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                column.label,
                minLines = 2,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            TextButton(onClick = { onChange(1) }) {
                Text("+", color = accent, style = MaterialTheme.typography.titleLarge)
            }
            Text(
                digit.toString(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold
            )
            TextButton(onClick = { onChange(-1) }) {
                Text("−", color = accent, style = MaterialTheme.typography.titleLarge)
            }
            Text(
                (digit * column.divisor).asIdNumber(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun DecompositionCard(number: Int, accent: Color) {
    val decomposition = remember(number) { decompose(number) }
    Surface(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f), shape = RoundedCornerShape(18.dp)) {
        Column(modifier = Modifier.fillMaxWidth().padding(14.dp)) {
            Text("Dekomposisi", fontWeight = FontWeight.Bold, color = accent)
            Spacer(Modifier.height(5.dp))
            Text(
                decomposition,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun ComparisonCard(
    number: Int,
    comparison: Int,
    relation: String,
    accent: Color,
    onNextComparison: () -> Unit
) {
    Surface(color = accent.copy(alpha = 0.08f), shape = RoundedCornerShape(18.dp)) {
        Column(modifier = Modifier.fillMaxWidth().padding(14.dp)) {
            Text("Bandingkan", fontWeight = FontWeight.Bold, color = accent)
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(number.asIdNumber(), fontWeight = FontWeight.ExtraBold)
                Box(
                    modifier = Modifier.size(38.dp).background(accent, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(relation, color = Color.White, fontWeight = FontWeight.ExtraBold)
                }
                Text(comparison.asIdNumber(), fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(10.dp))
            OutlinedButton(onClick = onNextComparison, modifier = Modifier.fillMaxWidth()) {
                Text("Ganti bilangan pembanding")
            }
        }
    }
}

@Composable
private fun OrderingCard(accent: Color) {
    val source = listOf(342_231, 432_543, 232_231)
    val ascending = source.sorted().joinToString(" < ") { it.asIdNumber() }
    val descending = source.sortedDescending().joinToString(" > ") { it.asIdNumber() }
    Surface(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.48f), shape = RoundedCornerShape(18.dp)) {
        Column(modifier = Modifier.fillMaxWidth().padding(14.dp)) {
            Text("Urutan harga sepatu", fontWeight = FontWeight.Bold, color = accent)
            Spacer(Modifier.height(7.dp))
            Text("Naik: $ascending", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(4.dp))
            Text("Turun: $descending", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(9.dp))
            Button(onClick = {}, enabled = false, modifier = Modifier.fillMaxWidth()) {
                Text("Bandingkan dari ratus ribuan")
            }
        }
    }
}

private fun digitAt(number: Int, divisor: Int): Int = (number / divisor) % 10

private fun changeDigit(number: Int, divisor: Int, delta: Int): Int {
    val editableNumber = if (number == 1_000_000 && divisor < 1_000_000) 0 else number
    val current = digitAt(editableNumber, divisor)
    val next = (current + delta + 10) % 10
    val result = editableNumber + (next - current) * divisor
    return result.coerceIn(0, 1_000_000)
}

private fun decompose(number: Int): String {
    if (number == 0) return "0"
    return placeColumns.mapNotNull { column ->
        val digit = digitAt(number, column.divisor)
        if (digit == 0) null else (digit * column.divisor).asIdNumber()
    }.joinToString(" + ")
}

private fun Int.asIdNumber(): String = idNumberFormat.format(this)
