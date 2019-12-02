package com.gess.core.base

import android.view.View

open interface SingleClickListener : View.OnClickListener {

    fun click(v:View)

    override fun onClick(v: View) {
        v?.isEnabled = false
        v?.let { click(it) }
        v?.postDelayed({ v?.isEnabled = true }, 500)
    }
}