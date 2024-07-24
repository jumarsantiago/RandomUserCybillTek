package com.example.randomusercybilltek.data.remote

import com.example.randomusercybilltek.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Jumar Santiago on 19/07/2024.
 * Copyright 2022 Yondu
 * All Rights Reserved.
 */
interface PersonAPI {

    @GET("/api/")
    suspend fun getRandomUsers(
        @Query("page") page: Int,
        @Query("results") count: Int
    ): UserModel

}