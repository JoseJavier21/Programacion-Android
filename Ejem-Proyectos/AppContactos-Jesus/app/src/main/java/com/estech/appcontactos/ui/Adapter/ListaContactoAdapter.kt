package com.estech.appcontactos.ui.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.estech.appcontactos.MyApp
import com.estech.appcontactos.databinding.HolderContactoBinding
import com.estech.appcontactos.domain.models.Contacto
import com.estech.appcontactos.domain.room.Repositorio
import com.estech.appcontactos.viewmodel.MyViewModel

class ListaContactoAdapter(val vm:MyViewModel) :
    RecyclerView.Adapter<ListaContactoAdapter.MyViewHolder>() {

    var contactos: ArrayList<Contacto> = ArrayList<Contacto>()
        inner class MyViewHolder(val binding: HolderContactoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaContactoAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HolderContactoBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaContactoAdapter.MyViewHolder, position: Int) {
        val contacto: Contacto = contactos.get(position)
        holder.binding.tvNombre.text = contacto.nombre

        holder.binding.btnBorrar.setOnClickListener{
            vm.eliminarContacto(contacto)
        }
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