package com.roywatson.androidcustomtheme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.roywatson.androidcustomtheme.theme.CustomTheme
import com.roywatson.androidcustomtheme.theme.next

@Composable
fun App() {
    val mode = CustomTheme.themeMode

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = CustomTheme.colorScheme.outerFrameBack)
            .safeContentPadding()
            .padding(all = CustomTheme.metrics.outerPanelPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = CustomTheme.colorScheme.innerPanelBack,
                    shape = RoundedCornerShape(CustomTheme.metrics.innerPanelCornerRadius)
                )
                .padding(vertical = CustomTheme.metrics.innerPanelPaddingVert),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Current mode is ${CustomTheme.themeMode.value.name}",
                color = CustomTheme.colorScheme.panelText,
                style = CustomTheme.typeScheme.panelText,
            )
            Spacer(modifier = Modifier.height(CustomTheme.metrics.spacerHeight))
            Button(
                onClick = { mode.value = mode.value.next() },
                colors = ButtonColors(
                    containerColor = CustomTheme.colorScheme.buttonBack,
                    contentColor = CustomTheme.colorScheme.buttonText,
                    disabledContainerColor = CustomTheme.colorScheme.buttonBack,
                    disabledContentColor =  CustomTheme.colorScheme.buttonText,
                )
            ) {
                Text(
                    text = "Switch to ${mode.value.next().name} mode",
                    style = CustomTheme.typeScheme.panelText,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Sample Text 1",
                    color = CustomTheme.colorScheme.textOne,
                    style = CustomTheme.typeScheme.textOne,
                )
                Spacer(modifier = Modifier.height(CustomTheme.metrics.spacerHeight))
                Text(
                    text = "Sample Text 2",
                    color = CustomTheme.colorScheme.textTwo,
                    style = CustomTheme.typeScheme.textTwo,
                )
                Spacer(modifier = Modifier.height(CustomTheme.metrics.spacerHeight))
                Text(
                    text = "Sample Text 3",
                    color = CustomTheme.colorScheme.textThree,
                    style = CustomTheme.typeScheme.textThree,
                )
            }
        }
    }
}