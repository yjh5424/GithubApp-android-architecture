package com.yjh.project.commitprogress.di.module

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import javax.inject.Singleton
import dagger.Provides
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import android.app.Application
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository
import com.yjh.project.commitprogress.network.GithubApi
import com.yjh.project.commitprogress.network.GithubApiClient
import dagger.Module
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


@Module
class NetworkModule(var mBaseUrl: String) {

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
    fun provideGithubClient(githubApi: GithubApi) = GithubApiClient(githubApi)

    @Provides
    @Singleton
    fun provideGithubDataRepository(githubApiClient: GithubApiClient) = GithubDataRepository(githubApiClient)
}