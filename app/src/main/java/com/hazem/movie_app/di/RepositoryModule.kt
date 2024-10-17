package com.hazem.movie_app.di

import com.hazem.movie_app.data.network.ApiService
import com.hazem.movie_app.data.repository.MovieRepositoryImp
import com.hazem.movie_app.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(apiService: ApiService): MovieRepository {
        return MovieRepositoryImp(apiService)

    }

}