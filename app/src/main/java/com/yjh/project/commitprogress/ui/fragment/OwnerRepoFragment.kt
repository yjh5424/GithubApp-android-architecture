package com.yjh.project.commitprogress.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.omjoonkim.project.interviewtask.model.Repo

import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoPresenter

class OwnerRepoFragment : Fragment(), OwnerRepoContract.View {

    lateinit var mActionsListener: OwnerRepoContract.UserActionsListener

    companion object {
        fun newInstance() = OwnerRepoFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActionsListener = OwnerRepoPresenter(this)
        mActionsListener.loadRepositories("yjh5424")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner, container, false)
    }


    override fun showRepositories(repositories: List<Repo>) {
        Toast.makeText(context,repositories[0].name,Toast.LENGTH_LONG).show()
    }


    override fun moveRepositoryDetailUi(id: Long) {

    }

}
