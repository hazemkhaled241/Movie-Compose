package com.hazem.movie_app.data.network

import com.hazem.movie_app.domain.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movies?/page=1")
    suspend fun getMoviesList(): Response<ApiResponse>
}