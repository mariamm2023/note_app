package com.example.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class addnoteactivity : AppCompatActivity() {
    lateinit var viewmodel:Noteviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnoteactivity)
        val btn:Button=findViewById(R.id.addnote)
        viewmodel= ViewModelProvider(this).get(Noteviewmodel::class.java)

        btn.setOnClickListener {
            addnote()

        }
    }
    private fun addnote() {
        val editext:EditText=findViewById(R.id.input)
        val input=editext.text.toString()
        if(input.isNotEmpty()){
            viewmodel.insertnote(note(input))
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}