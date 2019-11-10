package com.prasad.moviedb.data.remote

import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("=")
    fun getAllDiscover() : Deferred<DiscoverEntity>
}