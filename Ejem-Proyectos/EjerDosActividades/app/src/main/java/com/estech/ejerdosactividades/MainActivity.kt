package com.estech.ejerdosactividades

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var simbolo_moneda = "€"
    var valor_inversion = 600

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mySeekBar = findViewById<SeekBar>(R.id.seekBar)
        val editTextUser = findViewById<TextInputEditText>(R.id.et_user)
        val editTextPass = findViewById<TextInputEditText>(R.id.et_pass)
        val btnLogin = findViewById<Button>(R.id.bt_login)
        val btnRestart = findViewById<Button>(R.id.bt_restart)
        val mySpinner = findViewById<Spinner>(R.id.spinner)
        val fabCall = findViewById<FloatingActionButton>(R.id.fab_mail)

        val arrayCurrency = arrayOf("Euros", "Dólares", "Libras", "Rublos", "Rupias", "Yenes")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayCurrency)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = adapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                simbolo_moneda = cambiaSimbolo(p2)
                cambiarTextoInversion()

                val tvMin = findViewById<TextView>(R.id.tv_min)
                val tvMax = findViewById<TextView>(R.id.tv_max)
                tvMin.text = "100$simbolo_moneda"
                tvMax.text = "5000$simbolo_moneda"
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        mySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valor_inversion = 100 + p1
                cambiarTextoInversion()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        btnLogin.setOnClickListener {
            val usuario = editTextUser.text.toString()
            val password = editTextPass.text.toString()

            if (usuario.isNotEmpty() && password.isNotEmpty()) {
                val valor = mySeekBar.progress
                if (password == "qwerasdf")
                    openNextActivity(
                        usuario,
                        password,
                        mySeekBar.progress + 100,
                        mySpinner.selectedItem.toString()
                    )
                else
                    setError(editTextPass, "Contraseña incorrecta")

            } else {
                if (usuario.isEmpty()) setError(editTextUser, "El usuario está vacío")
                if (password.isEmpty()) setError(editTextPass, "La contraseña está vacía")
            }
        }

        btnRestart.setOnClickListener {
            editTextUser.setText("")
            editTextPass.setText("")
            mySpinner.setSelection(0)
            mySeekBar.progress = 500
        }

        fabCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:953995533")

            startActivity(intent)
        }
    }

    fun setError(view: TextInputEditText, message: String) {
        view.error = message
    }

    fun openNextActivity(user: String, pass: String, amount: Int, currency: String) {
        val intent = Intent(this, SegundaActividad::class.java).apply {
            putExtra("user", user)
            putExtra("pass", pass)
            putExtra("amount", amount)
            putExtra("currency", currency)
        }
        startActivity(intent)
    }

    fun cambiarTextoInversion() {
        val tvInversion = findViewById<TextView>(R.id.tv_inversion)
        tvInversion.text = "$valor_inversion $simbolo_moneda"
    }

    fun cambiaSimbolo(position: Int) = when (position) {
        1 -> "$"
        2 -> "£"
        3 -> "₽"
        4 -> "₹"
        5 -> "¥"
        else -> "€"
    }
}