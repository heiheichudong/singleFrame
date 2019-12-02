package com.gess.core.themvp.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gess.core.themvp.utils.getT
import com.gess.core.themvp.view.IDelegate

open abstract class ActivityPersenter<T : IDelegate> : AppCompatActivity() {
    protected var viewDelegate: T?

    init {
        try {
            viewDelegate = getT<T>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IDelegate error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDelegate?.create(layoutInflater, null, savedInstanceState)
        setContentView(viewDelegate?.getRootView())
        viewDelegate?.initWidget()
        bindEvenListener()
    }

    open protected fun bindEvenListener() {}

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        try {
            viewDelegate = viewDelegate ?: getT<T>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IDelegate error")
        }
    }

    override fun onDestroy() {
        viewDelegate = null
        super.onDestroy()
    }
}