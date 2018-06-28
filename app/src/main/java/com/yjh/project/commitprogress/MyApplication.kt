package com.yjh.project.commitprogress

import android.app.Application
import com.yjh.project.commitprogress.di.component.AppComponent
import com.yjh.project.commitprogress.di.component.DaggerAppComponent
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository
import javax.inject.Inject


open class MyApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var component: AppComponent
        val BASE_URL="https://api.github.com/"
    }

    override fun onCreate() {
        super.onCreate()

        component= DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(BASE_URL))
                .build()
    }
}