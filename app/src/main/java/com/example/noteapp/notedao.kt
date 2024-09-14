package com.example.noteapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.selects.select
@Dao
abstract class notedao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(note:note)
    @Delete
    abstract suspend fun delet(note:note)
    @Query("select  * from nots")
   abstract  fun getalldate():LiveData<List<note>>
}