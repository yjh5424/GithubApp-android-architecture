package com.yjh.project.commitprogress.di.component

import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),(NetworkModule::class)]
)
interface AppComponent{

    fun inject(app: App)

    fun inject(ownerRepoPresenter: OwnerRepoPresenter)
}