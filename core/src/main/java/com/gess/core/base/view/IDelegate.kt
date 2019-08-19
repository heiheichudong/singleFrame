package com.gess.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

interface IDelegate {

    fun create(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)

    fun getOptionsMenuId(): Int

    fun initWidget()

    fun getRootView() : View
}