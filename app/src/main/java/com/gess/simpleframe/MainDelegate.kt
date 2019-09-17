package com.gess.simpleframe

import android.app.Activity
import com.gess.core.base.view.BaseDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainDelegate : BaseDelegate(){

    override fun getRootLayoutId(): Int = R.layout.activity_main

    override fun getOptionsMenuId(): Int = 0

    override fun initWidget() {
        getActivity<Activity>().tv_kotlin.text = "sssasdassd"
    }

}