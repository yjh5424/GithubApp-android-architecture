package com.example.yunjunghyeon.demoapp_mvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.example.yunjunghyeon.demoapp_mvvm.R
import com.example.yunjunghyeon.demoapp_mvvm.ViewModelFactory
import com.example.yunjunghyeon.demoapp_mvvm.di.app.BaseApp
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Status
import com.example.yunjunghyeon.demoapp_mvvm.ui.BaseActivity
import javax.inject.Inject


class MainActivity : BaseActivity<MainViewModel>() {

    lateinit var viewModel : MainViewModel
    val Tag ="MainActivity_log_"
    override fun inject(){
        BaseApp.appComponent.inject(this)
    }


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.loadRepositories("yjh5424")

        viewModel.run {
            repositoriesOutStream.observe(this@MainActivity, Observer {
               when(it!!.status){
                   Status.ERROR -> Log.d("status","error")
                   Status.SUCCESS -> {
                       Log.d(Tag+"status","success")
                       Log.d(Tag+"status",it!!.data.toString())
                   }
                   Status.LOADING -> Log.d(Tag+"status","loading")
               }
           })
        }
    }

    override fun bind(t: MainViewModel) {
        with(t){

        }
    }
}
