package com.hazem.movie_app.data.network

import com.hazem.movie_app.domain.model.ApiResponse
import com.hazem.movie_app.domain.model.MovieDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movies?")
    suspend fun getMoviesList(
        @Query("page") page: Int = 1
    ): Response<ApiResponse>

    @GET("movies/{movie_id}")
    suspend fun getMovieById(
        @Path("movie_id")id:Int
    ):Response<MovieDetails>
}