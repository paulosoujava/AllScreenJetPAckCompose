package com.jorge.allscreen.ui.adaptivelayouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jorge.util.screen.ScreenClassifier


@Composable
fun AdaptiveLayoutsStacked(
    listState: LazyListState,
    screenClassifier: ScreenClassifier.HalfOpened.TableTopMode,
    uiState: AdaptiveLayoutsUiState,
    onSelectNumber: (Int) -> Unit
) {

    Column {
        Box(modifier = Modifier.fillMaxHeight(screenClassifier.hingeSeparationRatio)) {
            AdaptiveLayoutsListScreen(
                listState = listState,
                onSelectNumber = onSelectNumber
            )
        }

        Box(modifier = Modifier.fillMaxHeight()) {
            AdaptiveLayoutsDetailScreen(
                uiState = uiState
            )
        }
    }
}
