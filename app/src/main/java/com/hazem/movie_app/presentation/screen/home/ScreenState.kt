package com.hazem.movie_app.presentation.screen.home

import com.hazem.movie_app.domain.model.Movie

data class ScreenState(
    val data: List<Movie> = emptyList(),
    val page: Int = 1,
    val error: String? = null,


    )
