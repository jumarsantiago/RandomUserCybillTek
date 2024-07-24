package com.example.randomusercybilltek.di

import com.example.randomusercybilltek.data.PersonRepository
import com.example.randomusercybilltek.data.RealPersonRepository
import com.example.randomusercybilltek.data.remote.PersonAPI
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Jumar Santiago on 23/07/2024.
 * Copyright 2022 Yondu
 * All Rights Reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providePersonAPI(): PersonAPI {
        return RetrofitInstance.api
    }
}