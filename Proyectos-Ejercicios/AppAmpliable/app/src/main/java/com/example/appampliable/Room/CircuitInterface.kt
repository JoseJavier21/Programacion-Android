package com.example.appampliable.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appampliable.TablaCircuit.TablaCircuit

@Dao
interface CircuitInterface {

    @Insert
    suspend fun insertCircuito(): LiveData<List<TablaCircuit>>

}