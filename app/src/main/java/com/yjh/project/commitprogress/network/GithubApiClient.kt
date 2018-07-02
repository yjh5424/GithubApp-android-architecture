package com.yjh.project.commitprogress.network

import com.omjoonkim.project.interviewtask.model.Owner
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.domain.model.AccessToken
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubApiClient(val githubApi: GithubApi) {

   fun getAccessToken(clientId : String,clientSercret : String,code : String,redirectUri : String,state : String) : Single<AccessToken> =
           githubApi.getAccessToken(clientId,clientSercret,code,redirectUri,state)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())

   fun getUserRepo(userName : String) : Single<List<Repo>> =
           githubApi.getUserRepos(userName)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())

   fun getUserProfile(userName: String) : Single<Owner> =
           githubApi.getUserProfile(userName)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
}