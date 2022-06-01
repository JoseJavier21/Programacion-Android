package com.estech.appcontactos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.estech.appcontactos.MyApp
import com.estech.appcontactos.databinding.FragmentListaContactosBinding
import com.estech.appcontactos.databinding.FragmentListaFavBinding
import com.estech.appcontactos.domain.models.Contacto
import com.estech.appcontactos.ui.Adapter.ListaContactoAdapter
import com.estech.appcontactos.viewmodel.MyViewModel

class FragmentListaFav: Fragment() {

    private lateinit var binding: FragmentListaFavBinding
    private lateinit var adapter: ListaContactoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myApp = requireActivity().application as MyApp
        val vm: MyViewModel by activityViewModels {
            MyViewModel.MyViewModelFactory(myApp.repository)
        }
        configRecycler(vm)

        vm.listaFavoritos.observe(viewLifecycleOwner) {
            adapter.actualizarLista(it as ArrayList<Contacto>)
        }
    }
        private fun configRecycler(vm : MyViewModel){
            adapter = ListaContactoAdapter(vm)
            binding.recyclerViewFav.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewFav.adapter = adapter
        }
}