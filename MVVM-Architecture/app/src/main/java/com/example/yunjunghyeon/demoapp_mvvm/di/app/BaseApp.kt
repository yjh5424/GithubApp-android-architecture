package com.example.yunjunghyeon.demoapp_mvvm.di.app

import android.app.Application
import com.example.yunjunghyeon.demoapp_mvvm.di.module.*

class BaseApp : Application() {



    companion object {
        lateinit var appComponent: AppComponent

        val BASE_GITHUB_URL = "https://api.github.com/"
        val BASE_GITHUB_TOKEN_URL = "https://api.github.com/"

        val CLIENT_ID = "37bc54f3e519696e6481"
        val CLIENT_SECRET = "096479e54c7c370d7aa27b56ec873803e96feb4c"
        val redirect_uri = "commitprogress://callback"


    }


    init {

    }

    override fun onCreate() {
        super.onCreate()

        appComponent=DaggerAppComponent.builder()
                .networkModule(NetworkModule(BASE_GITHUB_URL))
                .githubApiModule(GithubApiModule())
                .appModule(AppModule(this))
                .build()
        //realm 또는 맨처음에 초기화 객체 inject 하면 됌

    }



}