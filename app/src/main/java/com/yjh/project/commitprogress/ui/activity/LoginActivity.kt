package com.yjh.project.commitprogress.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.di.app.App
import com.yjh.project.commitprogress.presenter.login.LoginContract
import com.yjh.project.commitprogress.presenter.login.LoginPresenter
import com.yjh.project.commitprogress.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.HttpUrl
import javax.inject.Inject

class LoginActivity : BaseActivity() , LoginContract.View{

    @Inject
    lateinit var presenter: LoginPresenter

    private val mAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onActivityInject() {
        App.component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.attachView(this)
        init()
    }

    private fun init(){
        login_button.setOnClickListener {
            //github 웹뷰에서 로그인후 token 값 얻어야함
            presenter.loadGithubWebView()
        }
    }

    override fun onResume() {
        super.onResume()

        val code = intent!!.getStringExtra("code")
        val state = intent!!.getStringExtra("state")

        if (code != null && state != null) {
            Log.d("RedirectedActivity", "code != null && state != null")
            presenter.loadGithubToken(
                    mAuth,
                    code,
                    state
            )
        }
    }

    override fun moveGithubWebView(okHttpUrl: HttpUrl) {
        Intent(Intent.ACTION_VIEW, Uri.parse(okHttpUrl.toString())).let {
            startActivity(it)
            startActivityForResult(it,100)
        }
    }

    override fun moveMainActivity(id : String) {
        Intent(applicationContext,MainActivity::class.java).let {
            it.putExtra("id",id)
            startActivity(it)
            finish()
        }
    }

}
