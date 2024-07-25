package com.example.randomusercybilltek.model

//@Entity(tableName = "person_table")
//@TypeConverters(Converter::class)

data class Results(
    val gender: String,
    val name: Name? = null,
    val location: Location? = null,
    val email: String,
    val login: Login? = null,
    val dob: Dob? = null,
    val registered: Registered? = null,
    val phone: String,
    val cell: String,
    val id: Id? = null,
    val picture: Picture? = null,
    val nat: String
)
