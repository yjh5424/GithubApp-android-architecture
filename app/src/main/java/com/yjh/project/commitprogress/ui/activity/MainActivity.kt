package com.yjh.project.commitprogress.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yjh.project.commitprogress.R
import com.yjh.project.commitprogress.presenter.main.MainContract
import com.yjh.project.commitprogress.ui.base.BaseActivity
import com.yjh.project.commitprogress.ui.fragment.OwnerRepoFragment
import com.yjh.project.commitprogress.ui.fragment.SettingFragment
import com.yjh.project.commitprogress.ui.fragment.TeamRepoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , MainContract.View{
    override fun onActivityInject() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var userID : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userID=intent.getStringExtra("id")

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager,userID)
        tabLayout.setupWithViewPager(viewPager)


    }

    class ViewPagerAdapter(fragmentManager: FragmentManager,id : String) : FragmentPagerAdapter(fragmentManager) {
        private val fragments = listOf(
                "My Repository" to lazy {
                    OwnerRepoFragment.newInstance(id)
                },
                "Team Repository" to lazy {
                    TeamRepoFragment.newInstance()
                },
                "Setting" to lazy {
                    SettingFragment.newInstance()
                }
        )

        override fun getPageTitle(position: Int): CharSequence? = fragments[position].first

        override fun getItem(position: Int): Fragment = fragments[position].second.value as Fragment

        override fun getCount(): Int = fragments.size
    }

}
