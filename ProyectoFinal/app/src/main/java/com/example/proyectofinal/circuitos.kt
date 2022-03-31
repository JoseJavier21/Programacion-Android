package com.example.proyectofinal

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.proyectofinal.databinding.FragmentCircuitosBinding


class circuitos : Fragment() {

    private lateinit var binding: FragmentCircuitosBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCircuitosBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val galeria = listOf(R.drawable.cicuito1,
            R.drawable.cicuito2,
            R.drawable.circuit3,
            R.drawable.circuit4)
        val adapter = AdapterGalery(galeria)
        binding.viewpager.adapter = adapter

        binding.viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            @SuppressLint("MissingSuperCall")
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })



    }


}