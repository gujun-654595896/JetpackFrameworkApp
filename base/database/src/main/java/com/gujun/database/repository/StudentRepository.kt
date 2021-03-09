package com.gujun.database.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.gujun.database.db.entity.Student
import com.gujun.database.db.helper.DatabaseHelper

/**
 *    author : gujun
 *    date   : 2021/3/9 13:48
 *    desc   : Repository是一个独立的层，介于领域层与数据映射层（数据访问层）之间。
 *    它的存在让领域层感觉不到数据访问层的存在，它提供一个类似集合的接口提供给领域层进行领域对象的访问。
 *    Repository是仓库管理员，领域层需要什么东西只需告诉仓库管理员，由仓库管理员把东西拿给它，并不需要知道东西实际放在哪。
 */
class StudentRepository(private val context: Context) {

    private val studentDao = DatabaseHelper.getInstance(context).getStudentDao()

    suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    suspend fun updateStudentById(name: String, id: Long) {
        studentDao.updateStudentById(name, id)
    }

    suspend fun deleteStudentById(id: Long) {
        studentDao.deleteStudentById(id)
    }

    fun getAllStudent(): LiveData<List<Student>> {
        return studentDao.getAllStudent()
    }

}