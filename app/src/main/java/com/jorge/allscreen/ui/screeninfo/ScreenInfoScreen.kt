package com.jorge.allscreen.ui.screeninfo



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jorge.util.screen.ScreenClassifier
import com.jorge.allscreen.R

@Composable
fun ScreenInfoScreen(
    screenClassifier: ScreenClassifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxSize()
    ) {
        Column {
            Text(
                text = screenClassifier::class.java.simpleName,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = screenClassifier.toString(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )

            if (screenClassifier is ScreenClassifier.HalfOpened) {
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(id = R.string.hinge_position),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(
                        R.string.hinge_position_coordinates,
                        screenClassifier.hingPosition.top,
                        screenClassifier.hingPosition.bottom,
                        screenClassifier.hingPosition.left,
                        screenClassifier.hingPosition.right
                    ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(
                        R.string.hinge_position_size,
                        screenClassifier.hingPosition.width(),
                        screenClassifier.hingPosition.height()
                    ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
