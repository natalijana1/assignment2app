package com.example.assignment2app.ui.newstudent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment2app.R
import com.example.assignment2app.model.Student
import com.example.assignment2app.model.StudentsRepository

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val nameEt = findViewById<EditText>(R.id.et_name)
        val idEt = findViewById<EditText>(R.id.et_id)
        val phoneEt = findViewById<EditText>(R.id.et_phone)
        val addressEt = findViewById<EditText>(R.id.et_address)

        findViewById<Button>(R.id.btn_save).setOnClickListener {
            StudentsRepository.addStudent(
                Student(
                    idEt.text.toString(),
                    nameEt.text.toString(),
                    phoneEt.text.toString(),
                    addressEt.text.toString(),
                    R.drawable.student_pic,
                    false
                )
            )
            finish()
        }
    }
}
