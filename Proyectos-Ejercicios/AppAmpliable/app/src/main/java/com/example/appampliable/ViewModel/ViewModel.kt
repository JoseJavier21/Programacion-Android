package com.example.appampliable.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.appampliable.Room.CircuitDataBase
import com.example.appampliable.Room.Repositorio
import com.example.appampliable.TablaCircuit.TablaCircuit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(val repositorio: Repositorio): ViewModel() {

    val todoscircuitos: LiveData<List<TablaCircuit>>

    init{
       todoscircuitos = repositorio.todoscircuitos
    }

//    suspend fun gecircuito(id: Int):TablaCircuit{
//        CoroutineScope(Dispatchers.IO).launch {
//            repositorio.getcircuito(id)
//            return@launch
//        }
//    }

    fun insertCircuito(tablaCircuit: TablaCircuit){
        CoroutineScope(Dispatchers.IO).launch {
            repositorio.insertCircuito(tablaCircuit)
        }
    }

//    fun deleteunCircuito(tablaCircuit: TablaCircuit){
//        CoroutineScope(Dispatchers.IO).launch{
//            repositorio.delete(tablaCircuit)
//        }
//    }

    fun delete(){
        CoroutineScope(Dispatchers.IO).launch {
            repositorio.delete()
        }
    }



    class MyViewModelFactory(val repositorio: Repositorio) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Repositorio::class.java).newInstance(repositorio)
        }
    }
}