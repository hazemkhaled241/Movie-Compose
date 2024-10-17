package com.hazem.movie_app.domain.repository

import com.hazem.movie_app.domain.model.ApiResponse
import com.hazem.movie_app.domain.model.MovieDetails
import retrofit2.Response

interface MovieRepository {

    suspend fun getAllMovies(page:Int):Response<ApiResponse>
    suspend fun getMovieById():MovieDetails
}