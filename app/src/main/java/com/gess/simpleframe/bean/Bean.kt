package com.gess.simpleframe.bean

data class User(var name: String, var phone: String)

data class HttpResult<T>(var code: Int, var msg: String, var key: String, var data: T)