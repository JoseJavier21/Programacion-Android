package com.example.appampliable.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Repositorio::class], version = 1)
abstract class CircuitDataBase: RoomDatabase(){
        abstract fun CircuitInterface(): CircuitInterface

        companion object {
            const val DBNAME = "movie_database"

            @Volatile
            private var INSTANCE: CircuitDataBase? = null

            fun getDatabase(context: Context): CircuitDataBase {
                val tempInstance = INSTANCE
                if (tempInstance != null) {
                    return tempInstance
                }

                synchronized(CircuitDataBase::class) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        CircuitDataBase::class.java,
                        DBNAME
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }
        }
}
