package com.philipademba.takehome.data.datasource.movies.definition

import com.philipademba.takehome.data.database.entities.Movie

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
    suspend fun clearData(){

    }

}