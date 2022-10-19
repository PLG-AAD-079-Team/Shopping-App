package com.philipademba.takehome.presentation.ui.moviedetail.state

import com.philipademba.takehome.data.database.entities.MovieDetail

data class MovieDetailUiState(
    val movieDetail: MovieDetail = MovieDetail(),
    val error: String? = null,
    val isLoading: Boolean = false
)
