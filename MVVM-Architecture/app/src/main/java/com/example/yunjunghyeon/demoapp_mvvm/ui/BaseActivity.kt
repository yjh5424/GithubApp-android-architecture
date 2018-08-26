package com.example.yunjunghyeon.demoapp_mvvm.ui

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


abstract class BaseActivity<T : ViewModel> : AppCompatActivity(){

    abstract fun bind(t : T)

    abstract fun inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }
}