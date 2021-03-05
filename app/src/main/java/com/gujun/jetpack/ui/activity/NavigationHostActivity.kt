package com.gujun.jetpack.ui.activity

import com.gujun.common.base.binding.ui.activity.BaseBindingActivity
import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.jetpack.BR
import com.gujun.jetpack.R

/**
 *    author : gujun
 *    date   : 2021/3/4 15:41
 *    desc   :
 */
class NavigationHostActivity : BaseBindingActivity() {

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig().addVariableData(BR.viewModel, "我是NavigationHostActivity")
    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_navigation_host
    }

    override fun isSetImmersionBar(): Boolean {
        setImmersionBarDarkFont(true)
        setImmersionBarPadding(true)
        return true
    }

    override fun initView() {

    }

    override fun initData() {

    }
}