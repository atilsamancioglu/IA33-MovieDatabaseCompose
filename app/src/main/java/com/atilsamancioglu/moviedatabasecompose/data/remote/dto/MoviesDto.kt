package com.atilsamancioglu.moviedatabasecompose.data.remote.dto

import com.atilsamancioglu.moviedatabasecompose.domain.model.Movie

data class MoviesDto(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)

fun MoviesDto.toMovie() : Movie {
    return Movie(
        Poster = Search[0].Poster,
        Title = Search[0].Title,
        Year = Search[0].Year,
        imdbID = Search[0].imdbID
    )
}