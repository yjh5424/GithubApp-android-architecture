package com.yjh.project.commitprogress.network

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.domain.model.AccessToken
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface GithubApi {

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

    @GET("users/{userName}/repos?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserRepos( @Path("userName")userName : String) :  Observable<List<Repo>>

    @GET("users/{userName}/{repoName}/stargazers?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getStargazers(@Path("userName")userName: String,@Path("repoName") repoName : String) : Observable<List<Person>>

    @GET("users/{userName}?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserProfile(@Path("userName")userName: String) : Single<Person>

    @GET("users/{userName}/orgs?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserOrgs(@Path("userName") userName: String) : Single<Repo>
}