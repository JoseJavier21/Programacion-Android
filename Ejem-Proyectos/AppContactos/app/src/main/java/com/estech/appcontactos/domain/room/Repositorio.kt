package com.estech.appcontactos.domain.room

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.estech.appcontactos.domain.models.TablaContact


/**
 * Created by sergi on 13/05/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class Repositorio(private val contactosDao: ContactosDao) {


    //cuando devuelve datos
    val todosContact = contactosDao.getConcact()

    //cuando no devuelve datos
    suspend fun insertContact(contact: TablaContact) {
        contactosDao.insertContact(contact)
    }

    //Borrar contacto
    suspend fun deleteCotact(contact: TablaContact) {
        contactosDao.deleteContact(contact)
    }

    //Buscador de contacto
    suspend fun searchContact(){
        contactosDao.searchContact(nombre = "")
    }

    //Actualizar un contacto
    suspend fun modifyContact(contact: TablaContact){

    }

    //Obtener lista favoritos
    suspend fun obtenerContact(){
        contactosDao.obtenerContact(favorito = false)
    }



}