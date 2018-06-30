package com.yjh.project.commitprogress.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.ui.viewholder.OwnerRepoViewHolder


class OwnerRepoRecyclerViewAdapter(private val repositoryListener: OwnerRepoContract.OnRepositoryListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var repositories = mutableListOf<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = OwnerRepoViewHolder(parent,repositoryListener)

    fun setList(repositories: List<Repo>){
        this.repositories= repositories.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var repository=repositories[position]
        (holder as OwnerRepoViewHolder).bindTo(repository.name,repository.description,repository.language,repository.stargazersCount)
    }

    override fun getItemCount(): Int =repositories.size
}

