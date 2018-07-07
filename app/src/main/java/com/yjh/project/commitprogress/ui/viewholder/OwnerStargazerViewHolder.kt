package com.yjh.project.commitprogress.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.omjoonkim.project.interviewtask.model.Person
import com.squareup.picasso.Picasso
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract

class OwnerStargazerViewHolder(val parent: ViewGroup, private val listener: OwnerRepoContract.OnViewHolderListener) : BaseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_owner_stargzer, parent, false)){

    private val stargazerImageView = itemView.findViewById<ImageView>(R.id.avatar)
    private val stargazerTextView = itemView.findViewById<TextView>(R.id.name)


    fun bindTo(person: Person?) {
        person?.let {
            stargazerTextView.text=person.name?: ""
            Picasso.with(parent.context).load(stringToUri(person.avatar)).into(stargazerImageView)
            itemView.setOnClickListener{
                listener.onStargazersClick(person!!)
            }
        }

    }
}