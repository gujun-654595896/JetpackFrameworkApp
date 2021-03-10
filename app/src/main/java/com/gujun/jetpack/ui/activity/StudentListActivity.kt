package com.gujun.jetpack.ui.activity

import android.view.View
import androidx.lifecycle.Observer
import com.gujun.common.base.binding.ui.config.BindingVariableConfig
import com.gujun.common.base.jetpack.ui.activity.BaseJetPackActivity
import com.gujun.database.entity.Student
import com.gujun.jetpack.BR
import com.gujun.jetpack.R
import com.gujun.jetpack.viewmodel.StudentListViewModel

/**
 *    author : gujun
 *    date   : 2021/3/9 14:36
 *    desc   :
 */
class StudentListActivity : BaseJetPackActivity(), View.OnClickListener {

    private lateinit var viewModel: StudentListViewModel

    override fun initViewModel() {
        viewModel = getActivityAndroidViewModel(StudentListViewModel::class.java)
    }

    override fun getBindingConfig(): BindingVariableConfig? {
        return BindingVariableConfig()
            .addVariableData(BR.viewModel, viewModel)
            .addVariableData(BR.click, this)
    }

    override fun getLayoutId(): Int {
        return R.layout.app_activity_student_list
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
        viewModel.getAllStudent().observe(this, Observer {
            val stringBuilder = StringBuilder()
            it.forEach { item -> stringBuilder.append(item.name).append("\n") }
            viewModel.updateContent(stringBuilder.toString())
        })
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v.id) {
            R.id.add -> {
                for (i in 0..10) {
                    val student =
                        Student(sid = i.toLong(), name = "我是$i", age = 10)
                    viewModel.addStudent(student)
                }
            }
            R.id.delete -> {
                viewModel.deleteStudentById(5)
            }
            R.id.update -> {
                viewModel.updateStudentById("我是新2", 2)
            }
        }
    }
}