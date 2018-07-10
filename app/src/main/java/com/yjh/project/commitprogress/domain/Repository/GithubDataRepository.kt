package com.yjh.project.commitprogress.domain.Repository

import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.network.GithubApiClient

class GithubDataRepository(val githubApiClient: GithubApiClient) {


    fun getUserRepo(userName : String)  = githubApiClient.getUserRepo(userName)

    fun getStargazers(userName: String,repoName : String) =githubApiClient.getStargazers(userName,repoName)

    fun getUserProfile(userName : String) = githubApiClient.getUserProfile(userName)

}