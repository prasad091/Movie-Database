package com.prasad.moviedb.data.datasource

import androidx.lifecycle.LiveData
import com.prasad.moviedb.data.local.enitity.DiscoverEntity

interface DiscoverDataSource {
    val fetchedAllDisover: LiveData<DiscoverEntity>
    suspend fun fetchCurrentAllDiscover()
}