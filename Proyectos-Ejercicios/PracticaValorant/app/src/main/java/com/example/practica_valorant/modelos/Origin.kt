package com.example.practica_valorant.modelos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Origin(
    val name: String,
    val url: String,
): Parcelable