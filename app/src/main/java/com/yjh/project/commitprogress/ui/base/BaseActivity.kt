package com.yjh.project.commitprogress.ui.base

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yjh.project.commitprogress.presenter.base.BasePresenter
import com.yjh.project.commitprogress.presenter.base.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {

    private var presenter: BasePresenter<*>? = null

    abstract fun onActivityInject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityInject()
    }

    override fun onError() {
        showToast("error")
    }

    override fun setPresenter(presenter: BasePresenter<*>) {
        this.presenter=presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    fun showToast(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    fun stringToUri(str: String) : Uri = Uri.parse(str)

}