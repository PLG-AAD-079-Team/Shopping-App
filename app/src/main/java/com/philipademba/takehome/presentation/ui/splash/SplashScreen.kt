package com.philipademba.takehome.presentation.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.philipademba.takehome.data.database.entities.Movie
import com.philipademba.takehome.presentation.ui.movies.screen.MovieContent
import com.philipademba.takehome.presentation.ui.movies.viewmodel.MovieListViewModel

@Composable
fun SplashScreen(
    movieListViewModel: MovieListViewModel,
    onRefresh: () -> Unit
) {

}

private const val COLUMN_COUNT = 2
private val GRID_SPACING = 8.dp


@Composable
fun Int.toDp(): Float {
    val density = LocalDensity.current.density
    return remember(this) { this / density }
}

