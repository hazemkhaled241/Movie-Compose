package com.hazem.movie_app.domain.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val country: String,
    val genres: List<String>,
    val id: Int,
    val images: List<String>,
    @SerializedName("imdb_rating")
    val imdbRating: String,
    val poster: String,
    val title: String,
    val year: String
)
