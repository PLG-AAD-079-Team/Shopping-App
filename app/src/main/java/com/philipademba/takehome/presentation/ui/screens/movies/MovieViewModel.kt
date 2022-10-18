package com.philipademba.takehome.presentation.ui.screens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.philipademba.takehome.data.repository.moviesdetail.MovieRepositoryImpl
import com.philipademba.takehome.presentation.ui.paging.MoviesPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepositoryImpl) :
    ViewModel() {
    val pagingFlow = Pager(
        PagingConfig(pageSize = 20)
    ) {
        MoviesPagingSource(movieRepository)
    }.flow
        .cachedIn(viewModelScope)

    init {

    }

    fun refresh() {
        viewModelScope.launch {
            movieRepository.refresh()
        }
    }
}