package com.philipademba.takehome.di.modules.movies

import android.content.Context
import androidx.room.Room
import com.philipademba.takehome.data.database.AppDatabase
import com.philipademba.takehome.data.database.dao.MovieDao
import com.philipademba.takehome.data.database.dao.MovieDetailDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "movies.db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideMovieDetailsDao(appDatabase: AppDatabase): MovieDetailDao {
        return appDatabase.movieDetailDao()
    }
}
