package com.atilsamancioglu.moviedatabasecompose.presentation.movies

import com.atilsamancioglu.moviedatabasecompose.domain.model.Movie

data class MoviesState(
    val isLoading : Boolean = false,
    val movies : List<Movie> = emptyList(),
    val error : String = "",
    val search : String = "batman"
)