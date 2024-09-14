package com.example.noteapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
class Noteviewmodel(application: Application) :AndroidViewModel(application) {
    val alldate:LiveData<List<note>>
    private val repros:noterestory
    init {
        val dao=notedatabase.getdatabase(application).getnodedao()
        repros=noterestory(dao)
        alldate=repros.allnote
    }
    fun insertnote(note:note)=viewModelScope.launch(Dispatchers.IO) {
        repros.insert(note)

    }
    fun deletnote(note:note)=viewModelScope.launch(Dispatchers.IO) {
        repros.delet(note)

    }


}