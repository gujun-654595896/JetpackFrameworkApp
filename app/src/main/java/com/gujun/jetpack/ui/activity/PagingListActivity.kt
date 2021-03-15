package com.gujun.jetpack.ui.activity

import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.jetpack.ui.activity.BaseJetPackActivity
import com.gujun.database.entity.Student
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.viewmodel.PagingListViewModel
import kotlinx.android.synthetic.main.app_activity_paging_list.*

/**
 *    author : gujun
 *    date   : 2021/3/11 16:04
 *    desc   :
 */
class PagingListActivity : BaseJetPackActivity() {

    private lateinit var viewModel: PagingListViewModel

    override fun initViewModel() {
        viewModel = getActivityAndroidViewModel(PagingListViewModel::class.java)
    }

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig()
            .addVariableData(BR.viewModel, viewModel)
    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_paging_list
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initOther() {
        super.initOther()
        viewModel.showData(this)
    }

    override fun isSetImmersionBar(): Boolean {
        return false
    }

}