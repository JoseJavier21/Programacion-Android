package com.example.appampliable.Room


class Repositorio(private val circuitInterface: CircuitInterface){

    val uncircuito = CircuitInterface.getcircuito()

    suspend fun insertCircuito(circuitInterface: CircuitInterface){
        CircuitInterface.insertCircuito(circuitInterface)
    }

    suspend fun delete(circuitInterface: CircuitInterface){
        CircuitInterface.delete(circuitInterface)
    }

    suspend fun modificar(circuitInterface: CircuitInterface){
    }
}