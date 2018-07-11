package com.yjh.project.commitprogress.presenter.main

import com.omjoonkim.project.interviewtask.model.Person
import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.domain.Repository.UserDataNetworkRepository
import javax.inject.Inject


class MainPresenter(val view : MainContract.View) : MainContract.UserActionsListener {
    override fun onClear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    init { App.component.inject(this)}

    @Inject
    lateinit var githubDataRepository: UserDataNetworkRepository

    override fun loadProfile(userName : String) {
        githubDataRepository.getUserProfile(userName)
                .subscribe { response -> view.showProfile(response) }
    }

    override fun openStargazerProfile(person: Person) {
        view.showProfile(person)
    }
}
