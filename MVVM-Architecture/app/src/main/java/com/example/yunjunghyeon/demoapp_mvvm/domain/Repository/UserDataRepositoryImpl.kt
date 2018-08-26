package com.example.yunjunghyeon.demoapp_mvvm.network


import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class UserDataRepositoryImpl(val githubApiClient: GithubApiClient) : UserDataRepository {

    override fun getUserProfile(userName: String): Single<Person> = githubApiClient.getUserProfile(userName)

    override fun getRepositories(userName: String): Observable<List<Pair<Repo, List<Person>>>> = githubApiClient.getUserRepo(userName)
            .flatMap {
                Observable.fromIterable(it)
                        .flatMap {
                            Observable.zip(
                                    Observable.just(it),
                                    githubApiClient.getStargazers(it.owner.login, it.name),
                                    BiFunction<Repo, List<Person>, Pair<Repo, List<Person>>> { t1, t2 ->
                                        Pair(t1, t2)
                                    })
                        }
            }
            .toList()
            .toObservable()


}