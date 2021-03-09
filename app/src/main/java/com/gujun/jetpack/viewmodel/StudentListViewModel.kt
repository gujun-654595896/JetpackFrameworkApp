package com.gujun.jetpack.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.gujun.database.db.entity.Student
import com.gujun.database.repository.StudentRepository
import kotlinx.coroutines.launch

/**
 *    author : gujun
 *    date   : 2021/3/9 13:33
 *    desc   :
 */
class StudentListViewModel(val app: Application) : AndroidViewModel(app) {

    private val repository: StudentRepository = StudentRepository(app)

    fun addStudent(student: Student) {
        viewModelScope.launch {
            repository.addStudent(student)
        }
    }

    fun updateStudentById(name: String, id: Long) {
        viewModelScope.launch {
            repository.updateStudentById(name, id)
        }
    }

    fun deleteStudentById(id: Long) {
        viewModelScope.launch {
            repository.deleteStudentById(id)
        }
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