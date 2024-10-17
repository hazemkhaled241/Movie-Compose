package com.hazem.movie_app.presentation.screen.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: MovieViewModel = hiltViewModel()) {


    Log.d("hhh", homeViewModel.screenState.value.data.toString())

}