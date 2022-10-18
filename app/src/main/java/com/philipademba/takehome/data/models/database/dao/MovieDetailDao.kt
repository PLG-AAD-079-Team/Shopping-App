package com.philipademba.takehome.data.models.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.philipademba.takehome.data.models.database.entities.MovieDetail

@Dao
interface MovieDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetailList(MovieDetails: List<MovieDetail>)

    @Update
    suspend fun updateMovieDetail(MovieDetail: MovieDetail)


    @Query("SELECT * FROM MovieDetail WHERE id = :id_")
    suspend fun getMovieDetail(id_: Long): List<MovieDetail>

}
