package com.prasad.moviedb.data.repository

import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import io.reactivex.Flowable

interface DiscoverDataSource {
    fun getAllDiscoverMovies(): Flowable<List<DiscoverEntity>>
    fun saveAllDiscoverMovies(discover: List<DiscoverEntity>)
}