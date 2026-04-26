package com.roywatson.androidcustomtheme.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
fun isSystemInDarkMode(): Boolean = isSystemInDarkTheme()
