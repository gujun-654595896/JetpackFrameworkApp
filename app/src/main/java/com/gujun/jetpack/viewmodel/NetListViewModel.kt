package com.gujun.jetpack.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gujun.network.Requester
import com.gujun.network.base.ApiResponse
import com.gujun.network.model.BannerVO

/**
 *    author : gujun
 *    date   : 2021/3/9 13:33
 *    desc   :
 */
class NetListViewModel : ViewModel() {

    fun getAllData(): LiveData<ApiResponse<List<BannerVO>>> {
        return Requester.apiService().bannerList()
    }

    private val content: ObservableField<String> = ObservableField("还没有数据")

    fun getContent(): ObservableField<String> {
        return content
    }

    fun updateContent(newValue: String) {
        content.set(newValue)
    }
}