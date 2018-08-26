package com.example.yunjunghyeon.demoapp_mvvm.di.module

import com.example.yunjunghyeon.demoapp_mvvm.network.GithubTokenApi
import com.example.yunjunghyeon.demoapp_mvvm.network.GithubTokenApiClient
import com.example.yunjunghyeon.demoapp_mvvm.network.UserTokenRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
class GithubTokenApiModule{

    @Provides
    @Singleton
    fun provideGithubTokenApi(@Named("retrofit") retrofit: Retrofit) : GithubTokenApi = retrofit.create(GithubTokenApi::class.java)

    @Provides
    @Singleton
    fun provideGithubTokenClient(githubTokenApi: GithubTokenApi) = GithubTokenApiClient(githubTokenApi)

    @Provides
    @Singleton
    fun provideUserTokenNetworkRepository(githubTokenApiClient: GithubTokenApiClient) = UserTokenRepositoryImpl(githubTokenApiClient)
}