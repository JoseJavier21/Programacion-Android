package com.estech.retrofitsample.modelos


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Respuesta(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Personaje>
) : Parcelable