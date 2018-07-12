package com.yjh.project.commitprogress.domain.Repository

import com.yjh.project.commitprogress.domain.model.AccessToken
import com.yjh.project.commitprogress.network.GithubTokenApiClient
import io.reactivex.Single

class UserTokenNetworkRepository(val githubTokenApiClient: GithubTokenApiClient) : UserTokenRepository{

    override fun getAccessToken(clientId : String,clientSecret : String,code : String,redirectUri : String,state : String) : Single<AccessToken> = githubTokenApiClient.getAccessToken(
            clientId,
            clientSecret,
            code,
            redirectUri,
            state
    )
}