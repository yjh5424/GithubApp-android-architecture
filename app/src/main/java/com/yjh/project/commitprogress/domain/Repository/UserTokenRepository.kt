package com.yjh.project.commitprogress.domain.Repository

import com.yjh.project.commitprogress.domain.model.AccessToken
import io.reactivex.Single

interface UserTokenRepository{
    fun getAccessToken(clientId : String,clientSecret : String,code : String,redirectUri : String,state : String) : Single<AccessToken>
}