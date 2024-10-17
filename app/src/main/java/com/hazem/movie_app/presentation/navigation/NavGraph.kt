package com.hazem.movie_app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.hazem.movie_app.presentation.screen.details.DetailsScreen
import com.hazem.movie_app.presentation.screen.home.HomeScreen
import com.hazem.movie_app.presentation.screen.splash.SplashScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.HomeScreen) {
        composable<Screen.SplashScreen> {
            SplashScreen(navController)
        }

        composable<Screen.HomeScreen> {
            HomeScreen(navController)
        }

        composable<Screen.DetailsScreen> {
            val argument=it.toRoute<Screen.DetailsScreen>()
            DetailsScreen(argument.id,navController)
        }
    }

}