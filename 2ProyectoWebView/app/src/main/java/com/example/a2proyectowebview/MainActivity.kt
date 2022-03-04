package com.example.a2proyectowebview

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.a2proyectowebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    // Para introducir la pagina al webView     //

        binding.webView.loadUrl("https://kartinggranada.es/#no-link")

    // varios ajustes de webView        //

        val ajustes = binding.webView.settings

        ajustes.displayZoomControls = false
        ajustes.builtInZoomControls = true
        ajustes.javaScriptEnabled = true
        ajustes.disabledActionModeMenuItems
        binding.webView.webViewClient = MyBrowser()


        // BOTONES PARA RETROCESO Y AVANCE DE LAS PAGINAS

        binding.atras.setOnClickListener {
            if (binding.webView.canGoBack()) {

                binding.webView.goBack()
            }
        }

        binding.adelante.setOnClickListener {
            if (binding.webView.canGoForward()) {

                binding.webView.goForward()

            }
        }


        binding.webView.loadUrl("https://kartinggranada.es/#no-link")

    }

    override fun onBackPressed() {
        //super.onBackPressed()  == finish

//        if(binding.webView.canGoBack()){
//            binding.webView.goBack()
//        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mensaje de cierre")
        builder.setMessage("¿Desea salir de la aplicación?")
        builder.setPositiveButton("si", DialogInterface.OnClickListener(){
            Dialog, i -> finish()
        })

        builder.setNegativeButton("Cancelar", null)
        val dialog = builder.create() //AlertDialog
        dialog.show()
    }

    //  PARA QUE MUESRTA LA PAGINA WEB DESEADA

    inner class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            return false

        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)

            binding.progressBar.visibility = View.VISIBLE
            binding.recarga.setImageResource(R.drawable.ic_baseline_clear_24)
            binding.recarga.setOnClickListener {

                binding.webView.stopLoading()

            }

        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            binding.progressBar.visibility = View.GONE
            binding.recarga.setImageResource(R.drawable.ic_baseline_autorenew_24)

            binding.recarga.setOnClickListener {

            binding.webView.reload()
            binding.urlview.text = binding.webView.url

            }


        }


    inner class Chrome: WebViewClient(){

    }
    }






}