package com.gujun.common.base.binding.ui.config

import android.util.SparseArray


/**
 *    author : gujun
 *    date   : 2021/3/4 13:19
 *    desc   : DataBinding 对应布局中<variable标签的列表数据，SparseArray中Key：variable对应的BR值，value:variable对应的值
 *    一般存放ViewModel 和 一些监听回调，具体的数据就存放在ViewModel中
 */
class BindingVariableConfig {

    private val variableList: SparseArray<Any> = SparseArray()

    fun addVariableData(variableBR: Int, variableValue: Any): BindingVariableConfig {
        variableList.append(variableBR, variableValue)
        return this
    }

    fun getVariableList(): SparseArray<Any> {
        return variableList
    }

}