package com.yjh.project.commitprogress.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.omjoonkim.project.interviewtask.model.Person
import com.squareup.picasso.Picasso
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.ownerRepo.OwnerRepoContract

class OwnerStargazersViewHolder(val parent: ViewGroup, private val listener: OwnerRepoContract.OnViewHolderListener) : BaseViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_owner_stargzer, parent, false)){

    

    fun setList(people : List<Person>) {

    }
}