package com.prasad.moviedb.di.module

import com.prasad.moviedb.di.qualifier.LocalData
import com.prasad.moviedb.di.qualifier.RemoteData
import com.prasad.moviedb.data.local.DiscoverLocalDataSource
import com.prasad.moviedb.data.remote.MovieRemoteDataSource
import com.prasad.moviedb.data.repository.DiscoverDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    @LocalData
    abstract fun bindDiscoverLocalDataSource(discoverLocalDataSource: DiscoverLocalDataSource): DiscoverDataSource

    @Singleton
    @Binds
    @RemoteData
    abstract fun bindMovieRemoteDataSource(movieRemoteDataSource: MovieRemoteDataSource): DiscoverDataSource

}