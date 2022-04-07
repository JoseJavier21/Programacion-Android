package com.example.practica_valorant

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Personaje(
    val displayName: String,
    val description: String): Parcelable