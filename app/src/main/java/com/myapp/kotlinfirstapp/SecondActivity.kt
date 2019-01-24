package com.myapp.kotlinfirstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager);
        vpPager.adapter = adapter;
        tabs_main.setupWithViewPager(vpPager)
    }

}
