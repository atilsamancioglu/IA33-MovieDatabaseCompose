package com.atilsamancioglu.moviedatabasecompose.presentation.movie_detail.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.atilsamancioglu.moviedatabasecompose.presentation.movie_detail.MovieDetailViewModel

@Composable
fun MovieDetailScreen(
    movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state = movieDetailViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.movie?.let {
            Text(text = it.Title)
        }
    }
}