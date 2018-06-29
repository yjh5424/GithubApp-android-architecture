package com.yjh.project.commitprogress.di.app

import android.app.Application
import com.yjh.project.commitprogress.di.component.AppComponent
import com.yjh.project.commitprogress.di.component.DaggerAppComponent
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule


class App : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var component: AppComponent
        val BASE_URL="https://api.github.com/"
        val GITHUB_CLIENT_ID="65904bb18cddf718a836"
        val GITHUB_SECRET="1b5dda5bbdc51d8bb8059d844af7364e288e2beb"
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(BASE_URL))
                .build()
    }
}