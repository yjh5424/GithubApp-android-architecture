package com.yjh.project.commitprogress.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity

open class BaseActivity : AppCompatActivity(){

    fun stringToUri(str: String) : Uri = Uri.parse(str)

    fun <T> startActivity(activity: Activity,targetActivity: Class<T> ){
        Intent(activity.applicationContext,targetActivity).let {
            activity.startActivity(it)
            activity.finish()
        }
    }
}