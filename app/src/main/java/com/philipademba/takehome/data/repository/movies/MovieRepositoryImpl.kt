package com.philipademba.takehome.data.repository.movies

import com.philipademba.takehome.data.database.entities.Movie
import com.philipademba.takehome.data.datasource.movies.implementation.LocalMoviesDataSourceImpl
import com.philipademba.takehome.data.datasource.movies.implementation.RemoteMoviesDataSourceImpl
import com.philipademba.takehome.presentation.ui.movies.paging.MoviesPagingSource
import java.util.logging.Logger
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
            Logger.getLogger(MoviesPagingSource::class.java.name)
                .severe("Okwado remote ${result.size}")
            localMoviesDataSource.insertMovies(result)
            localMoviesDataSource.fetchMovies(pageNumber, options)
        } catch (e: Exception) {
            Logger.getLogger(MoviesPagingSource::class.java.name)
                .severe("Okwado error ${e.message}")
            localMoviesDataSource.fetchMovies(pageNumber, options)
        }

    }

    override suspend fun refresh(): List<Movie> {
        val pageNumber = 1
        val options: Map<String, String> = mapOf()
        return try {
            val result = remoteDataSource.fetchMovies(pageNumber, options)
            Logger.getLogger(MoviesPagingSource::class.java.name)
                .severe("Okwado remote reload ${result.size}")
            localMoviesDataSource.clearData()
            localMoviesDataSource.insertMovies(result)
            localMoviesDataSource.fetchMovies(pageNumber, options)
        } catch (e: Exception) {
            Logger.getLogger(MoviesPagingSource::class.java.name)
                .severe("Okwado error ${e.message}")
            localMoviesDataSource.fetchMovies(pageNumber, options)
        }
    }

}