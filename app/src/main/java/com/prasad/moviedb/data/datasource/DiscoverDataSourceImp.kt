package com.prasad.moviedb.data.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import com.prasad.moviedb.data.remote.ApiService
import javax.inject.Inject


class DiscoverDataSourceImp @Inject constructor(private val apiService: ApiService) : DiscoverDataSource {
    // its used for pass fetched data to fetchedAllPoke
    private val mFetchedDiscover = MutableLiveData<DiscoverEntity>()

    override suspend fun fetchCurrentAllDiscover() {
        try {
            val fetchedData = apiService.getAllDiscover().await()
            mFetchedDiscover.postValue(fetchedData)
        } catch (e: Exception) {
            Log.e("connectivity", "No internet connection" + e.toString())
        }
    }

    override val fetchedAllDisover: LiveData<DiscoverEntity>
        get() = mFetchedDiscover
}