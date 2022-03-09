package com.example.menustoolbaractionbar

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Codigo para la barra superior predeterminada //
        supportActionBar?.setTitle("MyApp")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        if (item.itemId == android.R.id.home){

            finish()
            return true
        }

        // Codigo para el Toolbar //

            setSupportActionBar(binding.toolbar)
            supportActionBar?.setTitle("MyApp")
            supportActionBar?.setDisplayHomeAsUpEnabled(true)


        }


    // Como poner un menu //
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuinflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.opcion1 ->{
                true
            }

            R.id.opcion2 ->{
                Toast.makeText(this, "hola", Toast.LENGTH_SHORT).show()
                true
            }
        }

        return super.onOptionsItemSelected(item)


    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
         if (menu is MenuBuilder) menu.setOptionalIconsVisible(true)
         menuInflater.inflate(R.menu.menu,menu)
         return true
        }
    }

}