package com.example.a2proyectowebview

import android.app.Activity
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

        binding.webView.loadUrl("https://escuelaestech.es/")

    // varios ajustes de webView        //

        val ajustes = binding.webView.settings

        ajustes.displayZoomControls = false
        ajustes.builtInZoomControls = true
        ajustes.javaScriptEnabled = true
        ajustes.disabledActionModeMenuItems

    }

    inner class MyBrowser : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            binding.urlview.urls

            val uri = request?.url
            val host = uri?.host
            if (host == "escuelaestech.es") {
                return false
            } else {
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
                return true
            }
        }
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)

            binding.progressBar.visibility = View.VISIBLE


        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)

            binding.progressBar.visibility = View.GONE
        }
    }



}