package com.example.appampliable.TablaCircuit

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Circuitos")
data class TablaCircuit(
    var nombre: String,
    var ciudad: String,
    var pais: String,
    var numero: Int,
    var pregunta: Boolean,
    val imagen: Bitmap
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}