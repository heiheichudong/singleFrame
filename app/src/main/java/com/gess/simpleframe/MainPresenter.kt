package com.gess.simpleframe

import com.gess.simpleframe.base.BasePresenter

class MainPresenter :BasePresenter(){

    fun getData(view: MainView){
        view.getDataSucceed()
    }
}