package com.jorge.allscreen.ui.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jorge.allscreen.R

@Composable
fun HomeScreen(
    onViewScreenInfoButtonTap: () -> Unit,
    onViewAdaptiveLayoutsButtonTap: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onViewScreenInfoButtonTap
            ) {
                Text(text = stringResource(id = R.string.view_screen_info))
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onViewAdaptiveLayoutsButtonTap
            ) {
                Text(text = stringResource(id = R.string.view_adaptive_layouts))
            }
        }
    }
}

