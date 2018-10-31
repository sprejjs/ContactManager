package com.spreys.contactmanager.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contact_details.*
import android.content.Intent
import android.net.Uri
import com.spreys.contactmanager.Contact
import com.spreys.contactmanager.R


class ContactDetailsActivity: AppCompatActivity() {
    companion object {
        val EXTRA_CONTACT = "contact"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        val contact = intent.extras?.getParcelable(EXTRA_CONTACT) as Contact

        with (contact) {
            activity_details_name.text = this.name
            activity_details_mobile.text = this.mobile
            activity_details_landline.text = this.landline
            activity_details_email.text = this.email
        }

        activity_details_mobile.setOnClickListener {
            dialNumber(contact.mobile)
        }
        activity_details_landline.setOnClickListener {
            dialNumber(contact.landline)
        }
        activity_details_email.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", contact.email, null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello there!")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi ${contact.firstName},")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
    }

    private fun dialNumber(number: String?){
        with(number) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$this"))
            startActivity(intent)
        }
    }
}