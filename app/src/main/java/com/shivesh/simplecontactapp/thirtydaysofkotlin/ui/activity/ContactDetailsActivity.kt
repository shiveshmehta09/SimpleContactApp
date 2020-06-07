package com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.activity

import android.content.Intent
import android.os.Bundle
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.base.BaseActivity
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.CONTACT_NAME
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.CONTACT_NUMBER
import kotlinx.android.synthetic.main.activity_contact_details.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class ContactDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        setupToolbar(toolbar, "Contact Details", null)

        intent?.let { intnt ->
            txvContactName.text = intnt.getStringExtra(CONTACT_NAME)
            txvContactNumber.text = intnt.getStringExtra(CONTACT_NUMBER)
        }

        txvSendSms.setOnClickListener {
            val intent = Intent(this, SendMessageActivity::class.java)
            intent.putExtra(CONTACT_NAME, getIntent().getStringExtra(CONTACT_NAME))
            intent.putExtra(CONTACT_NUMBER, getIntent().getStringExtra(CONTACT_NUMBER))
            startActivity(intent)
        }
    }
}