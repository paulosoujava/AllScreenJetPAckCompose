package com.jorge.allscreen.ui.adaptivelayouts


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jorge.allscreen.R


@Composable
fun AdaptiveLayoutsDetailScreen(
    uiState: AdaptiveLayoutsUiState
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        if (uiState.numberSelected) {
            Text(
                text = stringResource(id = R.string.selected_item, uiState.numberFromList),
                color = Color.Black,
                style = MaterialTheme.typography.h1
            )
        } else {
            Text(
                text = stringResource(id = R.string.no_item_selected),
                color = Color.Black,
                style = MaterialTheme.typography.h1
            )
        }
    }
}
