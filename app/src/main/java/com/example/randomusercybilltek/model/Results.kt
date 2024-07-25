package com.example.randomusercybilltek.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.randomusercybilltek.data.local.Converter

@Entity(tableName = "person_table")
@TypeConverters(Converter::class)
data class Results(
    @PrimaryKey(autoGenerate = true) val UID: Int = 0,
    val cell: String?,
    val email: String?,
    val gender: String?,
    val value: String?,
    //val id: Id? = null,
    val location: Location? = null,
    val name: Name? = null,
    val nat: String?,
    val phone: String?,
    //val picture: Picture? = null,
   // val registered: Registered? = null
)