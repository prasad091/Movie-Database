package com.prasad.moviedb.di.module

import com.prasad.moviedb.data.datasource.DiscoverDataSource
import com.prasad.moviedb.data.local.dao.DiscoverDao
import com.prasad.moviedb.data.repository.DiscoverRepo
import com.prasad.moviedb.data.repository.DiscoverRepoImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class,DataSourceModule::class])
class RepositoryModule {
    @Provides
    @Singleton
    internal fun provideRepository(discoverDao: DiscoverDao, discoverDataSource: DiscoverDataSource): DiscoverRepo{
        return DiscoverRepoImp(discoverDao,discoverDataSource)
    }

}