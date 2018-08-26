package com.yjh.project.commitprogress.presenter.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference


open class BasePresenter<V : BaseView>(var disposable: CompositeDisposable) : Presenter<V> {

    var weakReference: WeakReference<V>? = null

    val view: V?
        get() = weakReference?.get()

    override fun attachView(view: V) {
        weakReference = WeakReference(view)
        view.setPresenter(this)
    }

    override fun detachView() {
        weakReference?.clear()
        weakReference = null
        disposable.clear()
    }
}