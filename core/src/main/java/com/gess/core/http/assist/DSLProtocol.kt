package com.gess.core.http.assist

import com.gess.core.http.connectTimeout
import com.gess.core.http.handle
import com.gess.core.http.readTimeout
import com.gess.core.http.writeTimeout
import okhttp3.OkHttpClient

fun httpClient(block: HttpClient.() -> Unit): OkHttpClient {
    val httpClient = HttpClient()
    val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor {
            handle(it)
            it.proceed(it.request().newBuilder().addHeader("token", httpClient.token).build())
        }
        .connectTimeout(httpClient.connectTimeout)
        .readTimeout(httpClient.connectTimeout)
        .writeTimeout(httpClient.connectTimeout)
        .retryOnConnectionFailure(true)
        .build()
    httpClient.block()
    return okHttpClient
}

fun <T> rxService(block: RxService<T>.() -> Unit){

}
