package com.roywatson.androidcustomtheme.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.roywatson.androidcustomtheme.utils.darken

@Immutable
interface CustomThemeColors {
    val outerFrameBack : Color
    val innerPanelBack : Color
    val panelText : Color

    val buttonBack : Color
    val buttonText : Color

    val textOne : Color
    val textTwo : Color
    val textThree : Color
}

@Immutable
class CustomThemeColorsDark : CustomThemeColors {
    override val outerFrameBack : Color = Color(0xFF26282B)
    override val innerPanelBack : Color = Color(0xFF191A1C)
    override val panelText : Color = Color(0xFFAFB1B7)

    override val buttonBack : Color = Color(0xFF54BAF8)
    override val buttonText : Color = Color.Black

    override val textOne : Color = Color(0xFF518C57)
    override val textTwo : Color = Color(0xFFC77DBB)
    override val textThree : Color = Color(0xFF70AEFF)
}

@Immutable
class CustomThemeColorsLight : CustomThemeColors {
    override val outerFrameBack : Color = Color(0xFFEBECF0)
    override val innerPanelBack : Color = Color(0xFFFFFFFF)
    override val panelText : Color = Color(0xFF040404)

    override val buttonBack : Color = Color(0xFF54BAF8)
    override val buttonText : Color = Color.Black

    override val textOne : Color = Color(0xFF518C57)
    override val textTwo : Color = Color(0xFFC77DBB)
    override val textThree : Color = Color(0xFF70AEFF).darken(.25f)
}
