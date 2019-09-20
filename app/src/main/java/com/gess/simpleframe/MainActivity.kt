package com.gess.simpleframe

import android.app.Activity
import android.view.View
import android.widget.Toast
import com.gess.core.base.presenter.BaseActivityPersenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivityPersenter<MainDelegate>(), View.OnClickListener {
    override fun onClick(p0: View?) {
       toast("succeed")
        tv_kotlin.text = "import kotlinx.android.synthetic.main.activity_main.*"
    }

    override fun bindEvenListener() {
        super.bindEvenListener()
        viewDelegate?.setOnClickListener(this, R.id.tv_kotlin)
    }


    override fun onDestroy() {
        super.onDestroy()
    }
}

fun Activity.toast(msg: String){
    Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
}
