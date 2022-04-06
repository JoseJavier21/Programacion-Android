package com.example.proyectofinal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListPilot(

    val nombre: String,
    val apellido: String,
    val edad: Int,
    val nacionalidad: String,
    val equipo: String,
    val numero: Int,
    val insta: String,

): Parcelable