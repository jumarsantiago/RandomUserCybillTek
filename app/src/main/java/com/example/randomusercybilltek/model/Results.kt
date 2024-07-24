package com.example.randomusercybilltek.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Results(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val gender: String,
    val email: String,
    val phone: String,
    val cell: String,
    val nat: String,
    val first: String,
    val last: String,
    val title: String,
    val city: String,
    val country: String,
    val postcode: Int,
    val state: String,
    val street: String,
    val coordinates: String,
    val timezone: String,
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String,
    val age: Int,
    val date: String,
    val ageR: Int,
    val dateR: String,
    val large: String,
    val medium: String,
    val thumbnail: String
)
