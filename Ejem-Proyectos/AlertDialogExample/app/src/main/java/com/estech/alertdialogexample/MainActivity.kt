package com.estech.alertdialogexample

import android.content.DialogInterface
import android.content.DialogInterface.OnMultiChoiceClickListener
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.estech.alertdialogexample.databinding.ActivityMainBinding
import com.estech.alertdialogexample.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var user = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.dialog1.setOnClickListener { dialogNormal() }
        binding.dialog2.setOnClickListener { dialogListado() }
        binding.dialog3.setOnClickListener { dialogListadoCheckBox() }
//        binding.dialog4.setOnClickListener { dialogListadoOpciones() }
        binding.dialog5.setOnClickListener { customDialog() }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                Toast.makeText(this, "mesaje que aparece a los segundos", Toast.LENGTH_SHORT).show()
            }, 3000 )
    }

    private fun dialogNormal() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mensaje de error")
        builder.setMessage("algo no va bien")
        builder.setPositiveButton("Aceptar", { dialogInterface, i ->
            "espacio  para poner el mensaje o mas codigo que se muestre"
        })
        builder.setNegativeButton("Negar", null)
        builder.setNeutralButton("Neutral", {dialogInterface, i ->
            Toast.makeText(this, "hola mundo", Toast.LENGTH_SHORT).show()
        })
        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
    }

    private fun Handler(){
        val handler = Handler(Looper.getMainLooper())

        Handler(Looper.getMainLooper()).postDelayed(
            {
                Toast.makeText(this, "mesaje que aparece a los segundos", Toast.LENGTH_SHORT).show()
            }, 3000 )
        handler.removeCallbacks(null)
    }

    private fun timer()
    {
        val timer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val segundo = millisUntilFinished / 1000
                binding.tvOpcion.text = (segundo.toString())
            }

            override fun onFinish() {

            }
        }
        timer.start()
    }



    private fun dialogListado() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Elige un color")
        builder.setItems(R.array.arrayColors) { dialog, which ->
            // la variable which nos devuelve la posición de la lista seleccionada
            Toast.makeText(this@MainActivity, "Item $which", Toast.LENGTH_SHORT).show()

            val array = resources.getStringArray(R.array.arrayColors)
            binding.tvOpcion.text = array[which]

        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun dialogListadoRadioButom() {
        var opcionSeleccionada = 1

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Elige un color")
        builder.setSingleChoiceItems(R.array.arrayColors, 1) { dialog, which ->
            opcionSeleccionada = which
            Toast.makeText(this@MainActivity, "Item $which", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancelar", null)
        builder.setPositiveButton("Aceptar") { dialogInterface, i ->
            val array = resources.getStringArray(R.array.arrayColors)
            binding.tvOpcion.text = array[opcionSeleccionada]
        }
        val dialog = builder.create()
        dialog.show()
    }


    private fun dialogListadoCheckBox() {
        val myArray = resources.getStringArray(R.array.arrayColors)
        val arrayResult = mutableListOf<String>()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Elige un color")
        builder.setMultiChoiceItems(myArray, null,
            OnMultiChoiceClickListener { dialog, which, isChecked ->

                val color = myArray[which]
                if (isChecked) {
                    arrayResult.add(color)
                } else {
                    if (arrayResult.contains(color)) {
                        arrayResult.remove(color)
                    }
                }
            })
        builder.setPositiveButton("OK") { dialog, which ->
            Toast.makeText(this@MainActivity, arrayResult.toString(), Toast.LENGTH_SHORT).show()
            binding.tvOpcion.text = arrayResult.toString()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun customDialog() {
        val builder = AlertDialog.Builder(this)
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)
        builder.setPositiveButton("OK") { dialog, which ->
            user = dialogBinding.username.text.toString()
            password = dialogBinding.password.text.toString()
        }
        builder.setNegativeButton("Cancelar") { dialog, which ->
            Toast.makeText(this@MainActivity, "Se ha cancelado", Toast.LENGTH_SHORT).show()


        }
        val dialog = builder.create()
        dialog.show()


        /*dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
            user = dialogBinding.username.text.toString()
            password = dialogBinding.password.text.toString()
            if (user.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@MainActivity,"Uno de los campos está vacío", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity,"Campos correctos", Toast.LENGTH_SHORT).show()

                //dialog.dismiss()
            }
        }
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(ContextCompat.getColor(this, R.color.teal_700))
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(this, R.color.white))
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(Color.BLUE)*/
    }



}