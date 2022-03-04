package com.estech.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.estech.recyclerviewexample.databinding.HolderPlayerBinding

class Myadaptador(val lista: MutableList<String>): RecyclerView.Adapter<Myadaptador.PlayerHolder>() {

    inner class PlayerHolder (view: View): RecyclerView.ViewHolder(view){
        val textView: TextView

        init {
            textView = view.findViewById(R.id.holder_name)
        }
    }


    inner class Jugadoresbinding(binding:HolderPlayerBinding): RecyclerView.ViewHolder(binding.root){

        val layoutManager: LinearLayoutManager(this)
                binding.recycler.view
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
//        val layoutInflater = LayoutInflater.from(parent.context)
//        val view = layoutInflater.inflate(R.layout.holder_player, parent, false)
//        val playerHolder = PlayerHolder(view)
//        return playerHolder
//    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        val jugador = lista[position]
        holder.textView.text = jugador

    }

    override fun getItemCount(): Int {
        return lista.size
    }
}