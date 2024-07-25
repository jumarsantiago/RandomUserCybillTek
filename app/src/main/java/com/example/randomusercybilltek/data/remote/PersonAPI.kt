package com.example.randomusercybilltek.data.remote

import com.example.randomusercybilltek.model.RandomUserModel
import retrofit2.http.GET
import retrofit2.http.Query



interface PersonAPI {

    @GET("api/")
    suspend fun getRandomUsers(
        @Query("results") count: Int
    ): RandomUserModel

}