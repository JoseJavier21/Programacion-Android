package com.example.practica_valorant.modelos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Personaje(

    val dispayName : String,

    @SerializedName("name")
    val nombrePersonaje : String,

    @SerializedName("gender")
    val gender : String,

    @SerializedName("image")
    val image : String,



) : Parcelable