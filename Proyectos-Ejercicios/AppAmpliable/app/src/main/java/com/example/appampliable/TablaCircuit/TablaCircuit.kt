package com.example.appampliable.TablaCircuit

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TablaCircuit(
    var nombre: String,
    var ciudad: String,
    var pais: String,
    var direccion: String,
    var numero: Int,
    var pregunta: Boolean,
    val imagen: String?,
    val latitud: Double,
    val longitud: Double,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
