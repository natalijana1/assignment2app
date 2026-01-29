package com.example.assignment2app.ui.studentslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2app.R
import com.example.assignment2app.model.Student

class StudentAdapter(
    private val students: List<Student>,
    private val onItemClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTxt: TextView = itemView.findViewById(R.id.txt_name)
        private val idTxt: TextView = itemView.findViewById(R.id.txt_id)
        private val checkBox: CheckBox = itemView.findViewById(R.id.checkbox_student)
        private val image: ImageView = itemView.findViewById(R.id.img_student)

        fun bind(student: Student) {
            nameTxt.text = student.name
            idTxt.text = student.id
            if (student.imageResId != null) {
                image.setImageResource(student.imageResId!!)
            } else {
                image.setImageResource(R.drawable.student_placeholder)
            }

            checkBox.setOnCheckedChangeListener(null)
            checkBox.isChecked = student.isChecked
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }

            itemView.setOnClickListener {
                onItemClick(student)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size
}
