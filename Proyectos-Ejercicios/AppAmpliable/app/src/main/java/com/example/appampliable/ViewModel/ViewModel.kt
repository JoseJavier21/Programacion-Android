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

class ViewModel( repositorio: Repositorio): ViewModel() {
  val uncircuito: LiveData<List<CircuitDataBase>>

    init{
        uncircuito = repositorio.
    }

    fun getCircuit(circuit: TablaCircuit) = CoroutineScope(Dispatchers.IO).launch {
        repository.insert(circuit)
    }

    class MyViewModelFactory(val repositorio: Repositorio) : ViewModelProvider.Factory{
        override fun <T: ViewModel?> create(modelClass: Class<T>): T{
            return modelClass.getConstructor(Repositorio::class.java).newInstance()
        }
    }
}