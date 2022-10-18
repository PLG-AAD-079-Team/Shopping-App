package com.philipademba.takehome.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.philipademba.takehome.presentation.ui.screens.moviedetail.screen.MovieDetailScreen
import com.philipademba.takehome.presentation.ui.screens.moviedetail.viemodel.MovieDetailScreenViewModel
import com.philipademba.takehome.presentation.ui.screens.movies.MovieListScreen
import com.philipademba.takehome.presentation.ui.screens.movies.MovieListViewModel


@Composable
fun AppRouteDestinations(
    navController: NavHostController,
) {
    Box(
        Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController, startDestination = ScreenRoutes.MoviesListScreen.route
        ) {
            composable(ScreenRoutes.MoviesListScreen.route) {
                val viewModel: MovieListViewModel = hiltViewModel()
                MovieListScreen(movieListViewModel = viewModel, onRefresh = {}, onMovieClicked = {
                    navController.navigate("${ScreenRoutes.MovieDetailScreen.route}/$it")
                })
            }

            composable("${ScreenRoutes.MovieDetailScreen.route}/{movieId}") {
                val viewModel: MovieDetailScreenViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()
                MovieDetailScreen(state)
            }
        }
    }
}
