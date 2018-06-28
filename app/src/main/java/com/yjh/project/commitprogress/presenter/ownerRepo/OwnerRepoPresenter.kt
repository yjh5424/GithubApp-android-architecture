package com.yjh.project.commitprogress.presenter.ownerRepo

import com.yjh.project.commitprogress.MyApplication
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository
import javax.inject.Inject


class OwnerRepoPresenter(val view: OwnerRepoContract.View) : OwnerRepoContract.UserActionsListener{
    init {
        MyApplication.component.inject(this)
    }
    @Inject lateinit var githubDataRepository: GithubDataRepository

    override fun loadRepositories(userName : String) {
        githubDataRepository.getUserRepo(userName)
                .subscribe {
                    it ->  view.showRepositories(it)

                }
    }
}