package com.gess.core.http.service

import com.gess.simpleframe.bean.HttpResult
import com.gess.simpleframe.bean.User
import io.reactivex.Observable
import retrofit2.http.POST

interface BaseService{
    /**
     * 查询用户信息
     *
     * @param map
     * @return
     */
    @POST("/account/user/profile.json")
    fun postProfile(): Observable<HttpResult<User>>
}