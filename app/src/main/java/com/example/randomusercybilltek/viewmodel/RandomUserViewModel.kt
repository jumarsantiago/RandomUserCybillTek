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
import com.example.randomusercybilltek.data.RealPersonRepository
import com.example.randomusercybilltek.data.local.PersonDao
import com.example.randomusercybilltek.model.Results

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val personRepository: PersonRepository,
    private val personDao: PersonDao
) : ViewModel() {
    private val _personList = MutableLiveData<List<Results>>()
    val personList: LiveData<List<Results>> get() = _personList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    fun fetchRandomUsers(page: Int) {
        _isLoading.value = true
        _error.value = null

        viewModelScope.launch {
            try {
                val persons = personRepository.getRandomUsers(page, 10)
                _personList.value = persons
                personRepository.fetchAndSavePersons(page, 10)
                Log.d("RandomUserViewModel", "Fetched ${persons.size} users")
            } catch (e: Exception) {
                _error.value = e.message
                Log.e("RandomUserViewModel", "Error fetching users", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getAllPersons() {
        viewModelScope.launch {
            _personList.postValue(personDao.getAll())
        }
    }
}