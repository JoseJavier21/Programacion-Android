package com.example.appampliable.Adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.appampliable.Room.CircuitDataBase
import com.example.appampliable.TablaCircuit.TablaCircuit
import com.example.appampliable.databinding.CeldaBinding
import com.example.appampliable.databinding.FragmentListaBinding

class CircuitAdapter(val viewMoel:ViewModel): RecyclerView.Adapter<CircuitAdapter.CircuitHolder>(){

    var listacir: ArrayList<TablaCircuit> = ArrayList()

    inner class CircuitHolder(val binding: CeldaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircuitHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaBinding.inflate(layoutInflater, parent, false)
        return CircuitHolder(binding)
    }

    override fun onBindViewHolder(holder: CircuitHolder, position: Int) {
        val circuitos: TablaCircuit = listacir.get(position)
        holder.binding.nombre.text = circuitos.nombre
    }

    override fun getItemCount(): Int{
        return listacir.size
    }

    fun updateCircuitlist(arrayList: ArrayList<TablaCircuit>){
        listacir.clear()
        listacir = arrayList
        notifyDataSetChanged()
    }
}