package com.gess.simpleframe

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gess.core.base.SingleClickListener
import com.gess.core.http.TIMEOUT_CONNECTION
import com.gess.core.http.TIMEOUT_READ
import com.gess.core.http.TIMEOUT_WRITE
import com.gess.core.http.assist.httpClient
import com.gess.core.http.assist.rxService
import com.gess.core.http.service.BaseService
import com.gess.simpleframe.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.textView

class MainActivity : BaseActivity<MainPresenter>(), SingleClickListener, MainView {

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
        setOnClickListener(this, tv_kotlin)
        val view = linearLayout {
            textView {
                text = "dsl"
            }
        }
        testHttp()

    }

    private fun testHttp() {
        rxService<BaseService> {

            httpClient {
                token = "token"
                connectTimeout = TIMEOUT_CONNECTION
                readTimeout = TIMEOUT_READ
                writeTimeout = TIMEOUT_WRITE
                retryOnConnectionFailure = true
            }
        }
    }
}

fun Activity.toast(msg: String) {
    Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
}
