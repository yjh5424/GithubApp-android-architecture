package com.yjh.project.commitprogress.ui.viewholder

import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Person
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.ui.adapter.OwnerStarRecyclerViewAdapter
import kotlinx.android.synthetic.main.item_owner_stargzers.view.*

class OwnerStargazersViewHolder(val parent: ViewGroup, private val listener: OwnerRepoContract.OnViewHolderListener) : BaseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_owner_stargzers, parent, false)){

    private val  ownerStarRecyclerViewAdapter =OwnerStarRecyclerViewAdapter(listener)

    init {
        itemView.recyclerView.adapter=ownerStarRecyclerViewAdapter
        itemView.recyclerView.layoutManager= LinearLayoutManager(parent.context,LinearLayoutManager.HORIZONTAL,false)
    }

    fun setList(people : List<Person>) {
        ownerStarRecyclerViewAdapter.setList(people)
    }
}