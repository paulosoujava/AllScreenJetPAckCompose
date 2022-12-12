package com.jorge.allscreen.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jorge.allscreen.ui.adaptivelayouts.AdaptiveLayoutsRoute
import com.jorge.allscreen.ui.adaptivelayouts.AdaptiveLayoutsViewModel
import com.jorge.allscreen.ui.home.HomeRoute
import com.jorge.allscreen.ui.screeninfo.ScreenInfoRoute
import com.jorge.util.screen.ScreenClassifier

@Composable
fun MultimodalNavGraph(
    screenClassifier: ScreenClassifier,
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home,
        modifier = modifier
    ) {
        composable(Destinations.Home) {
            HomeRoute(
                onViewScreenInfoButtonTap = { navController.navigate(Destinations.ScreenInfo) },
                onViewAdaptiveLayoutsButtonTap = { navController.navigate(Destinations.AdaptiveLayouts) }
            )
        }

        composable(Destinations.ScreenInfo) {
            ScreenInfoRoute(
                screenClassifier = screenClassifier
            )
        }

        composable(Destinations.AdaptiveLayouts) {
            val viewModel: AdaptiveLayoutsViewModel = viewModel()

                AdaptiveLayoutsRoute(
                    adaptiveLayoutsViewModel = viewModel,
                    screenClassifier = screenClassifier
                )
        }
    }
}
