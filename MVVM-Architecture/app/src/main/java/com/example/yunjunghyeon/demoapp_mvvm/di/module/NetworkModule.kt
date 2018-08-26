package com.example.yunjunghyeon.demoapp_mvvm.di.module

import com.example.yunjunghyeon.demoapp_mvvm.network.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import javax.inject.Singleton
import dagger.Provides
import com.google.gson.GsonBuilder
import dagger.Module
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Named


@Module
class NetworkModule(val mBaseUrl: String) {

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
    @Named("retrofit")
    fun provideRetrofit(gson : Gson,
                        okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build()
    }

//    @Provides
//    @Singleton
//    fun provideGithubApi(gson: Gson, okHttpClient: OkHttpClient): GithubApi {
//        return Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(mBaseUrl)
//                .client(okHttpClient)
//                .build()
//                .create(GithubApi::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideGithubTokenApi(gson: Gson, okHttpClient: OkHttpClient) : GithubTokenApi {
//        return Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl("https://github.com/")
//                .client(okHttpClient)
//                .build()
//                .create(GithubTokenApi::class.java)
//    }
}