package com.philipademba.takehome.data.repository.moviesdetail


import com.philipademba.takehome.data.datasource.moviesdetail.implementation.LocalMovieDetailDataSourceImpl
import com.philipademba.takehome.data.datasource.moviesdetail.implementation.RemoteMovieDetailDataSourceImpl
import com.philipademba.takehome.data.database.entities.MovieDetail
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteMovieDetailDataSourceImpl,
    private val localMoviesDataSource: LocalMovieDetailDataSourceImpl
) :
    MovieDetailRepository {
    override suspend fun fetchMovieDetail(movieId: Int): MovieDetail? {
        val detail = localMoviesDataSource.fetchMovieDetail(movieId)
        if (detail == null) {
            val movieDetail = remoteDataSource.fetchMovieDetail(movieId)
            localMoviesDataSource.insertMovieDetail(movieDetail)
        }
        return localMoviesDataSource.fetchMovieDetail(movieId)


    }


}