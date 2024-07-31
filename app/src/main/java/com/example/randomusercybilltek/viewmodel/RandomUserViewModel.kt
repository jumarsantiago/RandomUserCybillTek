package com.example.randomusercybilltek.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.ViewModel
import com.example.randomusercybilltek.data.PersonRepository
import com.example.randomusercybilltek.data.local.PersonDao
import com.example.randomusercybilltek.model.Results

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val personRepository: PersonRepository,
    private val personDao: PersonDao
) : ViewModel() {
    private val _personList = MutableLiveData<List<Results>?>()
    val personList: LiveData<List<Results>?> get() = _personList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        fetchRandomUsers()
    }

    fun fetchRandomUsers() {
        _isLoading.value = true
        _error.value = null
        viewModelScope.launch {
            try {
                val persons = personRepository.getRandomUsers(10)
                if (!persons.isNullOrEmpty()) {
                    personDao.insertAll(persons)
                    _personList.value = personDao.getAll()
                    Log.d("RandomUserViewModel", "Fetched ${persons.size} users")
                }else{
                    _error.value = "No users fetched"
                }
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("RandomUserViewModel", "Error fetching users", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getGender(gender: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                if (gender == "all") {
                    _personList.value = personDao.getAll()
                    return@launch
                }else {
                    val filterPersons = personList.value?.filter { it.gender == gender }
                    _personList.value = filterPersons
                }
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("RandomUserViewModel", "Error fetching users", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun refreshUsers() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                personDao.deleteAll()
                fetchRandomUsers()
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("RandomUserViewModel", "Error refreshing users", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}
