package com.philipademba.takehome.data.models.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.philipademba.takehome.data.models.database.converters.GenreListConverter
import com.philipademba.takehome.data.models.database.converters.IntegerListConverter
import com.philipademba.takehome.data.models.database.converters.ProductionCompanyListConverter
import com.philipademba.takehome.data.models.database.converters.SpokenLanguageListConverter
import com.philipademba.takehome.data.models.database.dao.MovieDao
import com.philipademba.takehome.data.models.database.dao.MovieDetailDao
import com.philipademba.takehome.data.models.database.entities.Movie
import com.philipademba.takehome.data.models.database.entities.MovieDetail
import com.skydoves.moviecompose.persistence.converters.StringListConverter


@Database(
    entities = [(Movie::class), MovieDetail::class],
    version = 2, exportSchema = false
)
@TypeConverters(
    value = [
        StringListConverter::class,
        IntegerListConverter::class,
        GenreListConverter::class,
        ProductionCompanyListConverter::class,
        SpokenLanguageListConverter::class
    ]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieDetailDao(): MovieDetailDao
}
