package com.atilsamancioglu.moviedatabasecompose.data.remote

import com.atilsamancioglu.moviedatabasecompose.data.remote.dto.MovieDetailDto
import com.atilsamancioglu.moviedatabasecompose.data.remote.dto.MoviesDto
import com.atilsamancioglu.moviedatabasecompose.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString :String,
        @Query("apikey") apiKey :String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey: String = API_KEY
    ) : MovieDetailDto

}