package com.hazem.movie_app.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hazem.movie_app.presentation.screen.home.component.MovieItem
import com.hazem.movie_app.presentation.screen.home.component.TopBar

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: MovieViewModel = hiltViewModel()) {
    val movies = homeViewModel.screenState.value.data
    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        topBar = { TopBar() },
        containerColor = Color.Transparent
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.Transparent)

        ) {
            items(movies.size) { index ->
                MovieItem(navController = navController, movie = movies[index])
            }
        }
    }

}