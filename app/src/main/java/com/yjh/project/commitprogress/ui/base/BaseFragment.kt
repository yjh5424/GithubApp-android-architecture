package com.yjh.project.commitprogress.ui.base

import android.net.Uri
import android.support.v4.app.Fragment
import com.yjh.project.commitprogress.presenter.base.BaseUserActionsListener

open class BaseFragment<out P : BaseUserActionsListener> : Fragment() {
    open val presenter : P? = null

    fun stringToUri(str: String) : Uri = Uri.parse(str)

}