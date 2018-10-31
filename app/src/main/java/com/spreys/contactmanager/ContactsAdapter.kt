package com.spreys.contactmanager

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_view.view.*

class ContactsAdapter(private val context: Context, private val contacts: List<Contact>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater
                        .from(context)
                        .inflate(R.layout.card_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]

        holder.itemView.name_text_view.text = contact.name
        holder.itemView.mobile_text_view.text = contact.mobile

        holder.itemView.setOnClickListener {
            val intent = Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra("contact", contact)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return this.contacts.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}