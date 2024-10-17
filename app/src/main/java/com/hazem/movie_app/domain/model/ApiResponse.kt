package com.hazem.movie_app.domain.model

import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @SerializedName("data")
    val movies:List<Movie> = emptyList(),
    val metadata: MetaData
)
