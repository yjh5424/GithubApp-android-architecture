package com.yjh.project.commitprogress.network

import com.omjoonkim.project.interviewtask.model.Owner
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.domain.model.AccessToken
import io.reactivex.Single
import retrofit2.http.*

interface GithubApi {

    @Headers("Accept: application/json")
    @POST("login/oauth/access_token?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    @FormUrlEncoded
    fun getAccessToken(
            @Field("client_id") clientId : String,
            @Field("client_secret") clientSecret : String,
            @Field("code") code :String,
            @Field("redirect_uri") redirectUri : String,
            @Field("state") state : String
    ) : Single<AccessToken>

    @GET("users/{userName}/repos?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserRepos( @Path("userName")userName : String) : Single<List<Repo>>

    @GET("users/{userName}?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserProfile(@Path("userName")userName: String) : Single<Owner>
}