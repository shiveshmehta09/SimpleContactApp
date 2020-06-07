package com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.base.BaseActivity
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Message
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.AppUtils
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.CONTACT_NAME
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.CONTACT_NUMBER
import kotlinx.android.synthetic.main.activity_send_messages.*
import java.util.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class SendMessageActivity : BaseActivity() {
    private var messageToSend = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_messages)

        intent?.let {
            setupToolbar(toolbar, it.getStringExtra(CONTACT_NAME), intent.getStringExtra(CONTACT_NUMBER))
        }
        val generator = Random()
        val randomOtp = 100000 + generator.nextInt(900000)
        messageToSend = "Hi your OTP is : $randomOtp"

        edtMsg?.setText(messageToSend)
        imvSend?.setOnClickListener {
            sendMessage()
        }
    }

    private fun sendMessage() {
        progress.visibility = View.VISIBLE
        val from = "+12055574755"
        val to = "+919772059957"
        val data: MutableMap<String, String> = HashMap()
        data["From"] = from
        data["To"] = to
        data["Body"] = messageToSend

        saveDataInDb()
    }

    private fun saveDataInDb() {
        Toast.makeText(this@SendMessageActivity, "Sent successfully", Toast.LENGTH_SHORT)
            .show()
        val message = Message(timestamp = Date(), msgTxt = messageToSend, contactName = intent.getStringExtra(CONTACT_NAME))
        AppUtils.getAppExecutor()
            ?.getDiskIo()
            ?.execute {
                AppUtils.getAppDataBase(this@SendMessageActivity)
                    ?.getMessageDao()
                    ?.insertMessage(message)
            }
        progress.visibility = View.GONE
        finish()
    }
}