package com.example.yunjunghyeon.demoapp_mvvm.ui.main

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import com.example.yunjunghyeon.demoapp_mvvm.R
import kotlinx.android.synthetic.main.activity_main.view.*


class MainViewHolder(
        parent : ViewGroup
) : RecyclerView.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)){

    private val repoNameTextView = itemView.findViewById<TextView>(R.id.name)
    private val repoDescTextView = itemView.findViewById<TextView>(R.id.desc)
    private val repoStarTextView = itemView.findViewById<TextView>(R.id.star)
    private val repoLanguageTextView = itemView.findViewById<TextView>(R.id.language)

    fun bindTo(repoName: String, repoDesc: String?, language: String?, repoStar: Int) {
        repoNameTextView.text = repoName
        repoDescTextView.text = repoDesc ?: ""
        repoStarTextView.text = repoStar.toString()
        repoLanguageTextView.text = language ?: ""

        itemView.setOnClickListener{


        }
    }
}