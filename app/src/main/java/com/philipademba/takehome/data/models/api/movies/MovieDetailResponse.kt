package com.philipademba.takehome.data.models.api.movies

import com.google.gson.annotations.SerializedName
import com.philipademba.takehome.data.models.api.movies.genre.Genre
import com.philipademba.takehome.data.models.database.entities.MovieDetail


data class MovieDetailResponse(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("budget") val budget: Int,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("id") val id: Int,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanyResponse>,
    @SerializedName("release_date") val releaseDate: String? = "",
    @SerializedName("revenue") val revenue: Double,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status") val status: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
)

fun MovieDetailResponse.toMoviesDetails(): MovieDetail {
    return MovieDetail(
        adult,
        backdropPath,
        budget,
        genres,
        homepage,
        id,
        originalLanguage,
        originalTitle,
        overview,
        popularity,
        posterPath,
        productionCompanies,
        releaseDate,
        revenue,
        runtime,
        spokenLanguages,
        status,
        tagline,
        title,
        voteAverage,
        voteCount
    )
}


