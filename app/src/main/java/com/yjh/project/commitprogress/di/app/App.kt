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
        val CLIENT_ID="37bc54f3e519696e6481"
        val CLIENT_SECRET="374a1049d3bf3ddb93709e156ad522c68315494f"
        val redirect_uri="http://yjh.com/commit"
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule(BASE_URL))
                .build()
    }
}