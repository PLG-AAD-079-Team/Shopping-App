package com.philipademba.takehome.data.apiservice

import com.philipademba.takehome.data.models.api.movies.CreditsResponse
import com.philipademba.takehome.data.models.api.movies.ImagesResponse
import com.philipademba.takehome.data.models.api.movies.MovieDetailResponse
import com.philipademba.takehome.data.models.api.movies.genre.GenresResponse
import com.philipademba.takehome.data.models.api.movies.MoviesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieService {


    @GET("search/movie")
    suspend fun search(
        @Query("page") pageNumber: Int,
        @Query("query") searchQuery: String,
        @Query("include_adult") includeAdult: Boolean = true
    ): MoviesDto

    @GET("discover/movie")
    suspend fun fetchMovies(
        @Query("page") pageNumber: Int,
        @QueryMap options: Map<String, String>
    ): MoviesDto

    @GET("genre/movie/list")
    suspend fun fetchGenres(): GenresResponse

    @GET("movie/{movie_id}")
    suspend fun fetchMovieDetail(@Path("movie_id") movieId: Int): MovieDetailResponse

    @GET("movie/{movie_id}/credits")
    suspend fun fetchMovieCredits(@Path("movie_id") movieId: Int): CreditsResponse

    @GET("movie/{movie_id}/images")
    suspend fun fetchMovieImages(@Path("movie_id") movieId: Int): ImagesResponse
}
