package com.yjh.project.commitprogress.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.yjh.project.commitprogress.R
import kotlinx.android.synthetic.main.activity_owner_repository_detail.*

class OwnerRepositoryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_repository_detail)


        repo_web_view.loadUrl("https://github.com/yjh5424/CommitProgress")
    }
}
