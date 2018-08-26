package com.example.yunjunghyeon.demoapp_mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.yunjunghyeon.demoapp_mvvm.network.UserDataRepositoryImpl
import com.example.yunjunghyeon.demoapp_mvvm.ui.main.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
        val userDataRepositoryImpl: UserDataRepositoryImpl
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass){
            MainViewModel::class.java-> MainViewModel(userDataRepositoryImpl) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}