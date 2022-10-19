package com.philipademba.takehome.data.database.entities

import androidx.room.Entity
import com.philipademba.takehome.data.models.api.moviedetail.ProductionCompanyResponse
import com.philipademba.takehome.data.models.api.moviedetail.SpokenLanguage
import com.philipademba.takehome.data.models.api.moviedetail.genre.Genre

@Entity(primaryKeys = ["id"])
data class MovieDetail(
    val adult: Boolean = false,
    val backdropPath: String? = "",
    val budget: Int = 0,
    val genres: List<Genre> = listOf(),
    val homepage: String? = "",
    val id: Int = 0,
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val posterPath: String = "",
    val productionCompanies: List<ProductionCompanyResponse> = listOf(),
    val releaseDate: String? = "",
    val revenue: Double = 0.0,
    val runtime: Int? = 0,
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)