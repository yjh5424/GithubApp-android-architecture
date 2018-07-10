package com.yjh.project.commitprogress.presenter.login

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.yjh.project.commitprogress.di.app.App
import com.google.firebase.auth.GithubAuthProvider
import com.google.firebase.auth.AuthCredential
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository
import com.yjh.project.commitprogress.domain.Repository.GithubTokenRepository
import com.yjh.project.commitprogress.domain.model.AccessToken
import okhttp3.HttpUrl
import java.math.BigInteger
import java.util.*
import javax.inject.Inject


class LoginPresenter(val view: LoginContract.View) : LoginContract.UserActionListener{

    init { App.component.inject(this) }

    @Inject
    lateinit var githubTokenRepository: GithubTokenRepository

    @Inject
    lateinit var sharedPreferences : SharedPreferences

    override fun loginWithGithub(mAuth: FirebaseAuth, accessToken: AccessToken) {

        val credential = GithubAuthProvider.getCredential(accessToken.accessToken)

        mAuth.signInWithCredential(credential).addOnCompleteListener { it ->
            if (it.isSuccessful) {
                view.moveMainActivity()
                // github 사용자 고유 id 저장
                sharedPreferences.edit().putString(AppModule.USER_ID_KEY,it.result.additionalUserInfo.providerId).commit()
            }
        }
    }

    override fun loadGithubWebView() {
        val httpUrl = HttpUrl.Builder()
                .scheme("http")
                .host("github.com")
                .addPathSegment("login")
                .addPathSegment("oauth")
                .addPathSegment("authorize")
                .addQueryParameter("client_id",App.CLIENT_ID)
                .addQueryParameter("redirect_uri", App.redirect_uri)
                .addQueryParameter("state", getRandomString())
                .addQueryParameter("scope", "user")
                .addQueryParameter("allow_signup","false")
                .build()

        view.moveGithubWebView(httpUrl)
    }

    override fun loadGithubToken(mAuth: FirebaseAuth,code : String, state : String) {
        githubTokenRepository.getAccessToken(App.CLIENT_ID,App.CLIENT_SECRET,code,App.redirect_uri,state)
                .subscribe { response-> loginWithGithub(mAuth,response) }
    }

    private fun getRandomString(): String = BigInteger(130, Random()).toString(32)

}