package com.philipademba.takehome.presentation.ui.moviedetail.viemodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.philipademba.takehome.domain.moviedetail.GetMovieDetailUseCase
import com.philipademba.takehome.presentation.ui.moviedetail.state.MovieDetailUiState
import com.philipademba.takehome.shared.util.AppResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailScreenViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    savedStateHandle: SavedStateHandle,
) :
    ViewModel() {

    private val _state = MutableStateFlow(MovieDetailUiState())
    val state = _state.asStateFlow()

    init {
        val movieId: String? = savedStateHandle["movieId"]
        movieId?.let {
            _state.value =
                _state.value.copy(movieDetail = _state.value.movieDetail.copy(id = it.toInt()))
            getMovie(it.toInt())
        }
    }

    private fun getMovie(movieId: Int) {
        viewModelScope.launch {
            getMovieDetailUseCase.invoke(movieId).onEach { result ->
                run {
                    when (result) {
                        is AppResource.Error -> {
                            _state.value =
                                _state.value.copy(error = result.message, isLoading = false)
                        }

                        is AppResource.Success -> {
                            _state.value =
                                _state.value.copy(isLoading = false, movieDetail = result.data)
                        }

                        is AppResource.Loading -> {

                            _state.value =
                                _state.value.copy(error = "loading", isLoading = true)
                        }
                    }
                }
            }.collect()
        }
    }
}