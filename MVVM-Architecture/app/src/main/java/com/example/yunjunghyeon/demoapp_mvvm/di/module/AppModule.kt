package com.example.yunjunghyeon.demoapp_mvvm.di.module

import android.app.Application
import android.content.Context
import com.example.yunjunghyeon.demoapp_mvvm.ViewModelFactory
import com.example.yunjunghyeon.demoapp_mvvm.network.UserDataRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule(val application: Application) {

    companion object {
        val USER_ID_KEY = "github_user_id"
    }

    @Provides
    @Singleton
    fun provideApp() = application


    @Provides
    @Singleton
    fun provideSharedPreferences() = application.getSharedPreferences(USER_ID_KEY,Context.MODE_PRIVATE)!!

    @Provides
    @Singleton
    fun viewModelFactory(@Named("user_data_repository") userDataRepositoryImpl : UserDataRepositoryImpl) = ViewModelFactory(userDataRepositoryImpl)

}