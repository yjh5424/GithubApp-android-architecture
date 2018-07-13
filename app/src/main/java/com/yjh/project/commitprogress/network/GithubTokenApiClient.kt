package com.yjh.project.commitprogress.network

import com.yjh.project.commitprogress.domain.model.AccessToken
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GithubTokenApiClient(val githubTokenApi: GithubTokenApi) {


   fun getAccessToken(clientId: String, clientSercret: String, code: String, redirectUri: String, state: String): Single<AccessToken> =
           githubTokenApi.getAccessToken(clientId, clientSercret, code, redirectUri, state)
                   .subscribeOn(Schedulers.io())
                   .observeOn(AndroidSchedulers.mainThread())
}