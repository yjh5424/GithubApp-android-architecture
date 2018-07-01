package com.yjh.project.commitprogress.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.yjh.project.commitprogress.R.string.github_redirect_url
import com.yjh.project.commitprogress.di.app.App


class RedirectedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var uri=intent.data

        if (uri != null && uri.toString().startsWith(App.redirect_uri)) {

            val intent = Intent(this, LoginActivity::class.java)

            intent.putExtra("code", uri.getQueryParameter("code"))
            intent.putExtra("state", uri.getQueryParameter("state"))

            startActivity(intent)
            finish()
        }
    }
}
