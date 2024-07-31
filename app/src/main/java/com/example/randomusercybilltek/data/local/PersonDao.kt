package com.example.randomusercybilltek.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.randomusercybilltek.model.Results

@Dao
interface PersonDao {
    @Query("SELECT * FROM person_table")
    suspend fun getAll(): List<Results>

    @Query("SELECT * FROM person_table WHERE UID = :UID")
    suspend fun getById(UID: kotlin.Int): Results

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(persons: List<Results>)

    @Query("DELETE FROM person_table")
    suspend fun deleteAll()
}
