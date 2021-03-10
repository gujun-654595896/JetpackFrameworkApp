package com.gujun.network.livedata

import androidx.lifecycle.LiveData
import com.gujun.network.base.ApiResponse
import com.gujun.network.base.ERROR_REQUEST_CODE
import com.gujun.network.base.ERROR_REQUEST_MSG
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 参考：https://juejin.cn/post/6844903917281607687#heading-1
 *
 * 将Retrofit的Call对象适配成LiveData
 */

class LiveDataCallAdapter<T>(private val responseType: Type) : CallAdapter<T, LiveData<T>> {
    override fun adapt(call: Call<T>): LiveData<T> {
        return object : LiveData<T>() {
            private val started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {//确保执行一次
                    call.enqueue(object : Callback<T> {
                        override fun onFailure(call: Call<T>, t: Throwable) {
                            val value = ApiResponse<T>(
                                null,
                                ERROR_REQUEST_CODE,
                                "$ERROR_REQUEST_MSG ${t.message ?: "UNKNOWN ERROR"}"
                            ) as T
                            postValue(value)
                        }

                        override fun onResponse(call: Call<T>, response: Response<T>) {
                            postValue(response.body())
                        }
                    })
                }
            }
        }
    }

    override fun responseType() = responseType
}
