package com.gess.core.mvp.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.gess.core.base.utils.getT
import com.gess.core.mvp.presenter.IPresenter

open abstract class MvpActivity<P:IPresenter> : AppCompatActivity(),IView {


    protected var presenter: P?

    init {
        try {
            presenter = getT<P>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IDelegate error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        presenter!!.view = this
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        try {
            presenter = presenter ?: getT<P>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IDelegate error")
        }
    }

    override fun onDestroy() {
        presenter?.onDestroy()
        super.onDestroy()
    }

}