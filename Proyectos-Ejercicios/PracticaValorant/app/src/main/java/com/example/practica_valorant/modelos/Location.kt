package com.example.practica_valorant.modelos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Location(
    val name: String,
    val url: String,
): Parcelable