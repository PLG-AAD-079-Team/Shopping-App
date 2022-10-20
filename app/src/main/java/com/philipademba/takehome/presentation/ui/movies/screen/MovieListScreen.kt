package com.philipademba.takehome.presentation.ui.movies.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.philipademba.takehome.R
import com.philipademba.takehome.data.database.entities.Movie
import com.philipademba.takehome.presentation.ui.movies.viewmodel.MovieListViewModel

private const val COLUMN_COUNT = 2
private val GRID_SPACING = 8.dp

@Composable
fun MovieListScreen(
    movieListViewModel: MovieListViewModel,
    onRefresh: () -> Unit = {},
    onMovieClicked: (Int) -> Unit
) {
    val movies: LazyPagingItems<Movie> = movieListViewModel.pagingFlow.collectAsLazyPagingItems()
    val pullState = remember { SwipeRefreshState(isRefreshing = false) }

    SwipeRefresh(state = pullState, onRefresh) {
        Box(
            Modifier
                .fillMaxSize()
                .background(color = Color.White), contentAlignment = Alignment.Center
        ) {
            when (movies.loadState.refresh) {
                is LoadState.Loading -> {
                    pullState.isRefreshing = true
                    Text(stringResource(id = R.string.fetching_movies))
                }

                is LoadState.Error -> {
                    val error = movies.loadState.refresh as LoadState.Error
                    Text(error.error.message.orEmpty())
                }

                else -> {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2), userScrollEnabled = true,
                        contentPadding = PaddingValues(
                            start = GRID_SPACING,
                            end = GRID_SPACING,
                            bottom = GRID_SPACING,
                        ),
                        horizontalArrangement = Arrangement.spacedBy(
                            GRID_SPACING,
                            Alignment.CenterHorizontally
                        ),
                    ) {
                        //                    LazyMoviesGrid(state, movies, onMovieClicked)
                        items(movies.itemCount) {
                            movies[it]?.let { it1 ->
                                Box(Modifier.height(300.dp)) {
                                    MovieContent(movie = it1, onMovieClicked = onMovieClicked)
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}