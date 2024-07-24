package com.example.randomusercybilltek.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randomusercybilltek.model.Results

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    suspend fun getAll(): List<Results>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(persons: List<Results>)

    @Query("DELETE FROM person_table")
    suspend fun deleteAll()
}