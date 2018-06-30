package com.yjh.project.commitprogress.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter
import com.yjh.project.commitprogress.ui.activity.RepositoryDetailActivity
import com.yjh.project.commitprogress.ui.adapter.OwnerRepoRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_owner.view.*

class OwnerRepoFragment : Fragment(), OwnerRepoContract.View {

    lateinit var mActionsListener: OwnerRepoContract.UserActionsListener

    private val  ownerRepoRecyclerViewAdapter by lazy { OwnerRepoRecyclerViewAdapter(repositoryClick) }

    private val  repositoryClick=(object: OwnerRepoContract.onRepositoryListener{
        override fun onRepositoryClick(repoName: String) {
            mActionsListener.openRepositoriesDetails(repoName)
        }
    })

    companion object {
        fun newInstance() = OwnerRepoFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActionsListener = OwnerRepoPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var rootView =inflater.inflate(R.layout.fragment_owner, container, false)

        with(rootView){
            recyclerView.layoutManager =StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            recyclerView.adapter=ownerRepoRecyclerViewAdapter
        }

        //mActionsListener.loadRepositories("yjh5424")
        return rootView
    }

    override fun onStart() {
        super.onStart()
        mActionsListener.loadRepositories("yjh5424")

    }

    override fun showRepositories(repositories: List<Repo>) {
        ownerRepoRecyclerViewAdapter.setList(repositories)
    }
    
    override fun moveRepositoryDetailUi(repoName: String) {
        Intent(context,RepositoryDetailActivity::class.java).let {
            startActivity(it)
        }
    }
}
