package com.example.randomusercybilltek.data

import androidx.lifecycle.LiveData
import com.example.randomusercybilltek.model.Results

interface PersonRepository {
    suspend fun getRandomUsers(count: Int): List<Results>?
}
