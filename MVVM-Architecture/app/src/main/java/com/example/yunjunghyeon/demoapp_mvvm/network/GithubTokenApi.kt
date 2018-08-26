package com.example.yunjunghyeon.demoapp_mvvm.network

import com.example.yunjunghyeon.demoapp_mvvm.domain.model.AccessToken
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST


interface GithubTokenApi{
    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    fun getAccessToken(
            @Field("client_id") clientId : String,
            @Field("client_secret") clientSecret : String,
            @Field("code") code :String,
            @Field("redirect_uri") redirectUri : String,
            @Field("state") state : String
    ) : Single<AccessToken>
}