package com.gujun.jetpack.ui.activity

import android.content.Intent
import android.view.View
import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.jetpack.ui.activity.BaseJetPackActivity
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.viewmodel.MainActivityViewModel

/**
 *    author : gujun
 *    date   : 2021/3/1 15:47
 *    desc   :
 */
class MainActivity : BaseJetPackActivity(), View.OnClickListener {

    private lateinit var viewModel: MainActivityViewModel


    override fun initViewModel() {
        viewModel = getActivityViewModel(MainActivityViewModel::class.java)
    }

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig()
            .addVariableData(BR.viewModel, viewModel)
            .addVariableData(BR.click, this)
    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_main
    }

    override fun isSetImmersionBar(): Boolean {
        setImmersionBarDarkFont(true)
        setImmersionBarPadding(true)
        return true
    }

    override fun initView() {
        setTitle("我是MainActivity")
    }

    override fun initData() {

    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v.id) {
            R.id.toNavigationHost -> startActivity(Intent(this, NavigationHostActivity::class.java))
            R.id.toStudentList -> startActivity(Intent(this, StudentListActivity::class.java))
            R.id.toNetList -> startActivity(Intent(this, NetListActivity::class.java))
            R.id.updateContent -> viewModel.updateContent("我是新的数据")
        }

    }

    override fun showDefaultToolbar(): Boolean {
        return true
    }

}