package com.gess.core.base.utils

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

fun <T> getT(a: Any, i: Int): T? {
    var type: Type? = a.javaClass.genericSuperclass
    if (type is ParameterizedType) {
        try {
            return (type.actualTypeArguments[i] as Class<T>).newInstance()
        } catch (e: java.lang.InstantiationException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }
    return null
}