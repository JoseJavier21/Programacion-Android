package com.estech.ejerdosactividades

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


/**
 * Created by sergi on 16/02/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class SegundaActividad: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda)

        val bundle = intent.extras

        if (bundle!!.containsKey("user") && bundle.containsKey("pass") && bundle.containsKey("amount")
            && bundle.containsKey("currency")) {

            val user = bundle.getString("user")
            val pass = bundle.getString("pass")
            val amount = bundle.getInt("amount")
            val currency = bundle.getString("currency")

            val btn_back = findViewById<Button>(R.id.btn_back)
            val tv_welcome = findViewById<TextView>(R.id.tv_welcome)
            val tv_message = findViewById<TextView>(R.id.tv_message)
            val fab_mail = findViewById<FloatingActionButton>(R.id.fab_mail)
            val fab_what = findViewById<FloatingActionButton>(R.id.fab_what)


            tv_welcome.text = "Bienvenido $user"
            tv_message.text = "Tu inversión será de $amount $currency"

            btn_back.setOnClickListener {
                finish()
            }

            fab_mail.setOnClickListener {

                val addresses = arrayOf("info@escuelaestech.es", "secretaria@escuelaestech.es")
                val subject = "Inversión en criptomonedas"
                val text = "Hola $user. Tu inversión en criptomonedas será de $amount$currency"


                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, addresses)
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, text)
                }
                    startActivity(intent)
            }

            fab_what.setOnClickListener {
                val text = "Hola $user. Tu inversión en criptomonedas será de $amount$currency"
                val whatsapp = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://api.whatsapp.com/send?phone=+34697246008&text=$text")
                )
                startActivity(whatsapp)
            }

        }
    }
}