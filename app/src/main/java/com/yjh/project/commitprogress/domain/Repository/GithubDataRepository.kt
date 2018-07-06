package com.yjh.project.commitprogress.domain.Repository

import com.yjh.project.commitprogress.network.GithubApiClient

class GithubDataRepository(val githubApiClient: GithubApiClient) {

    fun getAccessToken(clientId : String,clientSercret : String,code : String,redirectUri : String,state : String) = githubApiClient.getAccessToken(
            clientId,
            clientSercret,
            code,
            redirectUri,
            state
    )

    fun getUserRepo(userName : String) = githubApiClient.getUserRepo(userName)

    fun getStargazers(userName: String,repoName : String) =githubApiClient.getStargazers(userName,repoName)

    fun getUserProfile(userName : String) = githubApiClient.getUserProfile(userName)

}