package com.estech.fragmentsample

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.estech.fragmentsample.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

   private lateinit var binding: FragmentBlank2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView2.setText("hola")

        binding.button2.setOnClickListener {
            val bundle = bundleOf("dato" to "Jose")
//            bundle.putString(("mail", "Jose")
            findNavController().navigate(R.id.action_blankFragment2_to_blankFragment33, bundle)
        }
    }
}
