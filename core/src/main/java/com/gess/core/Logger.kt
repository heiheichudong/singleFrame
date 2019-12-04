package com.gess.core

import android.util.Log

val PORJECT = "projectLog"
val mDubeg = BuildConfig.DEBUG

object Logger {

    @JvmStatic
    fun e(message: String) {
        if (mDubeg) {
            Log.e(PORJECT, message)
        }
    }

    @JvmStatic
    fun d(message: String) {
        if (mDubeg) {
            Log.d(PORJECT, message)
        }
    }
}
