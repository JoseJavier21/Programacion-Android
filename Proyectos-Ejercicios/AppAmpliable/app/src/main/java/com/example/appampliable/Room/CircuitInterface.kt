package com.example.appampliable.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appampliable.TablaCircuit.TablaCircuit

@Dao
interface CircuitInterface {

    // crear ciudad
    @Insert
    suspend fun insertCircuito(vararg tablaCircuit: TablaCircuit)

//    @Query("select * from TablaCircuit")
//    fun getcircuit(): LiveData<List<TablaCircuit>>

    //Seleccionar un circuito
    @Query("select * from TablaCircuit where id = :id")
    fun getcircuito(id: Int): TablaCircuit

    //Seleccionar todos los circuitos
    @Query("select * from TablaCircuit")
    fun allcircuitos(): LiveData<List<TablaCircuit>>

    //Borrar un circuitos
    @Delete
    suspend fun delete()

    @Delete
    suspend fun deleteunCircuito(tablaCircuit: TablaCircuit)

    //Actualizar lista
    @Update
    suspend fun modify(circuit: TablaCircuit)

    //Buscar en lista
    @Query("select * from TablaCircuit where nombre like :nombre")
    fun searchCircuit(nombre: String): TablaCircuit

}