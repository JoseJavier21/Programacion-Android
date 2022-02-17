package com.example.variaspaginas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombreuser = findViewById<TextView>(R.id.nombreuser)
        val password = findViewById<TextView>(R.id.password)
        val slider = findViewById<SeekBar>(R.id.slider)
        var previewimpor = findViewById<TextView>(R.id.preimporte)
        val reinicio = findViewById<Button>(R.id.reiniciar)
        val login = findViewById<Button>(R.id.login)
        val llamar = findViewById<FloatingActionButton>(R.id.llamar)


        slider.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(SeekBar: SeekBar, proguess: Int, fromUser: Boolean) {
                var currentprogress = proguess + 100
                previewimpor.text = "$proguess"
            }
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}
            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
        })

        //Proceso Boton reiniciar

        reinicio.setOnClickListener {
            nombreuser.setText("")
            password.setText("")
        }

        //Proceso Boton Login

        login.setOnClickListener {
        val cambio = Intent(this, Segundactividad::class.java)

            cambio.putExtra(nombreuser)
            cambio.putExtra(password)
        }

        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:634822665")
        startActivity(intent)


        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("email", "jose.jrf2000@gmail.com")
        intent.putExtra("text", "jose")
        startActivity(intent)
    }
}
