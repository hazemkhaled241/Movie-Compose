package com.hazem.movie_app.domain

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val country: String,
    val genres: List<String>,
    val images: List<String>,
    @SerializedName("imdb_rating")
    val imdbRating: String,
    val poster: String,
    val title: String,
    val year: String
)
