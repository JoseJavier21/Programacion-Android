package com.example.weatherapp.modelo

import android.app.Application
import com.example.weatherapp.retrofit.Repositorio
import com.example.weatherapp.room.Database

class ResultWeather: Application() {

    val datos by lazy { Database.getDatabase(this) }
    val repository by lazy { Repositorio(datos.Dao()) }
}