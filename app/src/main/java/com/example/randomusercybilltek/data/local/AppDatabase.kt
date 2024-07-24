package com.example.randomusercybilltek.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.randomusercybilltek.model.Results

@Database(entities = [Results::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
}
