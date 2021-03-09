package com.gujun.network.base

class ApiResponse<T>(
    var data: T?,
    var errorCode: Int,
    var errorMsg: String
)
