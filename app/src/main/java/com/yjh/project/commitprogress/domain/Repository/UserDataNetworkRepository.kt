package com.yjh.project.commitprogress.domain.Repository

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.network.GithubApiClient
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

class UserDataNetworkRepository(val githubApiClient: GithubApiClient) {

/*
    fun getUserRepo(userName : String)  = githubApiClient.getUserRepo(userName)

    fun getStargazers(userName: String,repoName : String) =githubApiClient.getStargazers(userName,repoName)
*/

    fun getUserProfile(userName : String) = githubApiClient.getUserProfile(userName)

    fun getRepositories(userName: String) : Single<List<Pair<Repo,List<Person>>>> = githubApiClient.getUserRepo(userName)
            .flatMap{
                Observable.fromIterable(it)
                        .flatMap {
                            Observable.zip(
                                    Observable.just(it),
                                    githubApiClient.getStargazers(it.owner.login,it.name),
                                    BiFunction<Repo,List<Person>, Pair<Repo,List<Person>>>{
                                        t1, t2 ->  Pair(t1,t2)
                                    })
                        }
            }
            .toList()
}