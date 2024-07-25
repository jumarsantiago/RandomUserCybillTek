package com.example.randomusercybilltek.data


sealed class NetworkResponse<out T> {
    data object Loading: NetworkResponse<Nothing>()
    data class Success<out T>(val data : T): NetworkResponse<T>()
    data class Error(val message: String): NetworkResponse<Nothing>()
}