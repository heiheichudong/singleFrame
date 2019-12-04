package com.gess.core.http

import com.gess.core.Logger
import com.gess.core.http.assist.httpClient
import okhttp3.Interceptor
import okio.Buffer
import java.nio.charset.Charset

val okHttpClient = httpClient {
    token = "token"
    connectTimeout = TIMEOUT_CONNECTION
    readTimeout = TIMEOUT_READ
    writeTimeout = TIMEOUT_WRITE
    retryOnConnectionFailure = true
}

fun handle(chain: Interceptor.Chain) {
    val body = chain.request().body
    var requestStr = ""
    body?.apply {
        if (contentType().toString().contains("multipart")) {
            val buffer = Buffer()
            writeTo(buffer)
            var charset = Charset.forName("UTF-8")
            charset = contentType()?.charset(charset)
            requestStr = buffer.readString(charset)
        }

        Logger.e("*********************************************************************************************************")
        Logger.e("* 请求方式：" + chain.request().method)
        Logger.e("* 请求链接：" + chain.request().url)
        Logger.e("* 请求头部：" + chain.request().headers)
        Logger.e("* 请求体：  $requestStr")
        Logger.e("*********************************************************************************************************")
    }
}


fun http(block: () -> Unit) {

}