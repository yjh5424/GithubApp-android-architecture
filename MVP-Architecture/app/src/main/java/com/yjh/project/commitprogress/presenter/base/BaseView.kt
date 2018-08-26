package com.yjh.project.commitprogress.presenter.base

interface BaseView{
    fun onError()
    fun setPresenter(presenter: BasePresenter<*>)
}