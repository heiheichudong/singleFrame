package com.gess.core.http

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

fun OkHttpClient.Builder.connectTimeout(time:Long) = connectTimeout(time, TimeUnit.SECONDS)

fun OkHttpClient.Builder.readTimeout(time:Long) = readTimeout(time, TimeUnit.SECONDS)

fun OkHttpClient.Builder.writeTimeout(time:Long) = writeTimeout(time, TimeUnit.SECONDS)
