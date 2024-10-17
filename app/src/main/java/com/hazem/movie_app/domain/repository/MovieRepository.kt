package com.hazem.movie_app.domain.repository

import com.hazem.movie_app.domain.model.ApiResponse
import com.hazem.movie_app.domain.model.MovieDetails

interface MovieRepository {

    suspend fun getAllMovies():ApiResponse
    suspend fun getMovieById():MovieDetails
}