package com.example.assignment2apptemp.ui.studentslist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2app.R
import com.example.assignment2app.model.StudentsRepository
import com.example.assignment2app.ui.details.StudentDetailsActivity
import com.example.assignment2app.ui.newstudent.NewStudentActivity

class StudentsListActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        setupRecycler()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        findViewById<Button>(R.id.btn_add_student).setOnClickListener {
            startActivity(Intent(this, NewStudentActivity::class.java))
        }
    }

    private fun setupRecycler() {
        val recycler = findViewById<RecyclerView>(R.id.recycler_students)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = StudentAdapter(StudentsRepository.students) { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("STUDENT_ID", student.id)
            startActivity(intent)
        }
    }
}