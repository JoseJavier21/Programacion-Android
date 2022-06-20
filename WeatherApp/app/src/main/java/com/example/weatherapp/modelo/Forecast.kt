package com.example.weatherapp


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Forecast(
    @SerializedName("date")
    val date: String?,
    @SerializedName("max_temp_c")
    val maxTempC: Double?,
    @SerializedName("max_temp_f")
    val maxTempF: Double?,
    @SerializedName("min_temp_c")
    val minTempC: Double?,
    @SerializedName("min_temp_f")
    val minTempF: Double?,
    @SerializedName("avg_temp_c")
    val avgTempC: Double?,
    @SerializedName("avg_temp_f")
    val avgTempF: Double?,
    @SerializedName("will_it_rain")
    val willItRain: Boolean?,
    @SerializedName("chance_of_rain")
    val chanceOfRain: Int?,
    @SerializedName("condition")
    val condition: String?,
    @SerializedName("icon_url")
    val iconUrl: String?,
    @SerializedName("sunrise")
    val sunrise: String?,
    @SerializedName("sunset")
    val sunset: String?,
    @SerializedName("max_wind_mph")
    val maxWindMph: Double?,
    @SerializedName("max_wind_kph")
    val maxWindKph: Double?
) : Parcelable