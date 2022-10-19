package com.philipademba.takehome.presentation.ui.moviedetail.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.philipademba.takehome.presentation.ui.moviedetail.state.MovieDetailUiState

@Composable
fun MovieDetailScreen(state: MovieDetailUiState) {
    Box(Modifier.fillMaxSize()) {
        MovieDetail(movie = state.movieDetail)
    }
}