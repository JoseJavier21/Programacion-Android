package com.estech.appcontactos.ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estech.appcontactos.databinding.HolderContactoBinding
import com.estech.appcontactos.domain.models.Contacto

class ListaFavAdapter :
    RecyclerView.Adapter<ListaFavAdapter.MyViewHolder>() {

    var contactos: ArrayList<Contacto> = ArrayList<Contacto>()
    inner class MyViewHolder(val binding: HolderContactoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaFavAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderContactoBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ListaFavAdapter.MyViewHolder, position: Int) {
        val contacto: Contacto = contactos.get(position)
        holder.binding.tvNombre.text = contacto.nombre

    }
    override fun getItemCount(): Int {
        return contactos.size
    }

    fun actualizarLista(arrayList: ArrayList<Contacto>){
        contactos.clear()
        contactos=arrayList
        notifyDataSetChanged()
    }

}