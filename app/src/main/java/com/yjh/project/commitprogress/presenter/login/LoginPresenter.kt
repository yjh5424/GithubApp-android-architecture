package com.yjh.project.commitprogress.presenter.login

import com.yjh.project.commitprogress.di.app.App


class LoginPresenter(val view: LoginContract.View) : LoginContract.UserActionListener{

    override fun loginWithGithub() {
        view.moveMainActivity()
    }
}