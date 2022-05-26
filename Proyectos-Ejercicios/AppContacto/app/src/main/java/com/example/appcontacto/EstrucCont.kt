package com.example.appcontacto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EstrucCont (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val apellidos: String,
    val telefono: Int,
    @ColumnInfo(name = "correo")
    val correoelectronico: String,
    val edad: Int,
    val favorito: Boolean,


    )