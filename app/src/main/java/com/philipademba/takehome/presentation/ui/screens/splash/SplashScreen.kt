package com.philipademba.takehome.presentation.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.presentation.ui.screens.movies.MovieContent
import com.philipademba.takehome.presentation.ui.screens.movies.MovieListViewModel

@Composable
fun SplashScreen(
    movieListViewModel: MovieListViewModel,
    onRefresh: () -> Unit
) {


}

private const val COLUMN_COUNT = 2
private val GRID_SPACING = 8.dp

@Composable
fun LazyMoviesGrid(state: LazyGridState, moviePagingItems: LazyPagingItems<Movie>, onMovieClicked: (Int) -> Unit) {

    LazyVerticalGrid(columns = GridCells.Fixed(COLUMN_COUNT),
        contentPadding = PaddingValues(
            start = GRID_SPACING,
            end = GRID_SPACING,
            bottom = WindowInsets.navigationBars.getBottom(LocalDensity.current).toDp().dp.plus(
                GRID_SPACING
            )
        ),
        horizontalArrangement = Arrangement.spacedBy(GRID_SPACING, Alignment.CenterHorizontally),
        state = state,
        content = {

            items(moviePagingItems.itemCount) { index ->
                val movie = moviePagingItems.peek(index) ?: return@items
                MovieContent(
                    movie,
                    Modifier
                        .height(320.dp)
                        .padding(vertical = GRID_SPACING), onMovieClicked
                )
            }
        })
}

@Composable
fun Int.toDp(): Float {
    val density = LocalDensity.current.density
    return remember(this) { this / density }
}

