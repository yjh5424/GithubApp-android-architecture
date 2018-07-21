package com.yjh.project.commitprogress.di.component

import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule
import com.yjh.project.commitprogress.ui.activity.LoginActivity
import com.yjh.project.commitprogress.ui.activity.MainActivity
import com.yjh.project.commitprogress.ui.activity.OwnerRepositoryDetailActivity
import com.yjh.project.commitprogress.ui.fragment.OwnerRepoFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [(AppModule::class),(NetworkModule::class)]
)
interface AppComponent{

    fun inject(app: App)

    fun inject(ownerRepoFragment: OwnerRepoFragment)

    fun inject(loginActivity: LoginActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(ownerRepositoryDetailActivity: OwnerRepositoryDetailActivity)


}