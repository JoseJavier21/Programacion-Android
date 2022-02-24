package com.example.a2proyectowebview

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.webView.loadUrl("https://escuelaestech.es/")

    // varios ajustes de webView        //

        val ajustes = binding.webView.settings

        ajustes.displayZoomControls = true
        ajustes.builtInZoomControls = true
        ajustes.javaScriptEnabled = true
        ajustes.disabledActionModeMenuItems

    }

    inner class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?,

         request: WebResourceRequest?): Boolean {

         return super.shouldOverrideUrlLoading(view, request)
        }
    }

}