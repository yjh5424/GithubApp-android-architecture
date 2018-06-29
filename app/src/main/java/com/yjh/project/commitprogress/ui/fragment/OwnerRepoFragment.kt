package com.yjh.project.commitprogress.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.omjoonkim.project.interviewtask.model.Repo

import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter
import com.yjh.project.commitprogress.ui.adapter.OwnerRepoRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_owner.*
import kotlinx.android.synthetic.main.fragment_owner.view.*

class OwnerRepoFragment : Fragment(), OwnerRepoContract.View {

    lateinit var mActionsListener: OwnerRepoContract.UserActionsListener
    val  ownerRepoRecyclerViewAdapter by lazy { OwnerRepoRecyclerViewAdapter() }

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
            recyclerView.layoutManager =GridLayoutManager(context,2)
            recyclerView.adapter=ownerRepoRecyclerViewAdapter
        }


        mActionsListener.loadRepositories("yjh5424")


        return rootView
    }

    override fun onStart() {
        super.onStart()
        mActionsListener.loadRepositories("yjh5424")

    }

    override fun showRepositories(repositories: List<Repo>) {
        ownerRepoRecyclerViewAdapter.setList(repositories)
    }


    override fun moveRepositoryDetailUi(id: Long) {

    }
}
