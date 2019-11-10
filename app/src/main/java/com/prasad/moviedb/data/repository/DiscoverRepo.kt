package com.prasad.moviedb.data.repository

import androidx.lifecycle.LiveData
import com.prasad.moviedb.data.local.enitity.DiscoverEntity

interface DiscoverRepo {
    suspend fun getAllDiscoverList() : LiveData<DiscoverEntity>
}