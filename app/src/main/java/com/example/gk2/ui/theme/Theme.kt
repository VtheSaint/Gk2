package com.example.gk2.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = primaryColor,
    background = backgroundColor,
    onPrimary = blackTextColor,
    surface = backgroundColor,
    onSurface = blackTextColor
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = extraColor,
    background = backgroundColor,
    onPrimary = whiteTextColor,
    surface = backgroundColor,
    onSurface = blackTextColor
)

@Composable
fun Gk2Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = Shapes,
        content = content
    )
}