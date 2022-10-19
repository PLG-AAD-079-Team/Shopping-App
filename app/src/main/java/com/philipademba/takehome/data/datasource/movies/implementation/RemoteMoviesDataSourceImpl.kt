package com.philipademba.takehome.data.datasource.movies.implementation


import com.philipademba.takehome.data.services.movie.MovieService
import com.philipademba.takehome.data.datasource.movies.definition.MoviesDataSource
import com.philipademba.takehome.data.models.api.movies.getMoviesList
import javax.inject.Inject

class RemoteMoviesDataSourceImpl @Inject constructor(private val movieService: MovieService) :
    MoviesDataSource {
    override suspend fun fetchMovies(
        pageNumber: Int,
        options: Map<String, String>
    ) = movieService.fetchMovies(pageNumber, options).getMoviesList()

    override suspend fun search(
        pageNumber: Int,
        searchQuery: String,
        includeAdult: Boolean
    ) = movieService.search(pageNumber, searchQuery, includeAdult).getMoviesList()


}