package com.philipademba.takehome.data.models.api.movies.genre

import com.google.gson.annotations.SerializedName


data class GenresResponse(@SerializedName("genres") val genres: List<Genre>)


