package com.spreys.contactmanager.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.spreys.contactmanager.Contact
import com.spreys.contactmanager.adapters.ContactsAdapter
import com.spreys.contactmanager.R
import kotlinx.android.synthetic.main.recycler_view.*

class ContactListFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.recycler_view, container, false)
    }

    companion object {
        val ARGS_CONTACTS = "arg_contacts"

        fun newInstance(contacts: ArrayList<Contact>): ContactListFragment {
            val myFragment = ContactListFragment()

            val args = Bundle()
            args.putParcelableArrayList(ARGS_CONTACTS, contacts)
            myFragment.arguments = args

            return myFragment
        }
    }



    override fun onResume() {
        super.onResume()

        val contacts = arguments?.getParcelableArrayList<Contact>(ARGS_CONTACTS)

        contacts?.let {
            recyclerView.adapter = ContactsAdapter(requireActivity(), it)
            recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        }
    }
}