package com.example.yunjunghyeon.demoapp_mvvm.network
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.*

interface GithubApi {


    @GET("users/{userName}/repos?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserRepos( @Path("userName")userName : String) :  Observable<List<Repo>>

    @GET("repos/{userName}/{repoName}/stargazers?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getStargazers(@Path("userName")userName: String,@Path("repoName") repoName : String) : Observable<List<Person>>

    @GET("users/{userName}?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserProfile(@Path("userName")userName: String) : Single<Person>

    @GET("users/{userName}/orgs?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserOrgs(@Path("userName") userName: String) : Single<Repo>
}