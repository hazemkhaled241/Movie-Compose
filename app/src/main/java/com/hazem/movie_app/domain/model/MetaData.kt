package com.hazem.movie_app.domain.model

import com.google.gson.annotations.SerializedName

data class MetaData(
    @SerializedName("current_page")
    val currentPage: String,
    @SerializedName("page_count")
    val pageCount: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total_count")
    val totalCount: Int
)
