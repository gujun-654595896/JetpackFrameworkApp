package com.gujun.jetpack.ui.fragment

import android.view.View
import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.jetpack.ui.fragment.BaseJetPackFragment
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.viewmodel.OneFragmentViewModel

/**
 *    author : gujun
 *    date   : 2021/3/4 16:31
 *    desc   :
 */
class OneFragment : BaseJetPackFragment(), View.OnClickListener {

    private lateinit var viewModel: OneFragmentViewModel


    override fun initViewModel() {
        viewModel = getActivityViewModel(OneFragmentViewModel::class.java)
    }

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig()
            .addVariableData(BR.viewModel, viewModel)
            .addVariableData(BR.click, this)
    }

    override fun getLayoutId(): Int {
        return R.layout.app_fragmen_one
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v.id) {
            R.id.toTowFragment -> getNavControllerByFragment(this).navigate(R.id.app_action_app_onefragment_to_app_twofragment)
        }
    }
}