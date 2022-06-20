package com.example.weatherapp.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class variables(
    val temp: Double,
    val hora: String,
    val tiempo: String,
    val icono: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}