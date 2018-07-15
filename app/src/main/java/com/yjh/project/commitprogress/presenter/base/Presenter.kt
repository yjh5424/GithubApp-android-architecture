package com.yjh.project.commitprogress.presenter.base

import io.reactivex.disposables.CompositeDisposable


interface Presenter<V : BaseView>{

    fun attachView(view: V)

    fun detachView()
}