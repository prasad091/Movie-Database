package com.prasad.moviedb.data.local.enitity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

import com.google.gson.annotations.SerializedName
import com.prasad.moviedb.data.local.enitity.model.Results
import com.prasad.moviedb.util.Converter

@Entity(tableName = "discover")
@TypeConverters(Converter::class)
data class DiscoverEntity(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id") val id: Int = 0,
    @SerializedName("page") val page : Int,
    @SerializedName("total_results") val total_results : Int,
    @SerializedName("total_pages") val total_pages : Int,
    @TypeConverters(Converter::class)
    @SerializedName("results") val results : List<Results> = emptyList()
)