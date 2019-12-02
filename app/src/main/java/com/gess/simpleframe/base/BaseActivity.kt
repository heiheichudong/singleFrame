package com.gess.simpleframe.base

import android.os.Bundle
import android.view.View
import com.gess.core.base.SingleClickListener
import com.gess.core.mvp.presenter.IPresenter
import com.gess.core.mvp.view.MvpActivity

open abstract class BaseActivity<P:IPresenter> :MvpActivity<P>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindClickListenter()
    }
    abstract fun bindClickListenter()

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    fun setOnClickListener(listener:SingleClickListener,vararg ids:View){
        ids.forEach { it.setOnClickListener (listener) }
    }
}