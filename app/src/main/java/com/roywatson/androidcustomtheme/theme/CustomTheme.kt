package com.roywatson.androidcustomtheme.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.roywatson.androidcustomtheme.utils.isSystemInDarkMode


enum class CurrentTheme {
    System,
    Light,
    Dark,
}

fun CurrentTheme.next(): CurrentTheme {
    return CurrentTheme.entries[(this.ordinal + 1) % CurrentTheme.entries.size]
}

internal val ThemeColors = staticCompositionLocalOf<CustomThemeColors> { error("No ThemeColors provided") }
internal val ThemeMetrics = staticCompositionLocalOf<CustomThemeMetrics> { error("No ThemeMetrics provided") }
internal val ThemeType = staticCompositionLocalOf<CustomTypeStyles> { error("No ThemeType provided") }
internal val ThemeMode = compositionLocalOf { mutableStateOf( CurrentTheme.System) }

@Composable
fun CustomTheme(content: @Composable () -> Unit) {
    val theme = remember { mutableStateOf(CurrentTheme.System) }
    val isSystemDark = isSystemInDarkMode()
    val colors = remember(theme.value, isSystemDark) {
        when (theme.value) {
            CurrentTheme.System -> if (isSystemDark) CustomThemeColorsDark() else CustomThemeColorsLight()
            CurrentTheme.Dark -> CustomThemeColorsDark()
            CurrentTheme.Light -> CustomThemeColorsLight()
        }
    }
    val metrics = CustomThemeMetrics
    val type = CustomTypeStyles
    val mode = theme

    CompositionLocalProvider(
        ThemeColors provides colors,
        ThemeMetrics provides metrics,
        ThemeType provides type,
        ThemeMode provides mode,
    ) {
        content()
    }
}

object CustomTheme {
    val colorScheme : CustomThemeColors
        @Composable
        get() = ThemeColors.current
    val metrics : CustomThemeMetrics
        @Composable
        get() = ThemeMetrics.current
    val typeScheme : CustomTypeStyles
        @Composable
        get() = ThemeType.current
    val themeMode : MutableState<CurrentTheme>
        @Composable
        get() = ThemeMode.current
}
