package com.philipademba.takehome.data.datasource.moviesdetail.definition

import com.philipademba.takehome.data.database.entities.MovieDetail

interface MovieDetailDataSource {

    suspend fun fetchMovieDetail(movieId: Int): MovieDetail?

    suspend fun insertMovieDetail(movieDetail: MovieDetail) {

    }

}