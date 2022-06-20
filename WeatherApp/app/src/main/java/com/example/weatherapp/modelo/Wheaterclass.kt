package com.example.weatherapp

import android.app.Application
import com.example.weatherapp.retrofit.Repositorio
import com.example.weatherapp.room.Database

class wheaterclass: Application() {

    val database by lazy { Database.getDatabase(this) }
//    val repositorio by lazy { Repositorio(database.Dao())}
}