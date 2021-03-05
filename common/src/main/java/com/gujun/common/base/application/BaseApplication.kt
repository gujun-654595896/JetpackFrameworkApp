package com.gujun.common.base.application

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

/**
 *    author : gujun
 *    date   : 2021/3/2 11:41
 *    desc   : Application基类，做一些共用的初始化工作
 */
open class BaseApplication : Application(), ViewModelStoreOwner {

    //ViewModelStore管理Application生命周期长度的ViewModel
    private var viewModelStore = ViewModelStore()

    override fun onCreate() {
        super.onCreate()
    }

    override fun getViewModelStore(): ViewModelStore {
        return viewModelStore
    }
}