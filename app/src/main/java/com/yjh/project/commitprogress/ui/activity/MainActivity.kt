package com.yjh.project.commitprogress.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.omjoonkim.project.interviewtask.model.Person
import com.squareup.picasso.Picasso
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.main.MainContract
import com.yjh.project.commitprogress.presenter.main.MainPresenter
import com.yjh.project.commitprogress.ui.fragment.OwnerRepoFragment
import com.yjh.project.commitprogress.ui.fragment.SettingFragment
import com.yjh.project.commitprogress.ui.fragment.TeamRepoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , MainContract.View{

    lateinit var mActionsListener: MainContract.UserActionsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mActionsListener=MainPresenter(this)
        mActionsListener.loadProfile("yjh5424")

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,mActionsListener)
        tabLayout.setupWithViewPager(viewPager)


    }

    class ViewPagerAdapter(fragmentManager: FragmentManager,mainPresenter: MainContract.UserActionsListener) : FragmentPagerAdapter(fragmentManager) {
        private val fragments = listOf(
                "My Repository" to lazy {
                    OwnerRepoFragment.newInstance(mainPresenter)
                },
                "Team Repository" to lazy {
                    TeamRepoFragment.newInstance()
                },
                "Setting" to lazy {
                    SettingFragment.newInstance()
                }
        )

        override fun getPageTitle(position: Int): CharSequence? = fragments[position].first

        override fun getItem(position: Int): Fragment = fragments[position].second.value

        override fun getCount(): Int = fragments.size
    }

    override fun showProfile(person: Person) {
        Picasso.with(applicationContext).load(stringToUri(person.avatar)).into(avatar)
        name.text=person.name
        login.text=person.login
        location.text=person.location ?: ""
        email.text=person.email ?: ""
        team.text=person.company ?: ""
    }

}
