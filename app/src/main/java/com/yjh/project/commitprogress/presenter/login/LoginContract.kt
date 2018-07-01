package com.yjh.project.commitprogress.presenter.login

import com.google.firebase.auth.FirebaseAuth
import com.yjh.project.commitprogress.domain.model.AccessToken
import okhttp3.HttpUrl


interface LoginContract{

    interface View{
        fun moveMainActivity()
        fun moveGithubWebView(httpUrl: HttpUrl)
    }

    interface UserActionListener{
        fun loginWithGithub(mAuth: FirebaseAuth,accessToken: AccessToken)
        fun loadGithubWebView()
        fun loadGithubToken(mAuth: FirebaseAuth,code : String, state : String)
    }
}