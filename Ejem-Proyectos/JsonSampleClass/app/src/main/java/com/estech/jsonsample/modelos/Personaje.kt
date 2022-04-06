package com.estech.jsonsample.modelos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Personaje(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val nombrePersonaje: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("origin")
    val origin: Origin,

    @SerializedName("location")
    val location: Location,

    @SerializedName("image")
    val image: String,

    @SerializedName("episode")
    val episode: List<String>,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String

) : Parcelable