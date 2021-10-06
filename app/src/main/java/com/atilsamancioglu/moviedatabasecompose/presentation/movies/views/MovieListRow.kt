package com.atilsamancioglu.moviedatabasecompose.presentation.movies.views

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.atilsamancioglu.moviedatabasecompose.domain.model.Movie
import org.intellij.lang.annotations.JdkConstants

@Composable
fun MovieListRow(
    movie : Movie,
    onItemClick : (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(movie) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Image(painter = rememberImagePainter(data = movie.Poster),
            contentDescription = movie.Title,
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp, 200.dp)
                .clip(RectangleShape)
        )

        Column(modifier = Modifier.align(CenterVertically),horizontalAlignment = Alignment.CenterHorizontally) {
            Text(movie.Title,
                style = MaterialTheme.typography.h5,
                overflow = TextOverflow.Ellipsis,
                color = White,
                textAlign = TextAlign.Center
            )

            Text(movie.Year,
                style = MaterialTheme.typography.h6,
                overflow = TextOverflow.Ellipsis,
                color = White,
                textAlign = TextAlign.Center
            )

        }


    }
}