package com.example.yunjunghyeon.demoapp_mvvm.ui.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Person
import com.example.yunjunghyeon.demoapp_mvvm.domain.model.Repo
import java.text.FieldPosition


class MainRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var repostories = mutableListOf<Pair<Repo,List<Person>>>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder = MainViewHolder(p0)

    override fun getItemCount(): Int = repostories.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as MainViewHolder).apply {
            bindTo(
                    repostories[position].first.name,
                    repostories[position].first.description,
                    repostories[position].first.language,
                    repostories[position].first.stargazersCount
            )
        }
    }

    fun setData(list : MutableList<Pair<Repo,List<Person>>>){
        this.repostories=list
        notifyDataSetChanged()
    }
}