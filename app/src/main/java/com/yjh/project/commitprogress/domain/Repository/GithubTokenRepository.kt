package com.yjh.project.commitprogress.domain.Repository

import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.network.GithubApiClient
import com.yjh.project.commitprogress.network.GithubTokenApiClient

class GithubTokenRepository(val githubTokenApiClient: GithubTokenApiClient) {

    fun getAccessToken(clientId : String,clientSercret : String,code : String,redirectUri : String,state : String) = githubTokenApiClient.getAccessToken(
            clientId,
            clientSercret,
            code,
            redirectUri,
            state
    )
}