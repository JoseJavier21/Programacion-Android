package com.estech.retrofitsample.modelos


import com.google.gson.annotations.SerializedName

data class Respuesta(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<Respuesta>
)