package com.yjh.project.commitprogress.presenter.ownerRepo

import android.app.Application
import android.content.Context
import com.omjoonkim.project.interviewtask.model.Repo

interface OwnerRepoContract{

    interface View{


        // UserActionsListener 안의 loadRepositories 함수로 어댑터에 세팅
        fun showRepositories(repositories: List<Repo>)

        fun moveRepositoryDetailUi(id : Long)
    }

    interface UserActionsListener{
        //프레전터에서 상속받아서 구현
        fun loadRepositories(userName : String)
    }
}