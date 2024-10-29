package com.hazem.movie_app.domain.use_case

import com.hazem.movie_app.domain.model.MovieDetails
import com.hazem.movie_app.domain.repository.MovieRepository
import retrofit2.Response
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(id: Int): Response<MovieDetails> {
        return movieRepository.getMovieById(id)
    }
}