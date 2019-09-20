package com.gess.core.mvp.presenter

import com.gess.core.mvp.view.IView


interface IPresenter {

    var view:IView

    fun onDestroy()

}