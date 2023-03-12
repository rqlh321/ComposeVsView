package com.example.composevsview.ui.compose.them

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.composevsview.R

private val appFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.lemon_tuesday,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.lemon_tuesday,
            weight = FontWeight.W400,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.big_bad_robot,
            weight = FontWeight.W700,
            style = FontStyle.Normal
        ),
    )
)

val appTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = appFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Italic,
        letterSpacing = 0.sp,
    ),
)