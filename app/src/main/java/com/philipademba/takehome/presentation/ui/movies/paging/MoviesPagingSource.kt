package com.philipademba.takehome.presentation.ui.movies.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.data.repository.movies.MovieRepository
import java.util.logging.Logger


class MoviesPagingSource constructor(private val movieRepository: MovieRepository) :
    PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        return try {
            val nextPageNumber = params.key ?: 1
            val response = movieRepository.fetchMovies(nextPageNumber, mapOf())
            Logger.getLogger(MoviesPagingSource::class.java.name).warning(" Okwado  nun- $nextPageNumber")
            val nextKey = if (response.isNotEmpty() && response.last().page < 35490) {
                response.last().page + 1
            } else {
                null
            }
            Logger.getLogger(MoviesPagingSource::class.java.name).warning(" Okwado $nextKey")
            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            Logger.getLogger(MoviesPagingSource::class.java.name).warning(e.message)
            LoadResult.Error(e)
        }
    }
}