package com.myapp.kotlinfirstapp


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

// ViewPagerAdapter is extends with FragmentPagerAdapter and implemented these methods getItem(),getcount(),getPageTitle()
class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val COUNT = 2;
    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = TestFragment();
            1 -> fragment = TestFragment();
        }
        return fragment;
    }

    // it return the count of fragments
    override fun getCount(): Int {
        return COUNT
    }

    // set title to the fragment
    override fun getPageTitle(position: Int): CharSequence {
        var title: String? = null
        when (position) {
            0 -> title = "First"
            1 -> title = "Second"
            else -> title = "Second"
        }
        return title
    }

}

