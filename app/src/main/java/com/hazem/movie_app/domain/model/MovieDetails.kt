package com.hazem.movie_app.domain.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val actors: String = "",
    val awards: String = "",
    val country: String = "",
    val director: String = "",
    val genres: List<String> = emptyList(),
    val id: Int = 0,
    val images: List<String> = emptyList(),
    @SerializedName("imdb_id")
    val imdbId: String = "",
    @SerializedName("imdb_rating")
    val imdbRating: String = "",
    @SerializedName("imdb_votes")
    val imdbVotes: String = "",
    @SerializedName("metascore")
    val metaScore: String = "",
    val plot: String = "",
    val poster: String = "",
    val rated: String = "",
    val released: String = "",
    val runtime: String = "",
    val title: String = "",
    val type: String = "",
    val writer: String = "",
    val year: String = ""

)
