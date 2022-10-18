package com.philipademba.takehome.data.models.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.philipademba.takehome.data.models.api.movies.SpokenLanguage


open class SpokenLanguageListConverter {
    @TypeConverter
    fun fromString(value: String): List<SpokenLanguage>? {
        val listType = object : TypeToken<List<SpokenLanguage>>() {}.type
        return Gson().fromJson<List<SpokenLanguage>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<SpokenLanguage>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
