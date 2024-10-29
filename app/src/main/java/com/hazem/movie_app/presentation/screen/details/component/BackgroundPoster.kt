package com.hazem.movie_app.presentation.screen.details.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hazem.movie_app.R
import com.hazem.movie_app.domain.model.MovieDetails

@Composable
fun BackgroundPoster(poster: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray)
        ) {
            AsyncImage(
                model = poster, contentDescription = stringResource(id = R.string.movie_poster),
                modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.6f)
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.DarkGray
                            )
                        ),
                        shape = RoundedCornerShape(16.dp)
                    )
            )
        }
    }
}