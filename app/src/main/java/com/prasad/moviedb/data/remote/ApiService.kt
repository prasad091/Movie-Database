package com.prasad.moviedb.data.remote

import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("=")
    fun getAllDiscover() : Flowable<DiscoverEntity>
}