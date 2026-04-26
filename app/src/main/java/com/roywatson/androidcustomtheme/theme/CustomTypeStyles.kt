package com.roywatson.androidcustomtheme.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Stable
object CustomTypeStyles {

    val panelText = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )

    val buttonText = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )

    val textOne = TextStyle(
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

    val textTwo = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Center
    )

    val textThree = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}
