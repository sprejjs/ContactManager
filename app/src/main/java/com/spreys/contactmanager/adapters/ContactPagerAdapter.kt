package com.spreys.contactmanager.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.spreys.contactmanager.data.Contact
import com.spreys.contactmanager.fragments.ContactGridFragment
import com.spreys.contactmanager.fragments.ContactListFragment

class ContactPagerAdapter(fm: FragmentManager, private val contacts: ArrayList<Contact>): FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment {

        return if (position == 0) {
            ContactListFragment.newInstance(contacts)
        } else {
            ContactGridFragment.newInstance(contacts)
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0) {
            "List"
        } else {
            "Table"
        }
    }

}