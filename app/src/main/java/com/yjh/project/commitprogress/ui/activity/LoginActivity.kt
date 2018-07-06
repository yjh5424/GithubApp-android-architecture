package com.yjh.project.commitprogress.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.domain.model.AccessToken
import com.yjh.project.commitprogress.presenter.login.LoginContract
import com.yjh.project.commitprogress.presenter.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.HttpUrl


class LoginActivity : BaseActivity() , LoginContract.View{


    lateinit var userActionListener: LoginContract.UserActionListener
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userActionListener=LoginPresenter(this)
        mAuth= FirebaseAuth.getInstance()

        login_button.setOnClickListener {
            //github 웹뷰에서 로그인후 token 값 얻어야함
            userActionListener.loadGithubWebView()
        }
    }

    override fun moveGithubWebView(okHttpUrl: HttpUrl) {
        Intent(Intent.ACTION_VIEW, Uri.parse(okHttpUrl.toString())).let {
            startActivity(it)
            startActivityForResult(it,100)
        }
    }

    override fun onResume() {
        super.onResume()

        val code = intent!!.getStringExtra("code")
        val state = intent!!.getStringExtra("state")

        if (code != null && state != null) {
            Log.d("RedirectedActivity", "code != null && state != null")
            userActionListener.loadGithubToken(
                mAuth,
                code,
                state
            )
        }
    }

    override fun moveMainActivity() {
        startActivity(this,MainActivity::class.java)
    }
}
