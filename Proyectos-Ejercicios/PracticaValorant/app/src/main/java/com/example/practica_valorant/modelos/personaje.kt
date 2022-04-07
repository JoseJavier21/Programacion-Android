package com.example.practica_valorant.modelos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class personaje
    (val displayname: String,
     val description: String): Parcelable
