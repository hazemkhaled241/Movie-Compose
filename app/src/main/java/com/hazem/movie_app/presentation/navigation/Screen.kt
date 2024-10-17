package com.hazem.movie_app.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen(val route :String) {
    @Serializable
    data object SplashScreen
    @Serializable
    data object HomeScreen
    @Serializable
    data class DetailsScreen(val id: Int)

}