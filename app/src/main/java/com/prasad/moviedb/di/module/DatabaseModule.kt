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
    @Provides
    @Singleton
    fun provideDatabase(application: MainApplication): MovieDatabase {

        return Room.databaseBuilder(application, MovieDatabase::class.java, "movie-db.db").build()
    }

    /*
 * We need the CurrentWeather module.
 * For this, We need the AppDatabase object
 * So we will define the providers for this here in this module.
 * */
    @Provides
    @Singleton
    fun provideAllDiscoverDao(appDatabase: MovieDatabase): DiscoverDao {
        return appDatabase.currentDiscoverList()
    }

}