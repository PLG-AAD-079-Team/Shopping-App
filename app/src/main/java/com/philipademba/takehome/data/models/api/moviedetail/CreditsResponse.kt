package com.philipademba.takehome.data.models.api.moviedetail

import com.google.gson.annotations.SerializedName
import com.philipademba.takehome.data.models.api.moviedetail.cast.CastResponse
import com.philipademba.takehome.data.models.api.moviedetail.cast.CrewResponse


data class CreditsResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("cast") val cast: List<CastResponse>,
    @SerializedName("crew") val crew: List<CrewResponse>
)


