package com.hazem.movie_app.presentation.screen.details

import com.hazem.movie_app.domain.model.MovieDetails

data class DetailsState(
    val data: MovieDetails = MovieDetails(),
    val error: String? = null,
    val isLoading: Boolean = false
)
