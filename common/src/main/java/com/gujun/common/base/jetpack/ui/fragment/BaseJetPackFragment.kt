package com.gujun.common.base.jetpack.ui.fragment

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.gujun.common.base.application.BaseApplication
import com.gujun.common.base.binding.ui.fragment.BaseBindingFragment

/**
 *    author : gujun
 *    date   : 2021/3/4 14:30
 *    desc   : JetPack的基类
 */
abstract class BaseJetPackFragment : BaseBindingFragment() {

    override fun initOther() {
        initViewModel()
        super.initOther()
        //统一管理Fragment的生命周期方法，如果项目中用到了就打开，否则就先不用以免添加太多的观察者
//        lifecycle.addObserver(FragmentLifecycleReceiver())
    }

    /**
     * Fragment作为ViewModel的生命周期
     */
    fun <T : ViewModel> getFragmentViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(modelClass)
    }

    /**
     * Fragment作为AndroidViewModel的生命周期
     */
    fun <T : ViewModel> getFragmentAndroidViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(this.requireActivity().application)
        ).get(modelClass)
    }

    /**
     * Activity作为ViewModel的生命周期
     */
    fun <T : ViewModel> getActivityViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(modelClass)
    }

    /**
     * Activity作为AndroidViewModel的生命周期
     */
    fun <T : ViewModel> getActivityAndroidViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(modelClass)
    }

    /**
     * Application作为ViewModel的生命周期
     */
    fun <T : ViewModel> getApplicationViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            requireActivity().application as BaseApplication,
            ViewModelProvider.NewInstanceFactory()
        ).get(modelClass)
    }

    /**
     * Application作为AndroidViewModel的生命周期
     */
    fun <T : ViewModel> getApplicationAndroidViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(
            requireActivity().application as BaseApplication,
            ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
        ).get(modelClass)
    }

    /**
     * 获取导航控制器，activity
     * viewId 为 host fragment id,在Activity布局中对应的<fragment标签下的id
     */
    fun getNavControllerByActivity(activity: Activity, viewId: Int): NavController {
        return Navigation.findNavController(activity, viewId)
    }

    /**
     * 获取导航控制器，fragment
     */
    fun getNavControllerByFragment(fragment: Fragment): NavController {
        return NavHostFragment.findNavController(fragment)
    }

    /**
     * 获取导航控制器，View
     */
    fun getNavControllerByView(view: View): NavController {
        return Navigation.findNavController(view)
    }

    /**
     * 初始化ViewModel
     */
    abstract fun initViewModel()

}