package com.yjh.project.commitprogress.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract

class OwnerRepoViewHolder(val parent: ViewGroup,private val repositoryListener: OwnerRepoContract.OnRepositoryListener) : BaseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_owner_repo, parent, false)){

    private val repoNameTextView = itemView.findViewById<TextView>(R.id.name)
    private val repoDescTextView = itemView.findViewById<TextView>(R.id.desc)
    private val repoStarTextView = itemView.findViewById<TextView>(R.id.star)
    private val repoLanguageTextView = itemView.findViewById<TextView>(R.id.language)

    fun bindTo(repoName: String, repoDesc: String?, language: String?, repoStar: Int) {
        //Picasso.with(parent.context).load(stringToUri(imageUrl)).into(repoImageView)
        repoNameTextView.text = repoName
        repoDescTextView.text = repoDesc ?: ""
        repoStarTextView.text = repoStar.toString()
        repoLanguageTextView.text = language ?: ""

        itemView.setOnClickListener{
            repositoryListener.onRepositoryClick(repoName)
        }
    }
}