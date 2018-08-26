package com.example.yunjunghyeon.demoapp_mvvm.network

import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubApiClient(val githubApi: GithubApi) {

   fun getUserRepo(userName: String): Observable<List<Repo>> =
           githubApi.getUserRepos(userName)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())


   fun getStargazers(userName: String, repoName: String): Observable<List<Person>> =
           githubApi.getStargazers(userName, repoName)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())


   fun getUserProfile(userName: String): Single<Person> =
           githubApi.getUserProfile(userName)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())

}