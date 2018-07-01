package com.yjh.project.commitprogress.presenter.login


interface LoginContract{

    interface View{
        fun moveMainActivity()
    }

    interface UserActionListener{
        fun loginWithGithub()
    }
}