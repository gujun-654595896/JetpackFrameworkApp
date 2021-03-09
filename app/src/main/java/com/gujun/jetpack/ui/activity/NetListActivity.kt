package com.gujun.jetpack.ui.activity

import android.view.View
import androidx.lifecycle.Observer
import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.jetpack.ui.activity.BaseJetPackActivity
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.viewmodel.NetListViewModel

/**
 *    author : gujun
 *    date   : 2021/3/9 14:36
 *    desc   :
 */
class NetListActivity : BaseJetPackActivity(), View.OnClickListener {

    private lateinit var viewModel: NetListViewModel

    override fun initViewModel() {
        viewModel = getActivityViewModel(NetListViewModel::class.java)
    }

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig()
            .addVariableData(BR.viewModel, viewModel)
            .addVariableData(BR.click, this)
    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_net_list
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

    override fun initOther() {
        super.initOther()
        viewModel.getAllData().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.data?.forEach { item -> stringBuilder.append(item.title).append("\n") }
            viewModel.updateContent(stringBuilder.toString())
        })
    }

    override fun onClick(v: View?) {
        if (v == null) return
    }
}