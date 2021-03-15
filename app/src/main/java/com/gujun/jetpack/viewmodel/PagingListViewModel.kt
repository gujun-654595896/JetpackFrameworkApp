package com.gujun.jetpack.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.gujun.jetpack.repository.PagingListRepository
import com.gujun.jetpack.ui.adapter.PagingListAdapter
import kotlinx.coroutines.launch

/**
 *    author : gujun
 *    date   : 2021/3/12 10:53
 *    desc   :
 */
class PagingListViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: PagingListRepository = PagingListRepository(app, viewModelScope)

    private val adapter = PagingListAdapter()

    fun getAdapter(): PagingListAdapter {
        return adapter
    }

    fun showData(owner: LifecycleOwner) {
        repository.getAllData(viewModelScope).observe(owner, Observer {
            viewModelScope.launch {
                adapter.submitData(it)
            }
        })
    }

}