package com.example.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ListConverter {

    private val gson = Gson()

    @TypeConverter
    fun entityListToJsonList(entityList: List<String>): String = gson.toJson(entityList)

    @TypeConverter
    fun jsonListToEntityList(jsonList: String): List<String> = gson.fromJson(jsonList, object : TypeToken<List<String>>() {}.type)
}
