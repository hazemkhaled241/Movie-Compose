package com.hazem.movie_app.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen(val route :String) {
    @Serializable
    data object BannerScreen
    @Serializable
    data object HomeScreen
    @Serializable
    data class DetailsScreen(val id: Int)

}