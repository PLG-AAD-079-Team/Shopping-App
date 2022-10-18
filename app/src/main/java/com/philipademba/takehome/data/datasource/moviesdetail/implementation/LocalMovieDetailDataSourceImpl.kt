package com.philipademba.takehome.data.datasource.moviesdetail.implementation

import com.philipademba.takehome.data.datasource.moviesdetail.definition.MovieDetailDataSource
import com.philipademba.takehome.data.models.database.dao.MovieDao
import com.philipademba.takehome.data.models.database.dao.MovieDetailDao
import com.philipademba.takehome.data.models.database.entities.MovieDetail
import javax.inject.Inject

class LocalMovieDetailDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val movieDetailDao: MovieDetailDao
) :
    MovieDetailDataSource {
    override suspend fun fetchMovieDetail(movieId: Int) =
        movieDetailDao.getMovieDetail(movieId.toLong())

    override suspend fun insertMovieDetail(movieDetail: MovieDetail) {
        movieDetailDao.insertMovieDetailList(listOf(movieDetail))
    }
}