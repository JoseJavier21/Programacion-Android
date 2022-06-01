package com.estech.appcontactos.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacto(
    val nombre: String,
    val apellidos: String,
    val telefono: String,
    @ColumnInfo(name="CorreoElectonico")val email : String,
    val edad: Int,
    val favorito: Boolean
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
