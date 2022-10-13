package com.example.weatherapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.modelo.Tiempo
import com.example.weatherapp.room.Dao

@Database(entities = [Tiempo::class], version = 1)
abstract class BaseDatos : RoomDatabase(){
    abstract fun unoDao(): Dao

    companion object {
        const val nombrebasedatos = "wheaterbasedatos"

        @Volatile
        private var INSTANCE: BaseDatos? = null

        fun getDatabase(context: Context): BaseDatos {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(BaseDatos::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    nombrebasedatos
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}