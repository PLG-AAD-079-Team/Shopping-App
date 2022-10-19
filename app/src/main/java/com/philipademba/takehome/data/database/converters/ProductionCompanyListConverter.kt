package com.philipademba.takehome.data.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.philipademba.takehome.data.models.api.moviedetail.ProductionCompanyResponse

open class ProductionCompanyListConverter {
    @TypeConverter
    fun fromString(value: String): List<ProductionCompanyResponse>? {
        val listType = object : TypeToken<List<ProductionCompanyResponse>>() {}.type
        return Gson().fromJson<List<ProductionCompanyResponse>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<ProductionCompanyResponse>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
