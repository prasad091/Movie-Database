package com.prasad.moviedb.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.prasad.moviedb.data.datasource.DiscoverDataSource
import com.prasad.moviedb.data.local.dao.DiscoverDao
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverRepoImp @Inject constructor(private val allDiscoverDao: DiscoverDao, private val discoverDataSource: DiscoverDataSource) : DiscoverRepo {
    override suspend fun getAllDiscoverList(): LiveData<DiscoverEntity> {
        return withContext(Dispatchers.IO){
            initDiscoverData()
            allDiscoverDao.getAll()
        }
    }



    init {
        //observeForever because PokeRepoImp has no lifecycle
        discoverDataSource.fetchedAllDisover.observeForever { recentlyFetched->
            //persist
            persistFetchedPoke(recentlyFetched)
        }
    }

    private suspend fun initDiscoverData() {
        val lastFetchAllPoke = allDiscoverDao.getAll().value

        //todo add time difference to condition
        if (lastFetchAllPoke == null) {
            fetchAllPoke()
            return
        }

//        if (isFetchNeeded(lastFetchAllPoke.zonedDatedTime)) {
//            getAllPoke()
//        }
    }

    private suspend fun fetchAllPoke(){
        discoverDataSource.fetchCurrentAllDiscover()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun isFetchNeeded(lastFetchedTime: ZonedDateTime) : Boolean{
        val thirtyMinsAgo = ZonedDateTime.now().minusMinutes(30)
        return lastFetchedTime.isBefore(thirtyMinsAgo)
    }

    private fun persistFetchedPoke(discoverEntity: DiscoverEntity) {
        // GlobalScope for coroutine. We use GlobalScope because this class different from fragments. This class has no lifecycle
        GlobalScope.launch(Dispatchers.IO) {
            allDiscoverDao.upsert(discoverEntity)
        }
    }

}