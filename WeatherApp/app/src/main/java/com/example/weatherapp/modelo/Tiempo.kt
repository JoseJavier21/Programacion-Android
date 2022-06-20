package com.example.weatherapp


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class modelo(
    @SerializedName("location")
    val location: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("local_time")
    val localTime: String?,
    @SerializedName("forecast")
    val forecast: List<Forecast?>?
) : Parcelable