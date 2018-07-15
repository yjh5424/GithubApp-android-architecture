package com.yjh.project.commitprogress.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.squareup.picasso.Picasso
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.presenter.login.LoginPresenter
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter
import com.yjh.project.commitprogress.ui.activity.OwnerRepositoryDetailActivity
import com.yjh.project.commitprogress.ui.adapter.OwnerRepoRecyclerViewAdapter
import com.yjh.project.commitprogress.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_owner.view.*
import javax.inject.Inject

class OwnerRepoFragment : BaseFragment(), OwnerRepoContract.View {

    lateinit var userID: String

    init { App.component.inject(this) }

    @Inject
    lateinit var presenter: OwnerRepoPresenter

    companion object {
        fun newInstance(id: String) =
                OwnerRepoFragment().apply {
                    arguments = Bundle().apply {
                        putString("id", id)
                    }
                }
    }

    private val ownerRepoRecyclerViewAdapter by lazy { OwnerRepoRecyclerViewAdapter(repositoryClick) }

    private val repositoryClick = (object : OwnerRepoContract.OnViewHolderListener {
        override fun onRepositoryClick(repoName: String) {
            presenter.openRepositoriesDetails(repoName)
        }

        override fun onStargazersClick(person: Person) {
            presenter.loadProfile(person.login)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        arguments?.let { userID = it.getString("id") }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_owner, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
    }

    private fun init(rootView : View){
        rootView.recyclerView.layoutManager = LinearLayoutManager(context)
        rootView.recyclerView.adapter = ownerRepoRecyclerViewAdapter

        presenter.loadRepositories(userID)
        presenter.loadProfile(userID)
    }

    override fun showRepositories(repositories: List<Pair<Repo, List<Person>>>) {
        ownerRepoRecyclerViewAdapter.setList(repositories)
    }

    override fun moveRepositoryDetailUi(repoName: String) {
        Intent(context,OwnerRepositoryDetailActivity::class.java).let {
            startActivity(it)
        }
    }

    override fun showProfile(person: Person) {
        with(view!!.rootView){
            Picasso.with(context).load(stringToUri(person.avatar)).into(avatar)
            name.text=person.name
            login.text=person.login
            location.text=person.location ?: ""
            email.text=person.email ?: ""
            team.text=person.company ?: ""
        }
    }
}
