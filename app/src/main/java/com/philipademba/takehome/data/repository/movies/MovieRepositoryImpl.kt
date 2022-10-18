package com.philipademba.takehome.data.repository.movies

import com.philipademba.takehome.data.datasource.movies.implementation.LocalMoviesDataSourceImpl
import com.philipademba.takehome.data.datasource.movies.implementation.RemoteMoviesDataSourceImpl
import com.philipademba.takehome.data.models.database.entities.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteMoviesDataSourceImpl,
    private val localMoviesDataSource: LocalMoviesDataSourceImpl
) :
    MovieRepository {
    override suspend fun search(
        pageNumber: Int,
        searchQuery: String,
        includeAdult: Boolean
    ): List<Movie> {
        return try {
            remoteDataSource.search(pageNumber, searchQuery)
        } catch (e: Exception) {
            localMoviesDataSource.search(pageNumber, searchQuery)
        }
    }

    override suspend fun fetchMovies(pageNumber: Int, options: Map<String, String>): List<Movie> {
        return try {
            val result = remoteDataSource.fetchMovies(pageNumber, options)
            localMoviesDataSource.insertMovies(result)
            localMoviesDataSource.fetchMovies(pageNumber, options)
        } catch (e: Exception) {
            localMoviesDataSource.fetchMovies(pageNumber, options)
        }

    }


    override suspend fun refresh() {
    }

}