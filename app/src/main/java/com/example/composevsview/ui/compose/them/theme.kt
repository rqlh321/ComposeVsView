package com.example.composevsview.ui.compose.them

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

enum class Theme(val color: ColorTheme) {
    MAIN(
        ColorTheme(
            light = ExtendedColors(
                main = Color(0xFFA1D2E8),
                support = Color(0xFFBD2A6F)
            ),
            dark = ExtendedColors(
                main = Color(0xFFA1E8C7),
                support = Color(0xFF7134BD)
            )
        )
    ),
    ALTERNATIVE(
        ColorTheme(
            light = ExtendedColors(
                main = Color(0xFFCDEBDD),
                support = Color(0xFF34BD82)
            ),
            dark = ExtendedColors(
                main = Color(0xFFEBB726),
                support = Color(0xFF34BD82)
            )
        )
    );
}

@Composable
fun AppTheme(
    theme: Theme,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (useDarkTheme) {
        theme.color.dark
    } else {
        theme.color.light
    }

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            typography = appTypography,
            content = content
        )
    }
}