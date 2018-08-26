package com.example.yunjunghyeon.demoapp_mvvm.di.module

import com.example.yunjunghyeon.demoapp_mvvm.di.app.BaseApp
import com.example.yunjunghyeon.demoapp_mvvm.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),(NetworkModule::class),(GithubApiModule::class)]
)
interface AppComponent{
    fun inject(baseApp : BaseApp)
    fun inject(mainActivity: MainActivity)
}