package com.yjh.project.commitprogress.network

import com.omjoonkim.project.interviewtask.model.Repo
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubApiClient(val githubApi: GithubApi) {

   fun getUserRepo(userName : String) : Single<List<Repo>> =
           githubApi.getUserRepos(userName).subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
}