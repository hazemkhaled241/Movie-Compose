package com.hazem.movie_app.presentation.screen.details.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hazem.movie_app.R
import com.hazem.movie_app.domain.model.MovieDetails

@Composable
fun ImageRow(movieDetails: MovieDetails) {
    if (movieDetails.images.isNotEmpty()) {
        LazyRow {
            items(movieDetails.images.size) {
                AsyncImage(
                    model = movieDetails.images[it], contentDescription = stringResource(id = R.string.movie_image),
                    Modifier
                        .padding(6.dp)
                        .height(70.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}