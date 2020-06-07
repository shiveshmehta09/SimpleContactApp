package com.shivesh.simplecontactapp.thirtydaysofkotlin.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Contact
import com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.fragment.ContactsFragment
import com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.fragment.MessagesFragment

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class ViewPagerAdapter(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ContactsFragment.newInstance()
            1 -> MessagesFragment.newInstance()
            else -> ContactsFragment.newInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}