package com.yjh.project.commitprogress.presenter.main

import com.omjoonkim.project.interviewtask.model.Person
import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.domain.Repository.UserDataNetworkRepository
import javax.inject.Inject


class MainPresenter(val view : MainContract.View) : MainContract.UserActionsListener {

    init { App.component.inject(this)}

    @Inject
    lateinit var githubDataRepository: UserDataNetworkRepository


}
