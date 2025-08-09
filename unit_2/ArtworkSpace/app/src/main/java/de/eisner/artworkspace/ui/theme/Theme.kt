package de.eisner.artworkspace.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD9A575),
    onPrimary = Color(0xFF3F2E1E),
    primaryContainer = Color(0xFF664429),
    onPrimaryContainer = Color(0xFFF3E1D7),
    secondary = Color(0xFFA4B2A1),
    onSecondary = Color(0xFF2B372D),
    secondaryContainer = Color(0xFF43523F),
    onSecondaryContainer = Color(0xFFD7E4D7),
    tertiary = Color(0xFFD1B79A),
    onTertiary = Color(0xFF3F2E1E),
    tertiaryContainer = Color(0xFF5E4735),
    onTertiaryContainer = Color(0xFFF5E8DC),
    background = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1D9),
    surface = Color(0xFF28262C),
    onSurface = Color(0xFFE6E1D9),
    surfaceVariant = Color(0xFF3F3A3E),
    onSurfaceVariant = Color(0xFFBEB5AA),
    outline = Color(0xFF6E655B),
    inverseOnSurface = Color(0xFF1C1B1F),
    inverseSurface = Color(0xFFFAF8F5),
    inversePrimary = Color(0xFF6F4B2B),
    scrim = Color(0xCC000000),
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,

    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,

    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,

    background = background,
    onBackground = onBackground,

    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,

    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,

    outline = outline,
    outlineVariant = outlineVariant,

    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    inversePrimary = inversePrimary,
    scrim = scrim,
)

@Composable
fun ArtworkSpaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}