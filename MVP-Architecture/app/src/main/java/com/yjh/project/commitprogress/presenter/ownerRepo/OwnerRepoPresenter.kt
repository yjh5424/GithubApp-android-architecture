package com.yjh.project.commitprogress.presenter.ownerRepo

import android.util.Log
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

        userDataNetworkRepository.getRepositories(userName)
                .subscribe(
                        { repo ->
                            Log.d("test",repo.size.toString())
                            view?.showRepositories(repo.sortedByDescending { repo -> repo.first.stargazersCount })
                        },
                        {
                            view?.onError()
                        }
                )

        /*isposable.add(
        )*/
    }

    override fun openRepositoriesDetails(repoName: String) {
        view?.moveRepositoryDetailUi(repoName)
    }

    override fun loadProfile(userName: String) {
        userDataNetworkRepository.getUserProfile(userName)
                .subscribe(
                        { response ->
                            view?.showProfile(response)
                        },
                        {
                            view?.onError()
                        }
                )

    }

    override fun openStargazerProfile(person: Person) {
        view?.showProfile(person)
    }
}