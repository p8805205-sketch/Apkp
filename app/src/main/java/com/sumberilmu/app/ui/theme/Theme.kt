package com.sumberilmu.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFF4F46E5),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE9E7FF),
    onPrimaryContainer = Color(0xFF211A72),
    secondary = Color(0xFFF59E0B),
    onSecondary = Color(0xFF2D1B00),
    secondaryContainer = Color(0xFFFFE8B2),
    onSecondaryContainer = Color(0xFF4A2D00),
    tertiary = Color(0xFF0F9F7F),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFB8F2E4),
    onTertiaryContainer = Color(0xFF00382B),
    background = Color(0xFFF6F7FB),
    onBackground = Color(0xFF171923),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF171923),
    surfaceVariant = Color(0xFFE9EAF2),
    onSurfaceVariant = Color(0xFF5E6070),
    outline = Color(0xFF777887),
    outlineVariant = Color(0xFFD9DAE4),
    error = Color(0xFFBA1A1A),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFC3C0FF),
    onPrimary = Color(0xFF282078),
    primaryContainer = Color(0xFF37308F),
    onPrimaryContainer = Color(0xFFE6E3FF),
    secondary = Color(0xFFFFC85C),
    onSecondary = Color(0xFF412D00),
    secondaryContainer = Color(0xFF5E4200),
    onSecondaryContainer = Color(0xFFFFE8B2),
    tertiary = Color(0xFF79DCC1),
    onTertiary = Color(0xFF00382B),
    tertiaryContainer = Color(0xFF00513F),
    onTertiaryContainer = Color(0xFF9BF9DD),
    background = Color(0xFF0F1118),
    onBackground = Color(0xFFE7E8F0),
    surface = Color(0xFF171923),
    onSurface = Color(0xFFE7E8F0),
    surfaceVariant = Color(0xFF30323C),
    onSurfaceVariant = Color(0xFFC7C7D2),
    outline = Color(0xFF92929E),
    outlineVariant = Color(0xFF444650),
    error = Color(0xFFFFB4AB),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6)
)

private val AppTypography = Typography(
    displaySmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 36.sp,
        lineHeight = 42.sp,
        letterSpacing = (-0.5).sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 21.sp,
        lineHeight = 27.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        lineHeight = 23.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 25.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(28.dp)
)

@Composable
fun SumberIlmuTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
