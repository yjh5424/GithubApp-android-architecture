package com.example.yunjunghyeon.demoapp_mvvm.di.component

import com.example.yunjunghyeon.demoapp_mvvm.di.module.AppModule
import com.example.yunjunghyeon.demoapp_mvvm.di.module.GithubApiModule
import com.example.yunjunghyeon.demoapp_mvvm.di.module.NetworkModule
import com.example.yunjunghyeon.demoapp_mvvm.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton


//@Singleton
//@Component(
//        modules = [(AppModule::class),(NetworkModule::class),(GithubApiModule::class)]
//)
//interface MainComponent{
//    fun inject(mainActivity: MainActivity)
//}