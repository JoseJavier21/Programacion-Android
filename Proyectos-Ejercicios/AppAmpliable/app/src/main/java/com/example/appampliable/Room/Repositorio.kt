package com.example.appampliable.Room

import androidx.lifecycle.LiveData
import com.example.appampliable.TablaCircuit.TablaCircuit


class Repositorio(private val circuitInterface: CircuitInterface){

    val todoscircuitos = circuitInterface.getcircuit()

    fun getcircuit(circuit: TablaCircuit){
        circuitInterface.getcircuit()
    }

//    suspend fun modify(){
//        circuitInterface.modify()
//    }

    suspend fun insertCircuito(circuit: TablaCircuit){
        circuitInterface.insertCircuito(circuit)
    }

    suspend fun searchCircuito(){
        circuitInterface.searchCircuit("")
    }
}