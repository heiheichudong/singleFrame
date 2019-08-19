package com.gess.core.base.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gess.core.base.utils.getT
import com.gess.core.base.view.IDelegate



class FragmentPersenter <T : IDelegate> : Fragment(){
    protected var viewDelegate: T?

    init {
        try {
            viewDelegate = getT<T>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IDelegate error")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewDelegate?.create(inflater, container, savedInstanceState)
        return viewDelegate?.getRootView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDelegate?.initWidget()
        bindEvenListener()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        try {
            viewDelegate = viewDelegate ?: getT<T>(this, 0)
        } catch (e: Exception) {
            throw RuntimeException("create IDelegate error")
        }
    }

    protected fun bindEvenListener() {}

    override fun onDestroy() {
        viewDelegate = null
        super.onDestroy()
    }
}