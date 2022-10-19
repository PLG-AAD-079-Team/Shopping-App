package com.philipademba.takehome.data.services.moviedetail

import com.philipademba.takehome.data.models.api.moviedetail.MovieDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailService {
    @GET("movie/{movie_id}")
    suspend fun fetchMovieDetail(@Path("movie_id") movieId: Int): MovieDetailResponse
}
