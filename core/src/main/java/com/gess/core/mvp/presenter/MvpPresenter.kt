package com.gess.core.mvp.presenter

import com.gess.core.mvp.view.IView

class MvpPresenter(override var view: IView) :IPresenter {

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}