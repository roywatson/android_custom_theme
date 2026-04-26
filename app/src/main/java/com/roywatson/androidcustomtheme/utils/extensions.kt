package com.roywatson.androidcustomtheme.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

// lighten is not used in this project but it's included here as a companion to darken
// and for reference and your future use.
// amount: 0.0 = no change, 1.0 = full white. Alpha is preserved.
fun Color.lighten(amount: Float): Color = lerp(this, Color(1f, 1f, 1f, alpha), amount)

// amount: 0.0 = no change, 1.0 = full black. Alpha is preserved.
fun Color.darken(amount: Float): Color = lerp(this, Color(0f, 0f, 0f, alpha), amount)



