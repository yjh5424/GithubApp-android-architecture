package com.example.yunjunghyeon.demoapp_mvvm.network

import com.example.yunjunghyeon.demoapp_mvvm.domain.model.AccessToken
import io.reactivex.Single

interface UserTokenRepository{
    fun getAccessToken(clientId : String,clientSecret : String,code : String,redirectUri : String,state : String) : Single<AccessToken>
}