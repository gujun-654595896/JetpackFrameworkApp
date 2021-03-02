package com.gujun.common.base.application

import android.app.Application

/**
 *    author : gujun
 *    date   : 2021/3/2 11:41
 *    desc   : Application基类，做一些共用的初始化工作
 */
open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}