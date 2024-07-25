package com.example.randomusercybilltek.data.local

import androidx.room.TypeConverter
import com.example.randomusercybilltek.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromName(name: Name): String? {
        return Gson().toJson(name)
    }

    @TypeConverter
    fun toName(name: String): Name {
        return Gson().fromJson(name, Name::class.java)
    }

    @TypeConverter
    fun fromLocation(location: Location): String {
        return Gson().toJson(location)
    }

    @TypeConverter
    fun toLocation(location: String): Location {
        return Gson().fromJson(location, Location::class.java)
    }

    @TypeConverter
    fun fromCoordinates(coordinates: Coordinates): String {
        return Gson().toJson(coordinates)
    }

    @TypeConverter
    fun toCoordinates(coordinatesString: String): Coordinates {
        val coordinatesType = object : TypeToken<Coordinates>() {}.type
        return Gson().fromJson(coordinatesString, coordinatesType)
    }

    @TypeConverter
    fun fromStreet(street: Street): String {
        return Gson().toJson(street)
    }

    @TypeConverter
    fun toStreet(streetString: String): Street {
        val streetType = object : TypeToken<Street>() {}.type
        return Gson().fromJson(streetString, streetType)
    }

    @TypeConverter
    fun fromTimezone(timezone: Timezone): String {
        return Gson().toJson(timezone)
    }

    @TypeConverter
    fun toTimezone(timezoneString: String): Timezone {
        val timezoneType = object : TypeToken<Timezone>() {}.type
        return Gson().fromJson(timezoneString, timezoneType)
    }

}
