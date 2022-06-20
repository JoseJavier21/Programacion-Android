package com.example.appampliable.Adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.appampliable.MyApp
import com.example.appampliable.Room.CircuitDataBase
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.databinding.CeldaBinding
import com.example.appampliable.databinding.FragmentListaBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class CircuitAdapter(val context : Context, listaciruitos: ArrayList<TablaCircuit>): RecyclerView.Adapter<CircuitAdapter.CircuitHolder>(){
    inner class CircuitHolder(val binding: CeldaBinding): RecyclerView.ViewHolder(binding.root)

    var listacir = listaciruitos
    val miapp = MyApp()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircuitHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaBinding.inflate(layoutInflater, parent, false)
        return CircuitHolder(binding)
    }

    override fun onBindViewHolder(holder: CircuitHolder, position: Int){

        var posicion =  holder.adapterPosition
        val lista = listacir[position]
        val binding = holder.binding
//      val viemodel = ViewModel(miapp.repositorio)

        binding.nombre.text = lista.nombre
        binding.pais.text = lista.pais
        binding.direccion.text = lista.direccion
        binding.longitud.text = "${lista.longitud}"
        binding.latitud.text = lista.latitud.toString()

    }

    override fun getItemCount(): Int{
        return listacir.size
    }

    fun updateCircuitlist(Lista: List<TablaCircuit>){
        listacir.clear()
        listacir.addAll(Lista)
//       notifyDataSetChanged(listacir.size, listacir.size-1)
//        notifyItemRemoved(posicion)// va una variable de posicion
    }
}