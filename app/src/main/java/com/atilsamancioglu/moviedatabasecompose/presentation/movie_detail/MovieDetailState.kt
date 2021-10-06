package com.atilsamancioglu.moviedatabasecompose.presentation.movie_detail

import com.atilsamancioglu.moviedatabasecompose.domain.model.Movie
import com.atilsamancioglu.moviedatabasecompose.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading : Boolean = false,
    val movie : MovieDetail? = null,
    val error : String = ""
)