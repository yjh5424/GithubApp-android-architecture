package com.yjh.project.commitprogress.presenter.ownerRepo

import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository
import javax.inject.Inject


class OwnerRepoPresenter(val view: OwnerRepoContract.View) : OwnerRepoContract.UserActionsListener{


    init { App.component.inject(this) }

    @Inject lateinit var githubDataRepository: GithubDataRepository

    override fun loadRepositories(userName : String) {
        githubDataRepository.getUserRepo(userName)
                .subscribe {response -> response.sortedByDescending{ repo -> repo.stargazersCount }.let { view.showRepositories(it)  }}
    }


    override fun openRepositoriesDetails(repoName: String) {
        view.moveRepositoryDetailUi(repoName)
    }
}