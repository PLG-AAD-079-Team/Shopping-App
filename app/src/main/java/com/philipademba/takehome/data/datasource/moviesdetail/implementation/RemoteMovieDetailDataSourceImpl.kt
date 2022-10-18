package com.philipademba.takehome.data.datasource.moviesdetail.implementation

import com.philipademba.takehome.data.apiservice.movie.MovieService
import com.philipademba.takehome.data.datasource.moviesdetail.definition.MovieDetailDataSource
import com.philipademba.takehome.data.models.api.movies.toMoviesDetails
import javax.inject.Inject

class RemoteMovieDetailDataSourceImpl @Inject constructor(private val movieService: MovieService) :
    MovieDetailDataSource {

    override suspend fun fetchMovieDetail(movieId: Int) =
        movieService.fetchMovieDetail(movieId).toMoviesDetails()
}