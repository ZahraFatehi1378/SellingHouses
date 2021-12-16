package com.example.sellinghouses.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = firstDark,
    primaryVariant = Dark,
    secondary = firstBright,
    secondaryVariant = transparentBright,
    background =firstDark,
    surface =firstDark // spacers colors in lazy colomn
)

private val LightColorPalette = lightColors(
    primary = firstBright,
    primaryVariant = Color.White,
    secondary = Dark,
    secondaryVariant = transparentDark,

    background =firstBright,
    surface =firstBright
)

/* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/

@Composable
fun SellingHousesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}