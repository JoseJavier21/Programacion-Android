package com.example.spinnerejercicioprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        Creacion de Spinner          //

    //      Spinner por xml      //

        //creamos sus variables correspondientes//

            val spinnerdropdown = findViewById<Spinner>(R.id.spinner1)
            val spinnerventana = findViewById<Spinner>(R.id.spinner2)

        //Tendremos que crear un array en la car.STRINGS//

            //llamamos a al strings y lo metemos en una variable//

                val usuarios = resources.getStringArray(R.array.nombres)









    }
}