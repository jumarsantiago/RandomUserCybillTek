package com.example.randomusercybilltek.data

import androidx.lifecycle.LiveData
import com.example.randomusercybilltek.model.Results

interface PersonRepository {
    suspend fun getRandomUsers(page: Int, count: Int): List<Results>
    suspend fun fetchAndSavePersons(page: Int, count: Int)
    suspend fun getAllPersons(): List<Results>
}
