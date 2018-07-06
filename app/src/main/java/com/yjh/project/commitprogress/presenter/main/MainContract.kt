package com.yjh.project.commitprogress.presenter.main

import com.omjoonkim.project.interviewtask.model.Person

interface MainContract {
    interface View {
        fun showProfile(person: Person)
    }

    interface UserActionsListener {
        fun loadProfile(userName : String)
    }
}