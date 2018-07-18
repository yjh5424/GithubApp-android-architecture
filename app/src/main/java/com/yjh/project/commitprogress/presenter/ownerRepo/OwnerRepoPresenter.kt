package com.yjh.project.commitprogress.presenter.ownerRepo

import com.omjoonkim.project.interviewtask.model.Person
import com.yjh.project.commitprogress.domain.Repository.UserDataNetworkRepository
import com.yjh.project.commitprogress.presenter.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class OwnerRepoPresenter @Inject constructor(
        private val userDataNetworkRepository: UserDataNetworkRepository,
        disposable: CompositeDisposable
) : BasePresenter<OwnerRepoContract.View>(disposable), OwnerRepoContract.UserActionsListener {

    override fun loadRepositories(userName: String) {

        disposable.add(userDataNetworkRepository.getRepositories(userName)
                .subscribe(
                        { repo ->
                             view?.showRepositories(repo.sortedByDescending { repo -> repo.first.stargazersCount })
                        },
                        {
                            view?.onError()
                        }
                )
        )
    }

    override fun openRepositoriesDetails(repoName: String) {
        view?.moveRepositoryDetailUi(repoName)
    }

    override fun loadProfile(userName: String) {
        disposable.add(userDataNetworkRepository.getUserProfile(userName)
                .subscribe(
                        { response ->
                            view?.showProfile(response)
                        },
                        {
                            view?.onError()
                        }
                )
        )
    }

    override fun openStargazerProfile(person: Person) {
        view?.showProfile(person)
    }
}