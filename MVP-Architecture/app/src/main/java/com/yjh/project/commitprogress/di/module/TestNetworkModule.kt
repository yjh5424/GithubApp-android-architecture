package com.yjh.project.commitprogress.di.module

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import javax.inject.Singleton
import dagger.Provides
import com.google.gson.GsonBuilder
import com.yjh.project.commitprogress.domain.Repository.UserDataNetworkRepository
import com.yjh.project.commitprogress.domain.Repository.UserTokenNetworkRepository
import com.yjh.project.commitprogress.network.GithubApi
import com.yjh.project.commitprogress.network.GithubApiClient
import com.yjh.project.commitprogress.network.GithubTokenApi
import com.yjh.project.commitprogress.network.GithubTokenApiClient
import dagger.Module
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


@Module
class TestNetworkModule(val mBaseUrl: String) {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
    }
    
    @Provides
    @Singleton
    fun provideGson(): Gson {
         return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideGithubApi(gson: Gson, okHttpClient: OkHttpClient): GithubApi {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
                .create(GithubApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubTokenApi(gson: Gson, okHttpClient: OkHttpClient) : GithubTokenApi{
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://github.com/")
                .client(okHttpClient)
                .build()
                .create(GithubTokenApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubTokenClient(githubTokenApi: GithubTokenApi) = GithubTokenApiClient(githubTokenApi)

    @Provides
    @Singleton
    fun provideUserTokenNetworkRepository(githubTokenApiClient: GithubTokenApiClient) = UserTokenNetworkRepository(githubTokenApiClient)

    @Provides
    @Singleton
    fun provideGithubClient(githubApi: GithubApi) = GithubApiClient(githubApi)

    @Provides
    @Singleton
    fun provideUserDataNetworkRepository(githubApiClient: GithubApiClient) = UserDataNetworkRepository(githubApiClient)


}