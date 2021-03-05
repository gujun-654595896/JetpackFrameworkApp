package com.gujun.jetpack.ui.fragment

import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.jetpack.ui.fragment.BaseJetPackFragment
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.viewmodel.TwoFragmentViewModel

/**
 *    author : gujun
 *    date   : 2021/3/4 16:31
 *    desc   :
 */
class TwoFragment : BaseJetPackFragment() {

    private lateinit var viewModel: TwoFragmentViewModel


    override fun initViewModel() {
        viewModel = getActivityViewModel(TwoFragmentViewModel::class.java)
    }

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig()
            .addVariableData(BR.viewModel, viewModel)
    }

    override fun getLayoutId(): Int {
        return R.layout.app_fragmen_two
    }

    override fun initView() {
    }

    override fun initData() {
    }
}