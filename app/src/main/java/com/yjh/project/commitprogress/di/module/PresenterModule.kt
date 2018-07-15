package com.yjh.project.commitprogress.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.yjh.project.commitprogress.domain.Repository.UserTokenNetworkRepository
import com.yjh.project.commitprogress.presenter.login.LoginPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class PresenterModule {



    @Provides
    @Singleton
    fun providesLoginPresenter(
            tokenNetworkRepository: UserTokenNetworkRepository,
            sharedPreferences: SharedPreferences,
            disposable: CompositeDisposable): LoginPresenter = LoginPresenter(tokenNetworkRepository,sharedPreferences,disposable)

    @Provides
    @Singleton
    fun providesOwnerRepoPresenter(
            tokenNetworkRepository: UserTokenNetworkRepository,
            sharedPreferences: SharedPreferences,
            disposable: CompositeDisposable): LoginPresenter = LoginPresenter(tokenNetworkRepository,sharedPreferences,disposable)


}