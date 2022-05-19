package com.estech.appcontactos.domain.room

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.room.*
import com.estech.appcontactos.domain.models.TablaContact

@Dao
interface ContactosDao {

    // Crea un Contacto
    @Insert
    suspend fun insertContact(vararg tablaContact: TablaContact)

    //Seleccionar un Contacto o todos
    @Query("select * from mis_contactos")
    fun getConcact(): LiveData<List<TablaContact>>

    @Query("select * from mis_contactos where id = :id")
    fun getoneContact(id: Int): LiveData<List<TablaContact>>


    //Borrado de datos
    @Delete
    suspend fun deleteContact(contact: TablaContact)

//    @Query("delete from mis_contactos where id = :id")
//    suspend fun deleteoneContact(id: Int)


    //Buscador de Contactos
    @Query("select * from mis_contactos where nombre like :nombre")
    fun searchContact(nombre: String): LiveData<List<TablaContact>>


    //Modificar Contacto
    @Update
    suspend fun modifyContact(contact: TablaContact)


    //Obtener Lista favoritos
    @Query("select * from mis_contactos where favorito = :favorito")
    fun obtenerContact(favorito: Boolean): LiveData<List<TablaContact>>

}
