package com.estech.appcontactos.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mis_contactos")
data class TablaContact(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val apellidos: String,
    val telefono: Int,
    val correoelectronico: String,
    val edad: Int,
    val favorito: Boolean,
)