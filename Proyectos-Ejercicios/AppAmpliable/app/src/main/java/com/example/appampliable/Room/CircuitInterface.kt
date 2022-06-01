package com.example.appampliable.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appampliable.TablaCircuit.TablaCircuit

@Dao
interface CircuitInterface {

    // crear ciudad
    @Insert
    suspend fun insertCircuito(vararg tablaCircuit: TablaCircuit)

    @Query("select * from TablaCircuit")
    fun getcircuit(): LiveData<List<TablaCircuit>>

    //Seleccionar un circuito
    @Query("select * from TablaCircuit where id = :id")
    fun getcircuito(id: Int): LiveData<List<TablaCircuit>>

    //Borrar un circuito
    @Query("select * from TablaCircuit where id = :id")
    fun delete(id: Int): LiveData<List<TablaCircuit>>

    //Actualizar lista
    @Update
    suspend fun modify(circuit: TablaCircuit)

    //Buscar en lista
    @Query("select * from TablaCircuit where nombre like :nombre")
    fun searchCircuit(nombre: String): LiveData<List<TablaCircuit>>

}