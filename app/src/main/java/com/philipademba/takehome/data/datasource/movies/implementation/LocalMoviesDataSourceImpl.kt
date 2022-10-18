package com.philipademba.takehome.data.datasource.movies.implementation


import com.philipademba.takehome.data.datasource.movies.definition.MoviesDataSource
import com.philipademba.takehome.data.models.database.dao.MovieDao
import com.philipademba.takehome.data.models.database.dao.MovieDetailDao
import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.data.models.database.entities.MovieDetail
import javax.inject.Inject

class LocalMoviesDataSourceImpl @Inject constructor(
    private val movieDao: MovieDao,
    private val movieDetailDao: MovieDetailDao
) :
    MoviesDataSource {
    override suspend fun search(
        pageNumber: Int,
        searchQuery: String,
        includeAdult: Boolean
    ) = movieDao.getMovieList(pageNumber)

    override suspend fun fetchMovies(
        pageNumber: Int,
        options: Map<String, String>
    ) = movieDao.getMovieList(pageNumber)


    override suspend fun insertMovies(list: List<Movie>) {
        movieDao.insertMovieList(list)
    }

}