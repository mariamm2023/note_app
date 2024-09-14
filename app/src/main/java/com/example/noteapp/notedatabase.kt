package com.example.noteapp

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.time.Instant

@Database(entities = [note::class], version = 2, exportSchema = false)
abstract class notedatabase:RoomDatabase() {
    abstract fun getnodedao():notedao
   companion object{
       @Volatile
       private var  Instances:notedatabase?=null
       fun getdatabase(context: Context):notedatabase{
           return Instances?: synchronized(this){
              val instance= Room.databaseBuilder(
                  context.applicationContext
                  ,notedatabase::class.java,"notedatabase").build()
               Instances=instance
               instance
           }
       }
   }
}