package com.prasad.moviedb.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prasad.moviedb.data.local.enitity.DiscoverEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface DiscoverDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(discoverEntity: DiscoverEntity)

    @Query("select * from discover")
    fun getAll() : Maybe<List<DiscoverEntity>>


}