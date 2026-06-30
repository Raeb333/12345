package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = EmeraldAccent,
    onPrimary = Color.Black,
    primaryContainer = NavyPrimary,
    onPrimaryContainer = Color.White,
    secondary = EmeraldAccent,
    onSecondary = Color.Black,
    background = NavyDarkBG,
    surface = NavySurface,
    onBackground = Color(0xFFF1F5F9),
    onSurface = Color(0xFFF1F5F9),
    surfaceVariant = Color(0xFF1E293B),
    onSurfaceVariant = Color(0xFF94A3B8)
)

private val LightColorScheme = lightColorScheme(
    primary = NavyPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFF1E2D4A),
    onPrimaryContainer = Color.White,
    secondary = EmeraldDark,
    onSecondary = Color.White,
    background = WhiteBackground,
    surface = WhiteSurface,
    onBackground = TextNavy,
    onSurface = TextNavy,
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = TextSlate
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    // Avoid dynamic wallpaper coloring to enforce the specific brand colors requested (azul marino + blanco + esmeralda)
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
