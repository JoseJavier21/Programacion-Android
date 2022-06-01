package com.estech.appcontactos.domain.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.estech.appcontactos.domain.models.Contacto


/**
 * Created by sergi on 13/05/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */
@Dao
interface ContactosDao {
    @Insert
    suspend fun insertarContacto(vararg contacto: Contacto)

    @Query ("SELECT * FROM Contacto")
    fun obtenerContactos(): LiveData<List<Contacto>>

    @Query ("DELETE FROM Contacto")
    suspend fun eliminarContactos()

    @Delete()
    suspend fun borrarContacto(vararg contacto: Contacto)

    @Query("SELECT * FROM contacto WHERE nombre LIKE :nombre")
    fun ContactoNombre(nombre: String): LiveData<List<Contacto>>

    @Update ()
    suspend fun modificarContacto(contacto: Contacto)

    @Query("SELECT * FROM contacto WHERE favorito =1 ")
    fun contactosFavoritos(): LiveData<List<Contacto>>

//    @Query("SELECT * FROM contacto WHERE favorito =1 ")
//    fun contactosFavoritos(favoritos: Boolean): LiveData<List<Contacto>>

//    @Query("SELECT * FROM contacto WHERE id= :id")
//    fun damerContactoespecifico(id:Int)
//
//    @Query("DELETE FROM contacto WHERE id= :id")
//    suspend fun borrarContactoespecifico(id:Int)







}