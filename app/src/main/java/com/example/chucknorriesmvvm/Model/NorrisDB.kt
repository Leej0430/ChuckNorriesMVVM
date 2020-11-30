package com.example.chucknorriesmvvm.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =[NorrisEntity::class],version = 1)
abstract class NorrisDB():RoomDatabase(){


    abstract fun getDao(): NorrisDao

    companion object{
        @Volatile
        private var INSTANCE: NorrisDB? = null

        fun getDatabase(context :  Context): NorrisDB{
            return INSTANCE ?: synchronized(this){
                var instance = Room.databaseBuilder(
                    context,
                    NorrisDB::class.java,
                    "norris db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
