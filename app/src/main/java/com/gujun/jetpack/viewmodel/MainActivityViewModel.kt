package com.gujun.jetpack.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 *    author : gujun
 *    date   : 2021/3/4 16:03
 *    desc   : Main页面对应的ViewModel
 */
class MainActivityViewModel : ViewModel() {

    private val content: ObservableField<String> = ObservableField("我是MainActivity")

    fun getContent(): ObservableField<String> {
        return content
    }

    fun updateContent(newValue: String) {
        content.set(newValue)
    }

}