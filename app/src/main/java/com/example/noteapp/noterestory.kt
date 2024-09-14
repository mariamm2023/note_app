package com.example.noteapp

class noterestory(private val Notedao:notedao) {
    val allnote=Notedao.getalldate()
    suspend fun insert(note: note){
        Notedao.insert(note)
    }
    suspend fun delet(note: note){
        Notedao.delet(note)
    }
}