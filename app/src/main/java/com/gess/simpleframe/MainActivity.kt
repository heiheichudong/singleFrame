package com.gess.simpleframe

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gess.core.base.SingleClickListener
import com.gess.simpleframe.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>() ,SingleClickListener,MainView{

    override fun getDataSucceed() {
        toast("sjdlkasjdlkasjdlasjdla;sjdlasjdlasjdl;j")
    }

    override fun initTitleBar() {

    }

    override fun initView() {

    }

    override fun getRootLayoutId(): Int = R.layout.activity_main

    override fun bindClickListenter() {

    }

    override fun click(v: View) {
        presenter!!.getData(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListener(this,tv_kotlin)

    }
}

fun Activity.toast(msg: String){
    Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
}
