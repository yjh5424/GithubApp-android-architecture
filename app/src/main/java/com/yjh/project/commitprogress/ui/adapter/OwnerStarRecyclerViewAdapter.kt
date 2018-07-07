package com.yjh.project.commitprogress.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Person
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.ui.viewholder.OwnerStargazerViewHolder

class OwnerStarRecyclerViewAdapter(private val repositoryListener : OwnerRepoContract.OnViewHolderListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var people = listOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = OwnerStargazerViewHolder(parent,repositoryListener)

    override fun getItemCount(): Int = people.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as OwnerStargazerViewHolder).let {
            it.bindTo(people[position])
        }
    }

    fun setList(people : List<Person>){
        this.people=people
        notifyDataSetChanged()
    }

}