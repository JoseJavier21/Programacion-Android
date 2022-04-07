package com.example.practica_valorant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.practica_valorant.databinding.FragmentListPersonajesBinding
import com.example.practica_valorant.modelos.personaje
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream


class ListPersonajes : Fragment() {

    private lateinit var binding: FragmentListPersonajesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = FragmentListPersonajesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val jsonEnString = getJsonAsset()

        if (jsonEnString != null) {
            val gson = Gson()
            val listapersonajes = gson
                .fromJson(
                    jsonEnString,
                    Array<Personaje>::class.java)
                .asList()
            val recyclerView = binding.recycleView
            val adapter = AdapterPerso(listapersonajes)
            val layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    private fun getJsonAsset(): String? {
        var jsonString: String? = null
        try {
            val inputStream: InputStream = requireContext().assets.open("personajes.json")
            jsonString = inputStream.bufferedReader().use {
                it.readText()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        return jsonString
    }
}