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

    private val stargzerImageView = itemView.findViewById<ImageView>(R.id.avatar)
    private val stargzerTextView = itemView.findViewById<TextView>(R.id.name)


    fun bindTo(person: Person?) {
        person?.let {
            stargzerTextView.text=person.name?: ""
            Picasso.with(parent.context).load(stringToUri(person.avatar)).into(stargzerImageView)
            itemView.setOnClickListener{
                listener.onStargazersClick(person!!)
            }
        }

    }
}