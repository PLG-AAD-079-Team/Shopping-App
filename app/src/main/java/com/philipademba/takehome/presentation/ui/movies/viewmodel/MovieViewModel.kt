package com.philipademba.takehome.presentation.ui.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.philipademba.takehome.data.repository.movies.MovieRepositoryImpl
import com.philipademba.takehome.presentation.ui.movies.paging.MoviesPagingSource
import com.philipademba.takehome.presentation.ui.movies.state.MovieListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepositoryImpl) :
    ViewModel() {

    private val _state = MutableStateFlow(MovieListUiState())
    val state = _state.asStateFlow()
    private val pager = Pager(

        config = PagingConfig(pageSize = 30, prefetchDistance = 20)
    ) {
        MoviesPagingSource(movieRepository)
    }
    var pagingFlow = pager.flow
        .cachedIn(viewModelScope)

    init {

    }

    fun refresh() {

    }
}