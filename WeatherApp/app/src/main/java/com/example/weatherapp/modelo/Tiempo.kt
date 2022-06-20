package com.example.weatherapp.modelo


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.modelo.Forecast

@Parcelize
data class Tiempo(

    val location: String?,

    val region: String?,

    @SerializedName("pais")
    val country: String?,

    val latitude: Double?,

    val longitude: Double?,

    val timezone: String?,

    val localTime: String?,

    val forecast: List<Forecast?>?
): Parcelable