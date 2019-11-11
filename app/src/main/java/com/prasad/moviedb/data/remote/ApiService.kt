package com.prasad.moviedb.data.remote

import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie?api_key=4bd6afa311f3c79cb8eade8b62809cba&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1")
    fun getAllDiscover() : Flowable<DiscoverEntity>
}