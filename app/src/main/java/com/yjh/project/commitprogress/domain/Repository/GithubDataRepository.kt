package com.yjh.project.commitprogress.domain.Repository

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.network.GithubApiClient
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


class GithubDataRepository(val githubApiClient: GithubApiClient) {

    fun getUserRepo(userName : String) = githubApiClient.getUserRepo(userName)
}