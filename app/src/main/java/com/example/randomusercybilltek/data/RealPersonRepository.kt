package com.example.randomusercybilltek.data

import com.example.randomusercybilltek.data.local.PersonDao
import com.example.randomusercybilltek.data.remote.PersonAPI
import com.example.randomusercybilltek.model.Results
import javax.inject.Inject

class RealPersonRepository @Inject constructor (
    private val personDao: PersonDao,
    private val personAPI: PersonAPI
) : PersonRepository {

    override suspend fun getAllPersons(): List<Results> {
        return personDao.getAll()
    }

    suspend fun insertAll(persons: List<Results>) {
        personDao.insertAll(persons)
    }

    suspend fun deleteAll() {
        personDao.deleteAll()
    }

    override suspend fun getRandomUsers(page: Int, count: Int): List<Results> {
        return personAPI.getRandomUsers(page, count).results
    }

    override suspend fun fetchAndSavePersons(page: Int, count: Int) {
        TODO("Not yet implemented")
    }
}
