package com.gess.simpleframe

import android.view.View
import android.widget.Toast
import com.gess.core.base.presenter.BaseActivityPersenter

class MainActivity : BaseActivityPersenter<MainDelegate>(), View.OnClickListener {
    override fun onClick(p0: View?) {
        Toast.makeText(this,"成功",Toast.LENGTH_LONG).show()
    }

    override fun bindEvenListener() {
        super.bindEvenListener()
        viewDelegate?.setOnClickListener(this, R.id.tv_kotlin)
    }
}
