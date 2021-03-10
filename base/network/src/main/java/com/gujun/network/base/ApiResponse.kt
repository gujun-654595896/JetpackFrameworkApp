package com.gujun.network.base

const val ERROR_REQUEST_CODE = -1
const val ERROR_REQUEST_MSG = "接口请求失败："

class ApiResponse<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String
)
