package com.roywatson.androidcustomtheme

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.roywatson.androidcustomtheme.theme.CurrentTheme
import com.roywatson.androidcustomtheme.theme.CustomTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ThemeInstrumentedTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun customThemeInitializesToSystemMode() {
        var initialMode: CurrentTheme? = null
        rule.setContent {
            CustomTheme {
                initialMode = CustomTheme.themeMode.value
            }
        }
        assertEquals(CurrentTheme.System, initialMode)
    }
}
