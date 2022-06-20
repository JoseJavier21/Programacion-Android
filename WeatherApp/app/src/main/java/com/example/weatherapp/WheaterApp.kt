package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.Room.BaseDatos
import com.example.weatherapp.retrofit.Repositorio

class WheaterApp: Application() {
    val database by lazy { BaseDatos.getDatabase(this) }
    val repositorio by lazy { Repositorio(database.unoDao()) }
}