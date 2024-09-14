package com.example.noteapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nots")
data class note(@ColumnInfo(name = "text")val text:String){
   @PrimaryKey(autoGenerate = true) var id=0
}