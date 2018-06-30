package com.yjh.project.commitprogress.presenter.main

import com.omjoonkim.project.interviewtask.model.Owner

interface MainContract {
    interface View {
        fun showProfile(owner: Owner)
    }

    interface UserActionsListener {
        fun loadProfile(userName : String)
    }
}