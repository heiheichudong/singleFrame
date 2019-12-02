package com.gess.core.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gess.core.mvp.presenter.IPresenter
import com.gess.core.themvp.utils.getT

open abstract class MvpActivity<P:IPresenter> : AppCompatActivity(),IView {

    protected var presenter: P?

    init {
        try {
            presenter = getT<P>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IPresenter error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getRootLayoutId())
        initTitleBar()
        initView()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        try {
            presenter = presenter ?: getT<P>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IPresenter error")
        }
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        presenter = null
        super.onDestroy()
    }

    abstract fun getRootLayoutId() :Int

}