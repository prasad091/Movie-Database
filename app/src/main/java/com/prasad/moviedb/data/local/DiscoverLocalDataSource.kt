package com.prasad.moviedb.data.local

import com.prasad.moviedb.data.local.dao.DiscoverDao
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import com.prasad.moviedb.data.repository.DiscoverDataSource

import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverLocalDataSource @Inject constructor(
    private val discoverDao: DiscoverDao
) : DiscoverDataSource {

    override fun getAllDiscoverMovies(): Flowable<List<DiscoverEntity>> {
        return discoverDao.getAll().toFlowable()
    }

    override fun saveAllDiscoverMovies(discover: List<DiscoverEntity>) {
        discover.map { discoverDao.upsert(it) }
    }


}


