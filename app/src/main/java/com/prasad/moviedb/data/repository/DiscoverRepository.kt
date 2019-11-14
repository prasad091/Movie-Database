package com.prasad.moviedb.data.repository

import com.kotlin.mvvm.boilerplate.di.qualifier.LocalData
import com.kotlin.mvvm.boilerplate.di.qualifier.RemoteData
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverRepository @Inject constructor(
    @LocalData private val localDataSource: DiscoverDataSource,
    @RemoteData private val remoteDataSource: DiscoverDataSource
) : DiscoverDataSource {
    override fun saveAllDiscoverMovies(discover: List<DiscoverEntity>) {
        localDataSource.saveAllDiscoverMovies(discover)
        remoteDataSource.saveAllDiscoverMovies(discover)
    }


    private var cachedDiscover = listOf<DiscoverEntity>()

    private var cacheDiscoverIsDirty = false

    override fun getAllDiscoverMovies(): Flowable<List<DiscoverEntity>> {

        if (cachedDiscover.isNotEmpty() && !cacheDiscoverIsDirty) {
            return Flowable.just(cachedDiscover)
        }

        val remoteDiscover = getAndSaveRemoteDiscover()

        return if (cacheDiscoverIsDirty) remoteDiscover else {
            val localDiscover = getAndCacheLocalDiscover()
            Flowable.concat(localDiscover, remoteDiscover)
        }
    }

    private fun getAndSaveRemoteDiscover(): Flowable<List<DiscoverEntity>> {
        return remoteDataSource.getAllDiscoverMovies()
            .doOnNext { discover ->
                localDataSource.saveAllDiscoverMovies(discover)
                cachedDiscover = discover
            }.doOnComplete {
                cacheDiscoverIsDirty = false
            }
    }

    private fun getAndCacheLocalDiscover(): Flowable<List<DiscoverEntity>> {
        return localDataSource.getAllDiscoverMovies().doOnNext { discover -> cachedDiscover = discover }
    }


}