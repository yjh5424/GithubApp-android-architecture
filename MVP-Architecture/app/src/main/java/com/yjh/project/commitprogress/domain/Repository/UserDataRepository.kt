package com.yjh.project.commitprogress.domain.Repository

import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import io.reactivex.Single

interface UserDataRepository{
    fun getUserProfile(userName : String) : Single<Person>
    fun getRepositories(userName: String) : Single<List<Pair<Repo, List<Person>>>>
}