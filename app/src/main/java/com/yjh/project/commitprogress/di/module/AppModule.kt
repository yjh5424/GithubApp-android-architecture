package com.yjh.project.commitprogress.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class AppModule(private val app: Application) {

    companion object {
        val USER_ID_KEY = "github_user_id"
    }

    @Provides
    @Singleton
    fun provideApp() = app


    @Provides
    @Singleton
    fun provideSharedPreferences() = app.getSharedPreferences(USER_ID_KEY,Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideCompositeDisposable() = CompositeDisposable()
}