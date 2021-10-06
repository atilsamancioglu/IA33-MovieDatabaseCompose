package com.atilsamancioglu.moviedatabasecompose.domain.use_case.get_movies

import com.atilsamancioglu.moviedatabasecompose.data.remote.dto.toMovieList
import com.atilsamancioglu.moviedatabasecompose.domain.model.Movie
import com.atilsamancioglu.moviedatabasecompose.domain.repository.MovieRepository
import com.atilsamancioglu.moviedatabasecompose.util.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository : MovieRepository) {
    //Use case -> only one major public function, one feature, single responsibility
     fun executeGetMovies(search: String) : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList = repository.getMovies(search)
            if(movieList.Response.equals("True")) {
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                emit(Resource.Error(message = "No movie found"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        } catch (e: IOError) {
            emit(Resource.Error(message = "Could not reach internet"))
        }
    }

}