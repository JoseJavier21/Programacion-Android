package com.example.weatherapp.retrofit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.weatherapp.WheaterApp

class Repositorio(private val MiDao: com.example.weatherapp.room.Dao) {

    private val peticiones = Helper.getRetrofit()

    suspend fun getime(lugar: String) = peticiones.getweather(1, lugar, "Bearer NWZmNTFlYWUtM2JlYS00ZjY1LWFiOWYtMWY0NDkyMTIzZmJi")

//    val allTiempo: LiveData<List<WheaterApp>> = MiDao.dametiempo()
}