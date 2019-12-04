package com.gess.core.http.assist

import okhttp3.OkHttpClient
import retrofit2.Converter

class HttpClient(
    var token: String = "",
    var connectTimeout: Long = 60,
    var readTimeout: Long = 60,
    var writeTimeout: Long = 60,
    var retryOnConnectionFailure: Boolean = true
)

class RxService<T>(
    var clazz: Class<T>,
    var url: String,
    var factory: Converter.Factory,
    var okHttpClient: OkHttpClient
)

