package com.yjh.project.commitprogress.di.module

import android.app.Activity
import android.content.SharedPreferences
import com.yjh.project.commitprogress.domain.Repository.UserTokenNetworkRepository
import com.yjh.project.commitprogress.presenter.login.LoginPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity() = activity

    @Provides
    @Singleton
    fun provideContext() = this

}