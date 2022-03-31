package com.example.aplifranavigation

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Bitmap
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.aplifranavigation.databinding.ActivityMainBinding
import com.example.aplifranavigation.databinding.FragmentWebviewBinding


class WebviewFragment : Fragment() {

    private lateinit var binding: FragmentWebviewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebviewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }






    binding.webView.loadUrl("https://kartinggranada.es/#no-link")
    val ajustes = binding.webview


    ajustes.displayZoomControls = false
    ajustes.builtInZoomControls = true
    ajustes.javaScriptEnabled = true
    ajustes.disabledActionModeMenuItems
    binding.webView.webViewClient = MyBrowser()

    binding.atras.setOnClickListener {
        if (binding.webview.canGoBack()) {

            binding.webview.goBack()
        }
    }

    binding.adelante.setOnClickListener {
        if (binding.webview.canGoForward()) {

            binding.webview.goForward()

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




        override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)

        binding.progressBar.visibility = View.GONE
        binding.recarga.setImageResource(R.drawable.ic_baseline_autorenew_24)

        binding.recarga.setOnClickListener {

            binding.webView.reload()
            binding.urlview.text = binding.webView.url

        }


    }

}