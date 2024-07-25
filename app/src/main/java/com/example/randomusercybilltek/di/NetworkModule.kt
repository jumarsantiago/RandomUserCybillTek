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

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providePersonAPI(): PersonAPI {
        return RetrofitInstance.api
    }
}