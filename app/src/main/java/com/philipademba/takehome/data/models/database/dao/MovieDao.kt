package com.philipademba.takehome.data.models.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.philipademba.takehome.data.models.database.entities.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieList(movies: List<Movie>)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Query("SELECT * FROM MOVIE WHERE id = :id_")
    suspend fun getMovie(id_: Long): Movie

    @Query("SELECT * FROM Movie WHERE page = :page_")
    suspend fun getMovieList(page_: Int): List<Movie>
}
