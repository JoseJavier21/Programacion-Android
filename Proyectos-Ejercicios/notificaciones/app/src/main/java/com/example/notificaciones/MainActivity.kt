package com.example.notificaciones

import android.app.NotificationChannel
import android.app.NotificationManager
import android.media.session.MediaSession
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import com.google.firebase.messaging.FirebaseMessaging


const val NORMAL_CHANNEL_ID = "myNotif"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()
        getToken()
    }

    private fun getToken() {
        FirebaseMessaging.getInstance().token.addOnSuccessListener { token ->
            val msg = "Token: $token"
            Log.d("FCM", msg)

        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel_name = "Notificaciones de prueba" //nombre canal
            val channel_description = "Probando notificaciones en una App de ejemplo" //descripción
            val importance =
                NotificationManager.IMPORTANCE_DEFAULT //Prioridad o importancia de la notificación
            val channel =
                NotificationChannel(
                    NORMAL_CHANNEL_ID,
                    channel_name,
                    importance
                ) //construye el canal
            channel.description = channel_description // añade una descripción
            val notificationManager = getSystemService(
                NotificationManager::class.java
            ) //Se obtiene el gestor de notificaciones
            notificationManager.createNotificationChannel(channel) //se crea el canal de notificaciones
        }
    }
}
