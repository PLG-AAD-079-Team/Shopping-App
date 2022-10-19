package com.philipademba.takehome.presentation.ui.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.philipademba.takehome.data.repository.movies.MovieRepositoryImpl

import com.philipademba.takehome.presentation.ui.movies.paging.MoviesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepositoryImpl) :
    ViewModel() {
    var pagingFlow = Pager(

        config = PagingConfig(pageSize = 30, prefetchDistance = 20)
    ) {
        MoviesPagingSource(movieRepository)
    }.flow
        .cachedIn(viewModelScope)

    init {

    }

    fun refresh() {
        viewModelScope.launch {
            movieRepository.refresh()
            pagingFlow = Pager(

                config = PagingConfig(pageSize = 30, prefetchDistance = 20)
            ) {
                MoviesPagingSource(movieRepository)
            }.flow
                .cachedIn(viewModelScope)
        }
    }
}