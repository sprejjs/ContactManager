package com.spreys.contactmanager

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val contacts = MockDataGenerator.getMockContacts(50)
        pager.adapter = ContactPagerAdapter(supportFragmentManager, contacts)
    }
}