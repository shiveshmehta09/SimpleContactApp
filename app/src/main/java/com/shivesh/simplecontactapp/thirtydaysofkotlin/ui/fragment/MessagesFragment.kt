package com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.adapter.MessagesAdapter
import com.shivesh.simplecontactapp.thirtydaysofkotlin.interfaces.MessageTaskListener
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Message
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.AppUtils
import kotlinx.android.synthetic.main.fragment_messages.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class MessagesFragment : Fragment(), MessageTaskListener {
    private lateinit var adapter: MessagesAdapter

    companion object {
        fun newInstance(): MessagesFragment {
            val fragment = MessagesFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MessagesAdapter(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvContacts?.layoutManager = LinearLayoutManager(context)
        if(::adapter.isInitialized){
            rvContacts?.adapter = adapter
        }
        val getMessageTask = GetMessageTask(this)
        getMessageTask.execute(context)
    }

    override fun onDataFetched(messages: MutableList<Message>?) = adapter.setData(messages = messages)

    class GetMessageTask internal constructor(private val messageTaskListener: MessageTaskListener?) : AsyncTask<Context, Void?, MutableList<Message>?>() {
        override fun onPostExecute(messages: MutableList<Message>?) {
            super.onPostExecute(messages)
            messages?.sortedBy {
                it.timestamp
            }
            messageTaskListener?.onDataFetched(messages)
        }

        override fun doInBackground(vararg params: Context): MutableList<Message>? {
            return AppUtils.getAppDataBase(params[0])?.getMessageDao()?.getMessage()
        }
    }
}