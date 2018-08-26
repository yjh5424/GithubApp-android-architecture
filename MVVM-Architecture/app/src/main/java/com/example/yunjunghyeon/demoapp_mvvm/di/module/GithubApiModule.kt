package com.example.yunjunghyeon.demoapp_mvvm.di.module

import com.example.yunjunghyeon.demoapp_mvvm.network.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Module
class GithubApiModule{


    @Provides
    @Singleton
    fun provideGithubApi(@Named("retrofit") retrofit: Retrofit) : GithubApi = retrofit.create(GithubApi::class.java)


    @Provides
    @Singleton
    fun provideGithubApiClient(githubApi: GithubApi) = GithubApiClient(githubApi)

    @Provides
    @Singleton
    @Named("user_data_repository")
    fun provideUserDataNetworkRepository(githubApiClient: GithubApiClient) = UserDataRepositoryImpl(githubApiClient)
}