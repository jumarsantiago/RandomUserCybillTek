package com.example.randomusercybilltek.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomusercybilltek.data.PersonRepository
import com.example.randomusercybilltek.data.local.PersonDao
import com.example.randomusercybilltek.model.Results
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Jumar Santiago on 31/07/2024.
 * Copyright 2024
 * All Rights Reserved.
 */

@HiltViewModel
class ProfileVIewModel @Inject constructor(
    private val personRepository: PersonRepository,
    private val personDao: PersonDao
) : ViewModel() {


    private val _person = MutableLiveData<Results>()
    val person: LiveData<Results> get() = _person

    fun getByUID(UID: Int){
        viewModelScope.launch {
            _person.value = personDao.getById(UID)
        }
    }
}