package com.example.appampliable.Room

import androidx.lifecycle.LiveData
import com.example.appampliable.TablaCircuit.TablaCircuit


class Repositorio(private val CircuitInterface: CircuitInterface){

    val todoscircuitos = CircuitInterface.allcircuitos()

    suspend fun insertCircuito(tablaCircuit: TablaCircuit){
        CircuitInterface.insertCircuito(tablaCircuit)
    }

    suspend fun delete(){
        CircuitInterface.delete()
    }

//    suspend fun getcircuito(tablaCircuit: TablaCircuit){
//        return CircuitInterface.getcircuito(id)
//    }

    suspend fun deleteunCircuito(tablaCircuit: TablaCircuit){
        CircuitInterface.deleteunCircuito(tablaCircuit)
    }

//    suspend fun searchCircuito(){
//        CircuitInterface.searchCircuit("")
//    }
}