package com.example.assignment2app.ui.details

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2app.R
import com.example.assignment2app.model.StudentsRepository
import com.example.assignment2app.ui.edit.EditStudentActivity

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var studentId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentId = intent.getStringExtra("STUDENT_ID") ?: return

        findViewById<Button>(R.id.btn_edit).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_ID", studentId)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadStudent()
    }

    private fun loadStudent() {
        val student = StudentsRepository.getStudentById(studentId) ?: return

        val imageView = findViewById<ImageView>(R.id.img_student)
        if (student.imageResId != null) {
            imageView.setImageResource(student.imageResId!!)
        } else {
            imageView.setImageResource(R.drawable.student_placeholder)
        }

        findViewById<TextView>(R.id.txt_name).text = student.name
        findViewById<TextView>(R.id.txt_id).text = student.id
        findViewById<TextView>(R.id.txt_phone).text = student.phone
        findViewById<TextView>(R.id.txt_address).text = student.address
    }
}
