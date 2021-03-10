package com.gujun.jetpack.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gujun.database.entity.Student
import com.gujun.jetpack.repository.StudentRepository

/**
 *    author : gujun
 *    date   : 2021/3/9 13:33
 *    desc   :
 */
class StudentListViewModel(val app: Application) : AndroidViewModel(app) {

    private val repository: StudentRepository = StudentRepository(app, viewModelScope)

    fun addStudent(student: Student) {
        repository.addStudent(student)
    }

    fun updateStudentById(name: String, id: Long) {
        repository.updateStudentById(name, id)
    }

    fun deleteStudentById(id: Long) {
        repository.deleteStudentById(id)
    }

    fun getAllStudent(): LiveData<List<Student>> {
        return repository.getAllStudent()
    }

    private val content: ObservableField<String> = ObservableField("还没有数据")

    fun getContent(): ObservableField<String> {
        return content
    }

    fun updateContent(newValue: String) {
        content.set(newValue)
    }
}