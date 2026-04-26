package com.roywatson.androidcustomtheme

import androidx.compose.ui.graphics.Color
import com.roywatson.androidcustomtheme.theme.CurrentTheme
import com.roywatson.androidcustomtheme.theme.next
import com.roywatson.androidcustomtheme.utils.darken
import com.roywatson.androidcustomtheme.utils.lighten
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CurrentThemeNextTest {

    @Test
    fun systemAdvancesToLight() = assertEquals(CurrentTheme.Light, CurrentTheme.System.next())

    @Test
    fun lightAdvancesToDark() = assertEquals(CurrentTheme.Dark, CurrentTheme.Light.next())

    @Test
    fun darkWrapsBackToSystem() = assertEquals(CurrentTheme.System, CurrentTheme.Dark.next())

    @Test
    fun fullCycleReturnsToStart() {
        var theme = CurrentTheme.System
        repeat(CurrentTheme.entries.size) { theme = theme.next() }
        assertEquals(CurrentTheme.System, theme)
    }
}

class ColorExtensionsTest {

    @Test
    fun darkenByZeroIsUnchanged() {
        val color = Color(0.8f, 0.4f, 0.2f)
        val result = color.darken(0f)
        assertEquals(color.red, result.red, 0.002f)
        assertEquals(color.green, result.green, 0.002f)
        assertEquals(color.blue, result.blue, 0.002f)
        assertEquals(color.alpha, result.alpha, 0.002f)
    }

    @Test
    fun darkenByOneIsBlack() {
        val result = Color(0.8f, 0.4f, 0.2f).darken(1f)
        assertEquals(0f, result.red, 0.002f)
        assertEquals(0f, result.green, 0.002f)
        assertEquals(0f, result.blue, 0.002f)
    }

    @Test
    fun darkenMakesColorDarker() {
        val original = Color(0.8f, 0.6f, 0.4f)
        val result = original.darken(0.5f)
        assertTrue(result.red < original.red)
        assertTrue(result.green < original.green)
        assertTrue(result.blue < original.blue)
    }

    @Test
    fun darkenPreservesAlpha() {
        val color = Color(1f, 0f, 0f, 0.5f)
        assertEquals(0.5f, color.darken(0.5f).alpha, 0.002f)
    }

    @Test
    fun lightenByZeroIsUnchanged() {
        val color = Color(0.2f, 0.4f, 0.8f)
        val result = color.lighten(0f)
        assertEquals(color.red, result.red, 0.002f)
        assertEquals(color.green, result.green, 0.002f)
        assertEquals(color.blue, result.blue, 0.002f)
        assertEquals(color.alpha, result.alpha, 0.002f)
    }

    @Test
    fun lightenByOneIsWhite() {
        val result = Color(0.2f, 0.4f, 0.8f).lighten(1f)
        assertEquals(1f, result.red, 0.002f)
        assertEquals(1f, result.green, 0.002f)
        assertEquals(1f, result.blue, 0.002f)
    }

    @Test
    fun lightenMakesColorLighter() {
        val original = Color(0.2f, 0.4f, 0.6f)
        val result = original.lighten(0.5f)
        assertTrue(result.red > original.red)
        assertTrue(result.green > original.green)
        assertTrue(result.blue > original.blue)
    }

    @Test
    fun lightenPreservesAlpha() {
        val color = Color(0f, 0f, 1f, 0.75f)
        assertEquals(0.75f, color.lighten(0.5f).alpha, 0.002f)
    }
}
