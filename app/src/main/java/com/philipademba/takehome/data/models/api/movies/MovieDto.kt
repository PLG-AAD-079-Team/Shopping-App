package com.philipademba.takehome.data.models.api.movies

import com.google.gson.annotations.SerializedName
import com.philipademba.takehome.data.database.entities.Movie

data class MovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("release_date") val firstAirDate: String? = "",
    @SerializedName("title") val name: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)

fun MovieDto.toMovie(page: Int = 0): Movie {
    return run {
        Movie(
            id,
            firstAirDate,
            name,
            originalTitle,
            originalLanguage,
            overview,
            posterPath,
            voteAverage,
            voteCount,
            page
        )
    }
}