package com.hazem.movie_app.data.repository

import com.hazem.movie_app.data.network.ApiService
import com.hazem.movie_app.domain.model.ApiResponse
import com.hazem.movie_app.domain.model.MovieDetails
import com.hazem.movie_app.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(apiService: ApiService):MovieRepository {

    override suspend fun getAllMovies(): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getMovieById(): MovieDetails {
        TODO("Not yet implemented")
    }

}