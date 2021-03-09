package com.gujun.network

import androidx.lifecycle.LiveData
import com.gujun.network.base.ApiResponse
import com.gujun.network.model.BannerVO
import retrofit2.http.GET

/**
 *    author : gujun
 *    date   : 2020/10/21 14:15
 *    desc   : 请求接口
 */
interface ApiService {

    companion object {
        const val baseUrl = "https://www.wanandroid.com/"
    }

    @GET("banner/json")
    fun bannerList(): LiveData<ApiResponse<List<BannerVO>>>

}