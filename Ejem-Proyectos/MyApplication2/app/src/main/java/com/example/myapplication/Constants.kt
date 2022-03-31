package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast

object Constants {

    val PARAM_NOMBRE = "sTRING"
    val PARAM_EDAD= "sTRING"

    fun crearToast(mensaje: String, context: Context) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun crearAlertDialog(mensaje: String, context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", null)
        builder.create().show()
    }
}