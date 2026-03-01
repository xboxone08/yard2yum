package com.example.yard2yum.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// ===== Light Theme =====
private val LightColorScheme = lightColorScheme(
    primary = CreamSurface,
    secondary = CreamSurface,
    tertiary = CreamSurface,
    background = DarkGreenBackground,
    surface = CreamSurface,
    onPrimary = BlackText,
    onSecondary = BlackText,
    onTertiary = BlackText,
    onBackground = WhiteText,
    onSurface = BlackText
)

// ===== Dark Theme =====
private val DarkColorScheme = darkColorScheme(
    primary = CreamSurface,
    secondary = CreamSurface,
    tertiary = CreamSurface,
    background = DarkGreenBackground,
    surface = CreamSurface,
    onPrimary = BlackText,
    onSecondary = BlackText,
    onTertiary = BlackText,
    onBackground = WhiteText,
    onSurface = BlackText
)

@Composable
fun Yard2yumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}