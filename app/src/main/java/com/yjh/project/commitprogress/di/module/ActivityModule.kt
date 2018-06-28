package com.yjh.project.commitprogress.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity() = activity

    @Provides
    @Singleton
    fun provideContext() = this
}