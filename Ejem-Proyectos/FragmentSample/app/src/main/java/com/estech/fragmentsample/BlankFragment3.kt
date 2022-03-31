package com.estech.fragmentsample

import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.estech.fragmentsample.databinding.FragmentBlank3Binding
import com.estech.fragmentsample.databinding.FragmentBlankBinding

class BlankFragment3 : Fragment() {

    private lateinit var binding: FragmentBlank3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank3Binding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dato = arguments?.getString("dato")
        binding.textView.setText(dato)
    }
}



