package com.gess.core.themvp.view

import android.app.Activity
import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


open abstract class AppDelegate : IDelegate {
    protected val mViews = SparseArray<View>()
    protected lateinit var decorView:View
    abstract fun getRootLayoutId(): Int

    override fun create(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) {
        decorView = inflater.inflate(getRootLayoutId(), container, false)
    }

    fun <T : View> bindView(id:Int): T {
        var view = if(mViews[id] != null){
            mViews[id]
        }else{
            mViews.put(id, decorView.findViewById(id))
            decorView.findViewById(id)
        }
        return view as T
    }

    fun <T:View> get(id: Int):T = bindView(id)

    fun setOnClickListener(listener:View.OnClickListener,vararg ids: Int) {
        ids.forEach { get<View>(it).setOnClickListener(listener)}
    }

    fun <T:Activity>getActivity():T =  decorView.context as T

    override fun getRootView() = decorView

}

