package com.gujun.jetpack.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 *    author : gujun
 *    date   : 2021/3/4 16:03
 *    desc   : TwoFragment页面对应的ViewModel
 */
class TwoFragmentViewModel : ViewModel() {

    private val content: ObservableField<String> = ObservableField("我是TwoFragment")

    fun getContent(): ObservableField<String> {
        return content
    }

    fun updateContent(newValue: String) {
        content.set(newValue)
    }

}