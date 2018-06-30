package com.yjh.project.commitprogress.ui.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    fun stringToUri(str: String) : Uri = Uri.parse(str)
}