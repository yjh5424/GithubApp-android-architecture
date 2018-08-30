package com.example.yunjunghyeon.demoapp_mvvm.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.yunjunghyeon.demoapp_mvvm.R
import com.example.yunjunghyeon.demoapp_mvvm.ViewModelFactory
import com.example.yunjunghyeon.demoapp_mvvm.di.app.BaseApp
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Status
import com.example.yunjunghyeon.demoapp_mvvm.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity<MainViewModel>() {

    val Tag ="MainActivity_log_"

    val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)  }
    val adapter by lazy { MainRecyclerAdapter() }

    override fun inject() = BaseApp.appComponent.inject(this)

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerInit()
        viewModel.loadRepositories("yjh5424")

        viewModel.run {
            repositoriesOutStream.observe(this@MainActivity, Observer {
               when(it!!.status){
                   Status.ERROR -> Log.d("status","error")
                   Status.SUCCESS -> {
                       Log.d(Tag+"status","success")
                       Log.d(Tag+"status",it.data.toString())
                       adapter.setData(it.data!!.toMutableList())
                       main_swipe.isRefreshing=false
                   }
                   Status.LOADING -> main_swipe.isRefreshing=true
               }
           })
        }
    }

    private fun recyclerInit(){
        main_recycler.layoutManager = LinearLayoutManager(this)
        main_recycler.adapter = adapter
    }



}
