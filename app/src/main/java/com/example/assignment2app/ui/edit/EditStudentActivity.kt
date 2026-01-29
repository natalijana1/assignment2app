package com.example.assignment2app.ui.edit

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2app.R
import com.example.assignment2app.model.StudentsRepository

class EditStudentActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val studentId = intent.getStringExtra("STUDENT_ID") ?: return
        val student = StudentsRepository.getStudentById(studentId) ?: return

        val nameEt = findViewById<EditText>(R.id.et_name)
        val idEt = findViewById<EditText>(R.id.et_id)
        val phoneEt = findViewById<EditText>(R.id.et_phone)
        val addressEt = findViewById<EditText>(R.id.et_address)

        val saveBtn = findViewById<Button>(R.id.btn_save)
        val deleteBtn = findViewById<Button>(R.id.btn_delete)

        nameEt.setText(student.name)
        idEt.setText(student.id)
        phoneEt.setText(student.phone)
        addressEt.setText(student.address)

        saveBtn.setOnClickListener {
            student.name = nameEt.text.toString()
            student.id = idEt.text.toString()
            student.phone = phoneEt.text.toString()
            student.address = addressEt.text.toString()

            StudentsRepository.updateStudent(student)
            finish()
        }

        deleteBtn.setOnClickListener {
            StudentsRepository.deleteStudent(student)
            finish()
        }

    }
}