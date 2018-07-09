package com.yjh.project.commitprogress.ui.base

import android.support.v4.app.Fragment
import com.yjh.project.commitprogress.presenter.base.BaseUserActionsListener
import com.yjh.project.commitprogress.ui.fragment.TeamRepoFragment

open class BaseFragment<out P : BaseUserActionsListener> : Fragment() {
    open val presenter : P? = null
}