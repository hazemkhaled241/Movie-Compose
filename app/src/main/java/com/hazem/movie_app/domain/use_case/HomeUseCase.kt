package com.hazem.movie_app.domain.use_case

import com.hazem.movie_app.domain.model.ApiResponse
import com.hazem.movie_app.domain.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject

class HomeUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(page: Int): Response<ApiResponse> {
        return movieRepository.getAllMovies(page)
    }
}