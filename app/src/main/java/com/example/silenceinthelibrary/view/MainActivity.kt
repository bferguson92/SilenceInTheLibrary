package com.example.silenceinthelibrary.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.silenceinthelibrary.R
import com.example.silenceinthelibrary.adapter.LibraryAdapter
import com.example.silenceinthelibrary.model.Student
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var libraryAdapter: LibraryAdapter
    private var students: MutableList<Student> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        databaseReference = FirebaseDatabase
            .getInstance()
            .reference
            .child("students")

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                students.clear()
                for(student in dataSnapshot.children) {
                    val newStudent = student.getValue(Student::class.java)
                    if(newStudent != null)
                        students.add(newStudent)
                }
            }

        })

        libraryAdapter = LibraryAdapter(students)

        studentList.adapter = libraryAdapter
        studentList.layoutManager = LinearLayoutManager(this)


        enterButton.setOnClickListener {
            val student = Student(enterStudent.text.toString())
            students.add(student)

            databaseReference.push().setValue(student)

            enterStudent.text.clear()

            Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show()
            libraryAdapter.notifyDataSetChanged()
        }
    }


}
