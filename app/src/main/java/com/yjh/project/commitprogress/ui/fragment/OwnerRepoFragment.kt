package com.yjh.project.commitprogress.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter
import com.yjh.project.commitprogress.ui.activity.OwnerRepositoryDetailActivity
import com.yjh.project.commitprogress.ui.adapter.OwnerRepoRecyclerViewAdapter
import com.yjh.project.commitprogress.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_owner.view.*

class OwnerRepoFragment : BaseFragment<OwnerRepoContract.UserActionsListener>(),OwnerRepoContract.View {
    override val presenter:  OwnerRepoContract.UserActionsListener by lazy{
        OwnerRepoPresenter(this)
    }

    private val  ownerRepoRecyclerViewAdapter by lazy { OwnerRepoRecyclerViewAdapter(repositoryClick) }

    companion object { fun newInstance() = OwnerRepoFragment() }

    private val  repositoryClick=(object: OwnerRepoContract.OnViewHolderListener{
        override fun onRepositoryClick(repoName: String) {
            presenter.openRepositoriesDetails(repoName)
        }

        override fun onStargazersClick(person: Person) {
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootView =inflater.inflate(R.layout.fragment_owner, container, false)

        with(rootView){
            //recyclerView.layoutManager =StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            recyclerView.layoutManager =LinearLayoutManager(context)
            recyclerView.adapter=ownerRepoRecyclerViewAdapter
        }

        presenter.loadRepositories("yjh5424")
        return rootView
    }

    override fun showRepositories(repositories: List<Pair<Repo,List<Person>>>) {
        ownerRepoRecyclerViewAdapter.setList(repositories)
    }

    override fun moveRepositoryDetailUi(repoName: String) {
        Intent(context,OwnerRepositoryDetailActivity::class.java).let {
            startActivity(it)
        }
    }
}
