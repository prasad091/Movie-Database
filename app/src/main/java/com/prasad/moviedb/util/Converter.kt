package com.prasad.moviedb.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.prasad.moviedb.data.local.enitity.model.Results

class Converter {
    private val gson = Gson()
    private val type = object : TypeToken<List<Results>>() {
    }.type

    @TypeConverter
    fun stringToNestedData(json: String): List<Results> {
        return gson.fromJson<List<Results>>(json, type)
    }

    @TypeConverter
    fun nestedDataToString(nestedData: List<Results>): String {
        return gson.toJson(nestedData, type)
    }
}