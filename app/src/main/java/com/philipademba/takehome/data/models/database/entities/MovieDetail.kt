package com.philipademba.takehome.data.models.database.entities

import androidx.room.Entity
import com.philipademba.takehome.data.models.api.movies.ProductionCompanyResponse
import com.philipademba.takehome.data.models.api.movies.SpokenLanguage
import com.philipademba.takehome.data.models.api.movies.genre.Genre

@Entity(primaryKeys = ["id"])
data class MovieDetail(
    val adult: Boolean,
    val backdropPath: String?,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String?,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyResponse>,
    val releaseDate: String? = "",
    val revenue: Double,
    val runtime: Int?,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)