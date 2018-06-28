package com.yjh.project.commitprogress.network

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("users/{userName}/repos?client_id=65904bb18cddf718a836&client_secret=1b5dda5bbdc51d8bb8059d844af7364e288e2beb")
    fun getUserRepos( @Path("userName")userName : String) : Single<List<Repo>>
}