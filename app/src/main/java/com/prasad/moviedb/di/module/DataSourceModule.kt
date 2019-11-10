package com.prasad.moviedb.di.module

import com.prasad.moviedb.data.datasource.DiscoverDataSource
import com.prasad.moviedb.data.datasource.DiscoverDataSourceImp
import com.prasad.moviedb.data.remote.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Provides
    @Singleton
    internal fun provideDataSource(apiService: ApiService): DiscoverDataSource{
        return DiscoverDataSourceImp(apiService)
    }

}