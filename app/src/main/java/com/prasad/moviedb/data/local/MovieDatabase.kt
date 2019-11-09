package com.prasad.moviedb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prasad.moviedb.data.local.dao.DiscoverDao
import com.prasad.moviedb.data.local.enitity.DiscoverEntity

@Database(entities = [DiscoverEntity::class],exportSchema= false, version = 1)
abstract class MovieDatabase  : RoomDatabase() {
    abstract fun currentDiscoverList(): DiscoverDao

}