package com.example.composevsview.ui.compose.them

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorTheme(
    val light: ExtendedColors,
    val dark: ExtendedColors,
)

@Immutable
data class ExtendedColors(
    val main: Color,
    val support: Color
)
object ExtendedTheme {
    val colors: ExtendedColors
        @Composable
        get() = LocalExtendedColors.current
}

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        main = Color.Unspecified,
        support = Color.Unspecified
    )
}