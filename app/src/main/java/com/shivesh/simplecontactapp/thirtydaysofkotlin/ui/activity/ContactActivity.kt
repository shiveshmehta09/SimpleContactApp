package com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.activity

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.adapter.ViewPagerAdapter
import com.shivesh.simplecontactapp.thirtydaysofkotlin.base.BaseActivity
import com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.fragment.ContactsFragment
import kotlinx.android.synthetic.main.activity_contact.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class ContactActivity :BaseActivity(), ContactsFragment.OnContactsFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        tabLayout.addTab(tabLayout.newTab().setText(R.string.Contacts))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.Messages))
        val viewPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        viewPager.offscreenPageLimit = -1
        //        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}