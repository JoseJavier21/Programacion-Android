package com.estech.gatosmvvm.viewmodels

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.estech.gatosmvvm.modelos.listagatos.Breed
import com.estech.retrofitsample.retrofit.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class GatoViewmodel: ViewModel() {

    private val repositorio = Repositorio()
    val listaRazas = MutableLiveData<ArrayList<Breed>>()
    val errorRazas = MutableLiveData<String>()
    val razaSelecter = MutableLiveData<Breed>()
    val mostrarCargar = MutableLiveData<Boolean>()

    fun getListaRazas(){

        mostrarCargar.value = true
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getRazas()

            if (response.isSuccessful)
            {
                val respuesta = response.body()
                respuesta?.let {
                listaRazas.postValue(it)
                }

            } else{
                    errorRazas.postValue(response.message())
            }
        mostrarCargar.postValue(false)

        }




    }
}