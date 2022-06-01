package com.estech.appcontactos.domain.room

import androidx.lifecycle.LiveData
import com.estech.appcontactos.domain.models.Contacto


/**
 * Created by sergi on 13/05/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class Repositorio(private val contactosDao: ContactosDao) {

    //TODO "Funciones de Insertar"

    suspend fun insertarContacto(contacto: Contacto){
        contactosDao.insertarContacto(contacto)
    }

    //TODO "Funciones que traen LiveData"
    val todosContactos = contactosDao.obtenerContactos()

    //---------------

    suspend fun eliminarLosContactos(){
        contactosDao.eliminarContactos()
    }

    suspend fun eliminarContacto(contacto: Contacto){
        contactosDao.borrarContacto(contacto)
    }

    fun contactoXNombre(contacto : String):LiveData<List<Contacto>> {
        return contactosDao.ContactoNombre(contacto)
    }


    suspend fun editarContacto(contacto: Contacto){
        contactosDao.modificarContacto(contacto)
    }

    val listaFavoritos = contactosDao.contactosFavoritos()

//    fun listaFavoritos(favorito : Boolean):LiveData<List<Contacto>> {
//        return contactosDao.contactosFavoritos(favorito)
//    }

}