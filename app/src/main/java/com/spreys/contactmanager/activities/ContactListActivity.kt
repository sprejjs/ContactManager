package com.spreys.contactmanager.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.spreys.contactmanager.adapters.ContactPagerAdapter
import com.spreys.contactmanager.MockDataGenerator
import com.spreys.contactmanager.R
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val contacts = MockDataGenerator.getMockContacts(50)
        pager.adapter = ContactPagerAdapter(supportFragmentManager, contacts)
    }
}