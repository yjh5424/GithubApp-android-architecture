package com.yjh.project.commitprogress.network

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


class GithubApiClient(val githubApi: GithubApi) {

   fun getUserRepo(userName : String) : Single<List<Repo>> =
           githubApi.getUserRepos(userName).subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
}