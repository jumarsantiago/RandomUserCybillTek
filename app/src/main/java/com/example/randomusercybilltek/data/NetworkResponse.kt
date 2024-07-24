package com.example.randomusercybilltek.data

/**
 * Created by Jumar Santiago on 19/07/2024.
 * Copyright 2022 Yondu
 * All Rights Reserved.
 */
sealed class NetworkResponse<out T> {
    data object Loading: NetworkResponse<Nothing>()
    data class Success<out T>(val data : T): NetworkResponse<T>()
    data class Error(val message: String): NetworkResponse<Nothing>()
}