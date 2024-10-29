package com.hazem.movie_app.presentation.screen.details.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hazem.movie_app.R
import com.hazem.movie_app.domain.model.MovieDetails

@Composable
fun Rating(movieDetails: MovieDetails) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = stringResource(id = R.string.star_icon),
            tint = Color.White
        )
        Text(
            text = movieDetails.rated,
            Modifier.padding(start = 6.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.width(25.dp))
        Icon(
            painter = painterResource(id = R.drawable.time_24),
            contentDescription = stringResource(R.string.time_icon),
            tint = Color.White
        )
        Text(
            text = movieDetails.runtime,
            Modifier.padding(start = 6.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.width(25.dp))
        Icon(
            imageVector = Icons.Filled.DateRange,
            contentDescription = stringResource(R.string.date_icon),
            tint = Color.White
        )
        Text(
            text = movieDetails.released,
            Modifier.padding(start = 6.dp),
            color = Color.White
        )
    }
}

