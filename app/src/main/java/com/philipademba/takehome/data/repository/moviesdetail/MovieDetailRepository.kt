package com.philipademba.takehome.data.repository.moviesdetail

import com.philipademba.takehome.data.database.entities.MovieDetail

interface MovieDetailRepository {
    suspend fun fetchMovieDetail(movieId: Int): MovieDetail?
}