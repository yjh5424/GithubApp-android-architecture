package com.yjh.project.commitprogress.presenter.login

import com.google.firebase.auth.FirebaseAuth
import com.yjh.project.commitprogress.domain.model.AccessToken
import com.yjh.project.commitprogress.presenter.base.BasePresenter
import com.yjh.project.commitprogress.presenter.base.BaseView
import okhttp3.HttpUrl


interface LoginContract{

    interface View : BaseView{
        fun moveMainActivity(id : String)
        fun moveGithubWebView(httpUrl: HttpUrl)
        fun hideProgress()
    }

    interface UserActionListener {
        fun loginWithGithub(mAuth: FirebaseAuth,accessToken: AccessToken)
        fun loadGithubWebView()
        fun loadGithubToken(mAuth: FirebaseAuth,code : String, state : String)
    }
}