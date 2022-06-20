package com.example.weatherapp.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Dao
import com.example.weatherapp.modelo.Tiempo
import com.example.weatherapp.retrofit.Repositorio
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TiempoViewModel(private val repositorio: Repositorio): ViewModel() {


   val tiempoLiveData: MutableLiveData<ArrayList<Tiempo>> by lazy {
      MutableLiveData<ArrayList<Tiempo>>()
   }

   val error: MutableLiveData<String> by lazy {
      MutableLiveData<String>()
   }

   val todotiempo = MutableLiveData<Int>()

   fun getTiempo(p0: String){
      CoroutineScope(Dispatchers.IO).launch {
         val responde = repositorio.getime(p0)

         if (responde.isSuccessful) {
            val respuesta = responde.body()
            todotiempo.postValue(respuesta?.country?.length)
            val listaPersonajes = respuesta?.region
            listaPersonajes?.let {
//               tiempoLiveData.postValue(it)
            }
         }
      }
   }

   class MyViewModelFactory(private val repositorio: Repositorio): ViewModelProvider.Factory{
      override fun <T : ViewModel?> create(modelClass: Class<T>): T {
         return modelClass.getConstructor(Repositorio::class.java)
            .newInstance(repositorio)
      }
   }


}