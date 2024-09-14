package com.example.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.ArrayList
import java.util.EventListener

class noteAdapter(val listener:Idapter):RecyclerView.Adapter<noteAdapter.noteviewholder>() {
    private val allnotes=ArrayList<note>()
    class noteviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview: TextView = itemView.findViewById(R.id.text)
        val delet: ImageView = itemView.findViewById(R.id.delet)
    }

    override fun getItemCount(): Int {
        return allnotes.size
    }

    override fun onBindViewHolder(holder: noteviewholder, position: Int) {
        val surrentdata=allnotes[position]
        holder.textview.text=surrentdata.text


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): noteviewholder {
      val viewholder=noteviewholder(LayoutInflater.from(parent.context).inflate(R.layout.itemnote,parent,false))
        viewholder.delet.setOnClickListener {
            listener.onNoteclick(allnotes[viewholder.adapterPosition])
        }
        return viewholder
    }
    interface Idapter{
        fun onNoteclick(note: note)

    }
    fun updatedatw(newdata:List<note>){
        allnotes.clear()
        allnotes.addAll(newdata)
        notifyDataSetChanged()


    }


}