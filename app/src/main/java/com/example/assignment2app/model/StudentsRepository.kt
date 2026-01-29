package com.example.assignment2app.model

object StudentsRepository {

    val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(student: Student) {
    }

    fun deleteStudent(student: Student) {
        students.remove(student)
    }

    fun getStudentById(id: String): Student? {
        return students.find { it.id == id }
    }
}
