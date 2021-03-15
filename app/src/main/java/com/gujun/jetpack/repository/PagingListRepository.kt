package com.gujun.jetpack.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.asLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.gujun.database.entity.Student
import com.gujun.database.helper.DatabaseHelper
import com.gujun.jetpack.datasource.PagingListDataSource
import com.gujun.jetpack.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 *    author : gujun
 *    date   : 2021/3/9 13:48
 *    desc   : Repository是一个独立的层，介于领域层与数据映射层（数据访问层）之间。
 *    它的存在让领域层感觉不到数据访问层的存在，它提供一个类似集合的接口提供给领域层进行领域对象的访问。
 *    Repository是仓库管理员，领域层需要什么东西只需告诉仓库管理员，由仓库管理员把东西拿给它，并不需要知道东西实际放在哪。
 *
 *    不管从网络获取数据还是从本地数据库都经过仓库，如果使用paging那么此处还得添加从paging的dataSource获取数据的逻辑
 */
class PagingListRepository(
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {

    private val studentDao = DatabaseHelper.getInstance(context).getStudentDao()

    fun addStudent(student: Student) {
        coroutineScope.launch {
            studentDao.addStudent(student)
        }
    }

    fun getAllStudent(): LiveData<List<User>> {
        return Transformations.switchMap(studentDao.getAllStudent()) {
            val newList = ArrayList<User>()
            it.forEach { item -> newList.add(User(item.name, item.sid.toInt())) }
            MutableLiveData<List<User>>(newList)
        }
    }

    fun getAllData(viewModelScope: CoroutineScope) =
        Pager(PagingConfig(20, 10, true, 20), initialKey = 0) {
            PagingListDataSource()
        }
            .flow//Paging3使用flow传递数据
            .cachedIn(viewModelScope)//绑定协程生命周期，必须加上，否则可能崩溃
            .asLiveData(viewModelScope.coroutineContext)//使用LiveData

}