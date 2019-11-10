package com.prasad.moviedb.di.module

import androidx.room.Room
import com.prasad.moviedb.MainApplication
import com.prasad.moviedb.data.local.MovieDatabase
import com.prasad.moviedb.data.local.dao.DiscoverDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: MainApplication): MovieDatabase {
        return Room.databaseBuilder(application, MovieDatabase::class.java, "movie-db.db").build()
    }

    @Singleton
    @Provides
    fun provideMovieDiscoverDao(database: MovieDatabase): DiscoverDao = database.discoverDao()


}