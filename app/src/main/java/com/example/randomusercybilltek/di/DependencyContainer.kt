package com.example.randomusercybilltek.di

import android.content.Context
import androidx.room.Room
import com.example.randomusercybilltek.data.PersonRepository
import com.example.randomusercybilltek.data.RealPersonRepository
import com.example.randomusercybilltek.data.local.AppDatabase
import com.example.randomusercybilltek.data.local.PersonDao
import com.example.randomusercybilltek.data.remote.PersonAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DependencyContainer {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providePersonDao(database: AppDatabase): PersonDao {
        return database.personDao()
    }

    @Provides
    @Singleton
    fun providePersonRepository(personAPI: PersonAPI, personDao: PersonDao): PersonRepository {
        return RealPersonRepository(personDao, personAPI)
    }

}