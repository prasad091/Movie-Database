package com.prasad.moviedb.data.remote

import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import com.prasad.moviedb.data.repository.DiscoverDataSource
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : DiscoverDataSource {

    override fun saveAllDiscoverMovies(discover: List<DiscoverEntity>) {
    }

    override fun getAllDiscoverMovies(): Flowable<List<DiscoverEntity>> {
       return apiService.getAllDiscover().toList().toFlowable()
    }




}