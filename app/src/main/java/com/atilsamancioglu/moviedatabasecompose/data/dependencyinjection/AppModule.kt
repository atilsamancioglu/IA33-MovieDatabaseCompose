package com.atilsamancioglu.moviedatabasecompose.data.dependencyinjection

import com.atilsamancioglu.moviedatabasecompose.data.remote.MovieAPI
import com.atilsamancioglu.moviedatabasecompose.data.repository.MovieRepositoryImpl
import com.atilsamancioglu.moviedatabasecompose.domain.repository.MovieRepository
import com.atilsamancioglu.moviedatabasecompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi() : MovieAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api : MovieAPI) : MovieRepository {
        return MovieRepositoryImpl(api = api)
    }
}