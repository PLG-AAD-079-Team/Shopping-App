package com.philipademba.takehome.data.models.api.movies

import com.google.gson.annotations.SerializedName
import com.philipademba.takehome.data.models.database.entities.Movie


data class MoviesDto(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MovieDto>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)


fun MoviesDto.getMoviesList(): List<Movie> {
    return this.movies.map {
        it.toMovie(page)
    }
}
