package com.estech.takephotosample

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import com.estech.takephotosample.databinding.ActivityMainBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var uricamera: Uri
    private val model: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCamara.setOnClickListener {
            tomarImagenCamara()
        }

        binding.btGaleria.setOnClickListener {
            tomarImagenGaleria()
        }

        model.imageUri.observe(this){
            binding.imageView.setImageURI(it)
        }
    }

    private fun tomarImagenCamara() {

        val archivofoto = crearArchivoParaFoto()

        uricamera = FileProvider.getUriForFile(this, "${packageName}.fileprovider", archivofoto)

        resultadocamera.launch(uricamera)
    }

    private val resultadotomarimagen= registerForActivityResult(
        ActivityResultContracts.OpenDocument()){
        uri ->
        val uriComoString = uri.toString()
        binding.imageView.setImageURI(Uri.parse(uriComoString))
    }

    private val resultadocamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()){
        guardado ->
        if (guardado){
                binding.imageView.setImageURI(uricamera)
            }else {
                val rutaarchivo = getExternalFilesDir(Environment.DIRECTORY_PICTURES + uricamera.path)
            rutaarchivo?.let{
                val resuldado = rutaarchivo.delete()
                if (resuldado) Toast.makeText(this, "Imagen eliminada", Toast.LENGTH_SHORT).show()
                else Toast.makeText(this, "Error borrado", Toast.LENGTH_SHORT).show()
            }
        }
        }


    @Throws(IOException::class)
    private fun crearArchivoParaFoto(): File {
        //nombre de archivo con fecha y hora actual
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        // ruta a la carpeta privada de la App
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        // Crea un objeto File con el nombre de archivo, la extensión y la carpeta donde se almacena el archivo
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefijo */
            ".jpg", /* sufijo */
            storageDir /* directorio */
        )
    }

    private fun tomarImagenGaleria(){
        resultadotomarimagen.launch(arrayOf("image/*"))
    }



    /*<external-path name="my_images" path="/" />
    val storageDir: File? = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)*/
}