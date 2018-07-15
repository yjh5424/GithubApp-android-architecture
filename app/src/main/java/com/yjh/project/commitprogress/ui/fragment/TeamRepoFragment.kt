package com.yjh.project.commitprogress.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.teamRepo.TeamRepoContract
import com.yjh.project.commitprogress.ui.base.BaseFragment

class TeamRepoFragment : BaseFragment(), TeamRepoContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }


    companion object {
        fun newInstance() = TeamRepoFragment()
    }
}
