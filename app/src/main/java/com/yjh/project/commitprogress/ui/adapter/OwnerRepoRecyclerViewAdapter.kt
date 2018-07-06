package com.yjh.project.commitprogress.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.ui.viewholder.OwnerRepoViewHolder
import com.yjh.project.commitprogress.ui.viewholder.OwnerStarViewHolder


class OwnerRepoRecyclerViewAdapter(private val repositoryListener: OwnerRepoContract.OnRepositoryListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var repositories = mutableListOf<Pair<Repo,List<Person>>>()

    enum class ViewType {
        REPOSITORY, STARGAZERS
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =  when (viewType) {
        ViewType.REPOSITORY.ordinal ->
            OwnerRepoViewHolder(
                    parent,
                    repositoryListener
            )
        ViewType.STARGAZERS.ordinal ->
            OwnerStarViewHolder(
                    parent,
                    repositoryListener
            )
        else -> throw IllegalStateException()
    }

    fun setList(repositories: List<Pair<Repo,List<Person>>>){
        this.repositories= repositories.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        repositories[position].let {
            (holder as OwnerRepoViewHolder)
                    .bindTo(it.first.name,
                            it.first.description,
                            it.first.language,
                            it.first.stargazersCount)
        }
    }

    override fun getItemCount(): Int =repositories.size

    override fun getItemViewType(position: Int): Int = position % 2




}

