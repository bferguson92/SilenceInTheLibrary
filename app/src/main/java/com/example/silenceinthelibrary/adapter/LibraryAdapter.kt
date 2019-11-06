package com.example.silenceinthelibrary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.silenceinthelibrary.R
import com.example.silenceinthelibrary.model.Student

class LibraryAdapter(private val students: List<Student>) : RecyclerView.Adapter<LibraryAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false))
    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.apply {
            studentName.text = students[position].name
        }
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val studentName: TextView = view.findViewById(R.id.displayName)

    }
}