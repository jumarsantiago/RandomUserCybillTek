package com.example.randomusercybilltek.di

import com.example.randomusercybilltek.data.remote.PersonAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://randomuser.me/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: PersonAPI by lazy {
        retrofit.create(PersonAPI::class.java)
    }
}
