package com.yjh.project.commitprogress.presenter.ownerRepo

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.presenter.base.BasePresenter
import com.yjh.project.commitprogress.presenter.base.BaseView

interface OwnerRepoContract{

    interface View : BaseView {
        // UserActionsListener 안의 loadRepositories 함수로 어댑터에 세팅
        fun showRepositories(repositories: List<Pair<Repo,List<Person>>>)

        fun showProfile(person: Person)

        fun moveRepositoryDetailUi(repoName: String)

    }

    interface OnViewHolderListener{
        fun onRepositoryClick(repoName: String)

        fun onStargazersClick(person : Person)
    }

    interface UserActionsListener  {
        //프레전터에서 상속받아서 구현
        fun loadProfile(userName : String)

        fun openStargazerProfile(person: Person)

        fun loadRepositories(userName : String)

        fun openRepositoriesDetails(repoName : String)
    }
}