package com.yjh.project.commitprogress.di.component

import android.app.Application
import com.yjh.project.commitprogress.MainActivity
import com.yjh.project.commitprogress.MyApplication
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter
import com.yjh.project.commitprogress.ui.OwnerRepoFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),(NetworkModule::class)]
)
interface AppComponent{

    fun inject(application: MyApplication)

    fun inject(ownerRepoPresenter: OwnerRepoPresenter)
}