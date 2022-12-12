package com.jorge.allscreen.ui.screeninfo

import androidx.compose.runtime.Composable
import com.jorge.util.screen.ScreenClassifier


@Composable
fun ScreenInfoRoute(
    screenClassifier: ScreenClassifier
) {
    ScreenInfoScreen(
        screenClassifier = screenClassifier
    )
}
