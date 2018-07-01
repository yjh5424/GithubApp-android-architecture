package com.yjh.project.commitprogress.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.login.LoginContract
import com.yjh.project.commitprogress.presenter.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() , LoginContract.View{

    lateinit var userActionListener: LoginContract.UserActionListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userActionListener=LoginPresenter(this)

        login_button.setOnClickListener {
            userActionListener.loginWithGithub()
        }
    }

    override fun moveMainActivity() {
        startActivity(this,MainActivity::class.java)
    }
}
