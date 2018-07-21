package com.yjh.project.commitprogress

import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.di.component.DaggerAppComponent
import com.yjh.project.commitprogress.di.module.AppModule
import com.yjh.project.commitprogress.di.module.NetworkModule
import com.yjh.project.commitprogress.domain.Repository.UserDataNetworkRepository
import org.junit.Before
import javax.inject.Inject

class UserDataNetworkRepositoryTest{


    @Inject
    lateinit var userDataNetworkRepository: UserDataNetworkRepository

    @Before
    fun setup(){
        DaggerAppComponent.builder()
                .build()
    }
}