package com.philipademba.takehome.data.datasource.movies.definition

import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.data.models.database.entities.MovieDetail

interface MoviesDataSource {

    suspend fun search(
        pageNumber: Int,
        searchQuery: String,
        includeAdult: Boolean = true
    ): List<Movie>

    suspend fun fetchMovies(
        pageNumber: Int,
        options: Map<String, String>
    ): List<Movie>


    suspend fun insertMovies(list: List<Movie>) {

    }

}