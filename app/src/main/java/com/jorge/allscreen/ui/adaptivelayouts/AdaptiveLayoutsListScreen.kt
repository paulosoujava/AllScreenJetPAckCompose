package com.jorge.allscreen.ui.adaptivelayouts


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun AdaptiveLayoutsListScreen(
    numbers: List<Int> = (1..50).toList(),
    listState: LazyListState,
    onSelectNumber: (Int) -> Unit
) {

    LazyColumn(state = listState) {
        items(numbers) { number ->
            RowWithNumber(
                number = number,
                onSelectNumber = onSelectNumber
            )
        }
    }
}

@Composable
private fun RowWithNumber(
    number: Int,
    onSelectNumber: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable(
                indication = rememberRipple(bounded = true),
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onSelectNumber(number) }
            )
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = number.toString(),
            color = Color.Black,
            style = MaterialTheme.typography.h1
        )
    }
}

