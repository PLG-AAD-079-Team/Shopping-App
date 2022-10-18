package com.philipademba.takehome.presentation.ui.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.data.repository.moviesdetail.MovieRepository

class MoviesPagingSource constructor(private val movieRepository: MovieRepository) :
    PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val nextPageNumber = params.key ?: 1
        val response = movieRepository.fetchMovies(nextPageNumber, mapOf())
        val nextKey = if (response.isNotEmpty()) {
            nextPageNumber + 1
        } else {
            null
        }
        return LoadResult.Page(
            data = response,
            prevKey = null,
            nextKey = nextKey
        )
    }
}