package com.yjh.project.commitprogress.ui.viewholder

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View


open class BaseViewHolder(rootView : View) : RecyclerView.ViewHolder(rootView){

    fun stringToUri(str: String) : Uri = Uri.parse(str)
}
