package com.yjh.project.commitprogress.presenter.ownerRepo

import android.util.Log
import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class OwnerRepoPresenter(val view: OwnerRepoContract.View) : OwnerRepoContract.UserActionsListener{

    @Inject lateinit var githubDataRepository: GithubDataRepository

    init { App.component.inject(this) }

    override fun loadRepositories(userName : String) {
        githubDataRepository.getUserRepo(userName)
                .flatMap{
                    Observable.fromIterable(it)
                            .flatMap {
                                Observable.zip(
                                        Observable.just(it),
                                        githubDataRepository.getStargazers(it.owner.login,it.name),
                                        BiFunction<Repo,List<Person>, Pair<Repo,List<Person>>>{
                                            t1, t2 ->  Pair(t1,t2)
                                        })
                            }
                }
                .toList()
                .subscribe {
                    repo -> view.showRepositories(repo.sortedByDescending { repo -> repo.first.stargazersCount })
                }
    }

    override fun openRepositoriesDetails(repoName: String) {
        view.moveRepositoryDetailUi(repoName)
    }
}