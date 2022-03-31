package com.example.proyectofinal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal.databinding.CeldasBinding
import com.example.proyectofinal.databinding.FragmentCircuitosBinding
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class AdapterGalery(val lista: List<Int>) : RecyclerView.Adapter<AdapterGalery.micelda>() {

    inner class micelda(val binding: CeldasBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): micelda {
        val layoutinflater = LayoutInflater.from(parent.context)
        val binding = CeldasBinding.inflate(layoutinflater, parent, false)
        val layoutcelda = micelda(binding)
        return layoutcelda
    }


    override fun onBindViewHolder(holder: micelda, position: Int) {
        val images = lista[position]
        holder.binding.imgcelda.setImageResource(images)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}