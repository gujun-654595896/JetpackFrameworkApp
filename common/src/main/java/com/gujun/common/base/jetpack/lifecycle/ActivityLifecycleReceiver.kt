package com.gujun.common.base.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 *    author : gujun
 *    date   : 2021/3/4 15:00
 *    desc   : 处理一些Activity生命周期的相同逻辑
 */
class ActivityLifecycleReceiver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public fun onCreateMethod() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public fun onResumeMethod() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public fun onDestroyMethod() {
    }

}