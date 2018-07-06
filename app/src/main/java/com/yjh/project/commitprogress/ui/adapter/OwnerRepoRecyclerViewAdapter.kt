package com.yjh.project.commitprogress.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.omjoonkim.project.interviewtask.model.Person
import com.omjoonkim.project.interviewtask.model.Repo
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract
import com.yjh.project.commitprogress.ui.viewholder.OwnerRepoViewHolder
import com.yjh.project.commitprogress.ui.viewholder.OwnerStargazerViewHolder

class OwnerRepoRecyclerViewAdapter(private val repositoryListener: OwnerRepoContract.OnViewHolderListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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
            OwnerStargazerViewHolder(
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
        var repo = repositories[position/2]

        when (holder) {
            is OwnerRepoViewHolder -> {
                holder.apply {
                    bindTo(
                            repo.first.name,
                            repo.first.description,
                            repo.first.language,
                            repo.first.stargazersCount
                    )
                }

            }
            is OwnerStargazerViewHolder -> {

            }
        }
    }

    override fun getItemCount(): Int =repositories.size * 2

    override fun getItemViewType(position: Int): Int = position % 2




}

