package com.spreys.contactmanager.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.spreys.contactmanager.R
import com.spreys.contactmanager.adapters.ContactPagerAdapter
import com.spreys.contactmanager.data.ContactsDatabase
import com.spreys.contactmanager.helpers.DoAsync
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        DoAsync(handler = {
            ContactsDatabase.getInstance(applicationContext)?.contactsDao()?.getAll()
        },
                callBack = { contacts ->
                    contacts?.let {
                        pager.adapter = ContactPagerAdapter(supportFragmentManager, ArrayList(contacts))
                    }
                })
    }
}