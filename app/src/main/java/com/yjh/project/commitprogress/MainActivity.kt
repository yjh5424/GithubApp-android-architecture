package com.yjh.project.commitprogress

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.yjh.project.commitprogress.ui.OwnerRepoFragment
import com.yjh.project.commitprogress.ui.TeamRepoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

    class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        private val fragments = listOf(
                "My Repository" to lazy {
                    OwnerRepoFragment.newInstance()
                },
                "Team Repository" to lazy {
                    TeamRepoFragment.newInstance()
                }
        )

        override fun getPageTitle(position: Int): CharSequence? = fragments[position].first

        override fun getItem(position: Int): Fragment = fragments[position].second.value

        override fun getCount(): Int = fragments.size
    }
}
