package com.example.randomusercybilltek.data

import com.example.randomusercybilltek.data.remote.PersonAPI
import com.example.randomusercybilltek.model.Results
import javax.inject.Inject

class RealPersonRepository @Inject constructor (
    private val personAPI: PersonAPI
) : PersonRepository {

    override suspend fun getRandomUsers(count: Int): List<Results>? {
        return personAPI.getRandomUsers(count).results
    }

}
