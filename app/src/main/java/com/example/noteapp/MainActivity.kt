package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), noteAdapter.Idapter {
    lateinit var viewmodel:Noteviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview:RecyclerView
        recyclerview=findViewById(R.id.recyclerview)
        recyclerview.layoutManager=LinearLayoutManager(this)
        val adapter=noteAdapter(this)
        recyclerview.adapter=adapter
        viewmodel=ViewModelProvider(this).get(Noteviewmodel::class.java)
        viewmodel.alldate.observe(this, Observer {
            adapter.updatedatw(it)
        })
    }

    fun addnote(view: View) {
        val intent=Intent(this,addnoteactivity::class.java)
        startActivity(intent)
    }

    override fun onNoteclick(note: note) {
      viewmodel.deletnote(note)
    }
}