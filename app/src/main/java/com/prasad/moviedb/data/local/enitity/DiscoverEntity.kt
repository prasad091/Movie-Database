package com.prasad.moviedb.data.local.enitity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "discover")
data class DiscoverEntity(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id: Int = 0
)