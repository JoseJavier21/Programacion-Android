package com.example.weatherapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weatherapp.modelo.Tiempo

@Database(entities = [Tiempo::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun Dao(): Dao
    companion object{

        const val DBNAME = "cerveza_database"

        @Volatile
        private var INSTANCE: com.example.weatherapp.room.Database? = null

        fun getDatabase(context: Context): com.example.weatherapp.room.Database {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(com.example.weatherapp.room.Database::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    com.example.weatherapp.room.Database::class.java,
                    DBNAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }



    }
}