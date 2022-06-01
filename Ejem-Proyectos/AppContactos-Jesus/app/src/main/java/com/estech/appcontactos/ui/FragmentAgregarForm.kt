package com.estech.appcontactos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.estech.appcontactos.MyApp
import com.estech.appcontactos.R
import com.estech.appcontactos.databinding.FormAgregarBinding
import com.estech.appcontactos.databinding.FragmentListaContactosBinding
import com.estech.appcontactos.domain.models.Contacto
import com.estech.appcontactos.ui.Adapter.ListaContactoAdapter
import com.estech.appcontactos.viewmodel.MyViewModel

class FragmentAgregarForm: Fragment() {

    private lateinit var binding: FormAgregarBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FormAgregarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myApp = requireActivity().application as MyApp
        val vm : MyViewModel by activityViewModels{
            MyViewModel.MyViewModelFactory(myApp.repository)
        }

      binding.btAgregar.setOnClickListener{

          val nombre = binding.etNombre.text.toString()
          val apellidos = binding.etApellidos.text.toString()
          val telefono = binding.ettelefono.text.toString()
          val email = binding.etEmail.text.toString()
          val edad = binding.etEdad.text.toString()
          var favorito = false
          if(binding.swFav.isChecked) {
              var favorito = true
          } else{
              var favorito= false
          }

          if(nombre.isNotEmpty() &&
              apellidos.isNotEmpty() &&
              telefono.isNotEmpty() &&
              email.isNotEmpty() &&
              edad.isNotEmpty() ) {

              val contacto = Contacto(
                  nombre,
                  apellidos,
                  telefono,
                  email,
                  edad.toInt(),
                  favorito
              )
             vm.insertarContacto(contacto)
              findNavController().navigate(R.id.action_fragmentAgregarForm_to_listaContactosFragment)
          } else {
          Toast.makeText(requireContext(),"Rellene todos los campos",Toast.LENGTH_LONG).show()
          }
        }
    }

}