package com.philipademba.takehome.presentation.ui.screens.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.presentation.ui.screens.splash.LazyMoviesGrid

@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel,
    onRefresh: () -> Unit = {},
    onMovieClicked: (Int) -> Unit
) {
    val movies: LazyPagingItems<Movie> = movieListViewModel.pagingFlow.collectAsLazyPagingItems()
    val state = rememberLazyGridState()
    val pullState = remember { SwipeRefreshState(isRefreshing = false) }

    Box(
        Modifier
            .fillMaxSize()
            .background(color = Color.White), contentAlignment = Alignment.Center
    ) {
        when (movies.loadState.refresh) {
            is LoadState.Loading -> {
                // LoadingColumn(stringResource(id = R.string.fetching_movies))
            }

            is LoadState.Error -> {
                val error = movies.loadState.refresh as LoadState.Error
                // ErrorColumn(error.error.message.orEmpty())
            }

            else -> {
                SwipeRefresh(
                    modifier = Modifier,
                    state = pullState,
                    onRefresh = onRefresh,
                    indicator = { state, triggerSize ->
                        // Custom indicator logic here
                    }
                ) {
                    LazyMoviesGrid(state, movies, onMovieClicked)
                }

            }
        }
    }
}