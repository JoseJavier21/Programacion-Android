package com.estech.webviewexample

import android.graphics.Bitmap
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.estech.webviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        webView = binding.webview

        webView.loadUrl("https://escuelaestech.es")

        val ajustes = webView.settings

        ajustes.displayZoomControls = false
        ajustes.builtInZoomControls = true
        ajustes.javaScriptEnabled = true

//        webView.webViewClient = MyWebViewClient()
            webView.goForward()

        webView.webChromeClient = MyChrome()
        webView.webViewClient = MyWebViewClient()


       }

    override fun onBackPressed() {

        if (webView.canGoBack())
            webView.goBack()
        else super.onBackPressed()

    }

    inner class  MyWebViewClient: WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {

            val url = request?.url.toString()
            if (url.contains("escuelaestech.es")){
                return false

            }else {
                return super.shouldOverrideUrlLoading(view, request)
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

    inner class MyChrome: WebChromeClient(){
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)

            binding.progressBar.progress = newProgress
        }
    }



}