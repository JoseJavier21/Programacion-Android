package com.estech.appcontactos.domain.room

import com.estech.appcontactos.domain.models.TablaContact


/**
 * Created by sergi on 13/05/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class Repositorio(private val contactosDao: ContactosDao) {


    //cuando devuelve datos
    val todosContact = contactosDao.getConcact()

    //cuando no devuelve datos
    suspend fun insertContact(contact: TablaContact){
        contactosDao.insertContact()
    }
}