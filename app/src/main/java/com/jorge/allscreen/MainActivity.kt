package com.jorge.allscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import androidx.window.layout.WindowInfoTracker
import androidx.window.layout.WindowLayoutInfo
import com.jorge.allscreen.ui.navigation.MultimodalNavGraph
import com.jorge.allscreen.ui.theme.AllScreenTheme
import com.jorge.util.screen.ScreenInfo
import com.jorge.util.screen.rememberWindowDpSize
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val devicePosture = WindowInfoTracker
            .getOrCreate(this)
            .windowLayoutInfo(this)
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = WindowLayoutInfo(emptyList())


            )

        setContent {

            val windowDpSize = rememberWindowDpSize(this)

            AllScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Multimodal(
                        devicePosture = devicePosture,
                        windowDpSize = windowDpSize
                    )
                }
            }
        }
    }
}

@Composable
fun Multimodal(
    windowDpSize: DpSize,
    devicePosture: StateFlow<WindowLayoutInfo>
) {

    val devicePostureValue by devicePosture.collectAsState()

    val navController = rememberNavController()
    val screenClassifier = ScreenInfo().createClassifier(
        devicePostureValue,
        windowDpSize
    )

    Scaffold { innerPadding ->

        MultimodalNavGraph(
            screenClassifier = screenClassifier,
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )

    }
}

