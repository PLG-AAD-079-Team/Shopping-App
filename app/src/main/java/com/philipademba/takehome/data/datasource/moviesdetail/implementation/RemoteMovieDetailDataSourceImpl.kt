package com.philipademba.takehome.data.datasource.moviesdetail.implementation

import com.philipademba.takehome.data.datasource.moviesdetail.definition.MovieDetailDataSource
import com.philipademba.takehome.data.models.api.moviedetail.toMoviesDetails
import com.philipademba.takehome.data.services.movie.MovieService
import javax.inject.Inject

class RemoteMovieDetailDataSourceImpl @Inject constructor(private val movieService: MovieService) :
    MovieDetailDataSource {

    override suspend fun fetchMovieDetail(movieId: Int) =
        movieService.fetchMovieDetail(movieId).toMoviesDetails()
}