package com.philipademba.takehome.presentation.navigation

import com.philipademba.takehome.shared.util.AppDestinations

sealed class ScreenRoutes(val route: String) {
    object SplashScreen : ScreenRoutes(route = AppDestinations.SPLASH)
    object MoviesListScreen : ScreenRoutes(route = AppDestinations.MOVIES_LIST_SCREEN)
    object MovieDetailScreen : ScreenRoutes(route = AppDestinations.MOVIES_DETAIL_SCREEN)
    object MapScreen : ScreenRoutes(route = AppDestinations.MAP_SCREEN)

}

