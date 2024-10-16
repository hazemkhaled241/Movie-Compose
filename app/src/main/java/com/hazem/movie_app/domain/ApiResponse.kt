package com.hazem.movie_app.domain

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val movies:List<Movie> = emptyList(),
    val success:Boolean,
    val message:String?=null,
    val currentPage: String?=null,
    val pageCount: Int?=null,
    val prevPage: Int?=null,
    val totalCount: Int?=null
)
