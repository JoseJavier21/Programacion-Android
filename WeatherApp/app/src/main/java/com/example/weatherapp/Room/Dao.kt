package com.example.weatherapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.weatherapp.modelo.Tiempo

@Dao
interface Dao {

    @Insert
    suspend fun dametiempo(vararg tiempo: Tiempo)

}