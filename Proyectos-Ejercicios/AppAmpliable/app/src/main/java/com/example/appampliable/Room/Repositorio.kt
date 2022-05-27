package com.example.appampliable.Room

import androidx.lifecycle.LiveData
import com.example.appampliable.TablaCircuit.TablaCircuit


class Repositorio(private val circuitInterface: CircuitInterface){

    val uncircuito: LiveData<List<TablaCircuit>> = circuitInterface.insertCircuito()

    suspend fun insert(circuit: TablaCircuit){
        circuitInterface.insertCircuito()
    }

}