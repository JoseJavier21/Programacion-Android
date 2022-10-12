package com.example.weatherapp.retrofit

import androidx.room.Dao

class Repositorio(private val dao: com.example.weatherapp.room.Dao) {

    private val peticiones = Helper.getRetrofit()

    suspend fun getime(lugar: String) = peticiones.getweather(1, lugar, "Bearer NWZmNTFlYWUtM2JlYS00ZjY1LWFiOWYtMWY0NDkyMTIzZmJi")


}