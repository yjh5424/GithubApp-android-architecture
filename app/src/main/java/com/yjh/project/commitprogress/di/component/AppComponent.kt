package com.yjh.project.commitprogress.di.component

import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.di.module.ActivityModule
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule
import com.yjh.project.commitprogress.ui.activity.LoginActivity
import com.yjh.project.commitprogress.ui.fragment.OwnerRepoFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),(NetworkModule::class),ActivityModule::class]
)
interface AppComponent{

    fun inject(app: App)

    fun inject(ownerRepoFragment: OwnerRepoFragment)

    fun inject(loginActivity: LoginActivity)
}