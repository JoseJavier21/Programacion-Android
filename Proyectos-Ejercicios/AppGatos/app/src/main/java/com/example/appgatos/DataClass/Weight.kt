package com.example.appgatos.DataClass


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Weight(
    @SerializedName("imperial")
    val imperial: String,
    @SerializedName("metric")
    val metric: String
) : Parcelable