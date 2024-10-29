package com.hazem.movie_app.data.repository

import com.hazem.movie_app.data.network.ApiService
import com.hazem.movie_app.domain.model.ApiResponse
import com.hazem.movie_app.domain.model.MovieDetails
import com.hazem.movie_app.domain.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(private val apiService: ApiService) : MovieRepository {

    override suspend fun getAllMovies(page: Int): Response<ApiResponse> {
        return apiService.getMoviesList(page)
    }

    override suspend fun getMovieById(id: Int): Response<MovieDetails> {
       return apiService.getMovieById(id)
    }

}