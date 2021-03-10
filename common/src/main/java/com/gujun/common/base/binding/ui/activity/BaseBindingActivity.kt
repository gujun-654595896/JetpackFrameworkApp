package com.gujun.common.base.binding.ui.activity

import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.ui.activity.BaseActivity

/**
 *    author : gujun
 *    date   : 2021/3/4 10:40
 *    desc   : DataBinding的基类
 */
abstract class BaseBindingActivity : BaseActivity() {

    private lateinit var binding: ViewDataBinding

    override fun getPageContentView(inflater: LayoutInflater): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), getLayoutId(), null, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    /**
     * 在一些简单的初始化完成后，设置布局的Variable值
     */
    override fun initOther() {
        super.initOther()
        val bindingVariableList = getBindingConfig()?.getVariableList()
        if (bindingVariableList != null) {
            for (i in 0 until bindingVariableList.size()) {
                binding.setVariable(
                    bindingVariableList.keyAt(i),
                    bindingVariableList.valueAt(i)
                )
            }
        }
    }

    /**
     * 此方法在initOther中使用，就是所有初始化完成后使用
     */
    abstract fun getBindingConfig(): BindingVariableConfig?

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

}