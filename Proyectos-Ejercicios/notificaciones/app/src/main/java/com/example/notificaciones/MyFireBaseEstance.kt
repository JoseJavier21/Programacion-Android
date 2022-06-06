package com.example.notificaciones

import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFireBaseEstance : FirebaseMessagingService(){

    override fun onMessageReceived(message: RemoteMessage){
        super.onMessageReceived(message)

        //UNA FORMA DE CREAR LA NOTIFIACION, DEFAULT DEL SISTEMA
//        if(message.notification != null){}
//                message.notification?.let{
//                    val title = it.title
//                    val body = it.body
//                }

        //UNA FORMA DE CREAR LA NOTIFIACION, PERSONALIZA
        if (message.data.isNotEmpty()){
            val title = message.data["title"]
            val body = message.data["body"]

            if (title != null && body != null)
            {
                notifBasic(title, body)
            }
        }
    }

    private fun notifBasic(title: String, body: String) {
        val builder = NotificationCompat.Builder(this, NORMAL_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_stat_name) //icono pequeño
            .setContentTitle(title) //titulo
            .setContentText(body) //texto
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //prioridad para android 7.1 y anteriores
        val notificationManager =
            NotificationManagerCompat.from(this) //llamamos al gestor de notificaciones
        notificationManager.notify(
            1,
            builder.build()
        ) //lanzamos con el gestor la notificación, bajo una id que la identifica
    }


    override fun onNewToken(token: String) {
        super.onNewToken(token)

      Log.d("", "Token: $token")


    }
}