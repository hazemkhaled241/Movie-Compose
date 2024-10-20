package com.hazem.movie_app.presentation.screen.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.hazem.movie_app.R
import com.hazem.movie_app.domain.model.Movie

@Composable
fun MovieItem(navController: NavHostController, movie: Movie) {

    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable { },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = movie.poster,
                contentDescription = stringResource(R.string.movie_image),
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .background(Color.LightGray.copy(0.7f))
                    .padding(6.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color(0xFFFC5A03),
                            offset = Offset(1f, 1f),
                            blurRadius = 3f
                        )
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))

                Row (modifier = Modifier.align(Alignment.End)){
                    Icon(imageVector = Icons.Default.Star, contentDescription = stringResource(R.string.star_icon))

                    Text(
                        text = movie.imdbRating,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        maxLines = 2,

                    )
                }
            }
        }
    }
}