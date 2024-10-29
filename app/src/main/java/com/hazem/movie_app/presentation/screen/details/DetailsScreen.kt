@file:JvmName("DetailsViewModelKt")

package com.hazem.movie_app.presentation.screen.details

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hazem.movie_app.presentation.screen.details.component.BackgroundPoster
import com.hazem.movie_app.presentation.screen.details.component.ForegroundPoster
import com.hazem.movie_app.presentation.screen.details.component.ImageRow
import com.hazem.movie_app.presentation.screen.details.component.Rating
import com.hazem.movie_app.presentation.screen.details.component.TextBuilder

@Composable
fun DetailsScreen(
    id: Int,
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    detailsViewModel.movieId = id
    val state = detailsViewModel.movieDetailsState.value
    detailsViewModel.getMovieDetails(id)
    if (state.error.isNullOrBlank()) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundPoster(poster = state.data.poster)

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(start = 20.dp, end = 20.dp, bottom = 50.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {

                ForegroundPoster(poster = state.data.poster)

                Rating(movieDetails = state.data)
                TextBuilder(
                    icon = Icons.Filled.Info,
                    title = "Summery:",
                    bodyText = state.data.plot
                )
                TextBuilder(
                    icon = Icons.Filled.Person,
                    title = "Actors:",
                    bodyText = state.data.actors
                )
                ImageRow(movieDetails = state.data)
            }
        }
    }
}