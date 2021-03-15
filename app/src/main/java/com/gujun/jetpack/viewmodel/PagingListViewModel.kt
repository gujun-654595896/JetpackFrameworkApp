package com.gujun.jetpack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.gujun.database.entity.Student
import com.gujun.jetpack.repository.PagingListRepository
import com.gujun.jetpack.ui.adapter.BindingListAdapter
import com.gujun.jetpack.ui.adapter.RecyclerListAdapter

/**
 *    author : gujun
 *    date   : 2021/3/12 10:53
 *    desc   :
 */
class PagingListViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: PagingListRepository = PagingListRepository(app, viewModelScope)

    private val adapter = BindingListAdapter()

    fun getAdapter(): BindingListAdapter {
        return adapter
    }

    fun addStudent(student: Student) {
        repository.addStudent(student)
    }

    fun showData(owner: LifecycleOwner) {
        repository.getAllStudent().observe(owner, Observer {
            adapter.submitList(it)
        })
    }

}