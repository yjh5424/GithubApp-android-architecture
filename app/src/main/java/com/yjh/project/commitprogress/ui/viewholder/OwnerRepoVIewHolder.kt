package com.yjh.project.commitprogress.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.yjh.project.commitprogress.R

class OwnerRepoViewHolder(val parent: ViewGroup) : BaseViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_owner_repo,parent,false)) {

    private val repoNameTextView = itemView.findViewById<TextView>(R.id.name)
    private val repoDescTextVuew = itemView.findViewById<TextView>(R.id.desc)
    private val repoStarTextView = itemView.findViewById<TextView>(R.id.star)

    fun bindTo(repoName : String,repoDesc : String, repoStar : Int){
        //Picasso.with(parent.context).load(stringToUri(imageUrl)).into(repoImageView)
        repoNameTextView.text=repoName
        repoDescTextVuew.text=repoDesc
        repoStarTextView.text=repoStar.toString()
    }
}