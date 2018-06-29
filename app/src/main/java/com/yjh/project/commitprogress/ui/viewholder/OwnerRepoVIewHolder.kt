package com.yjh.project.commitprogress.ui.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.domain.Repository.GithubDataRepository


private class OwnerRepoVIewHolder(val parent: ViewGroup) : BaseViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_owner_repo,parent)) {

    private val repoImageView = itemView.findViewById<ImageView>(R.id.avatar)
    private val repoNameTextView = itemView.findViewById<TextView>(R.id.name)

    fun bindTo(imageUrl : String,repoName : String){
        Picasso.with(parent.context).load(stringToUri(imageUrl)).into(repoImageView)
        repoNameTextView.text=repoName
    }
}