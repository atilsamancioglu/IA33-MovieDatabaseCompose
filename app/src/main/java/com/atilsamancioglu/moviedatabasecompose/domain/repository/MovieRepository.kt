package com.atilsamancioglu.moviedatabasecompose.domain.repository

import com.atilsamancioglu.moviedatabasecompose.data.remote.dto.MovieDetailDto
import com.atilsamancioglu.moviedatabasecompose.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search : String) : MoviesDto

    suspend fun getMovieDetail(imdbId : String) : MovieDetailDto


}