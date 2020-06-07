package com.shivesh.simplecontactapp.thirtydaysofkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Message
import kotlinx.android.synthetic.main.item_message.view.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class MessagesAdapter(context: Context) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {
    private lateinit var messagesList: ArrayList<Message>

    fun setData(messages: ArrayList<Message>) {
        this.messagesList.clear()
        messagesList.addAll(messages)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesAdapter.MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_message, parent, false))
    }

    override fun getItemCount(): Int = messagesList.size

    override fun onBindViewHolder(holder: MessagesAdapter.MessageViewHolder, position: Int) {
        holder.itemView.txvContactName.text = messagesList[position].contactName
        holder.itemView.txvMsgTime.text = messagesList[position].timestamp.toString()
        holder.itemView.txvOtp.text = messagesList[position].msgTxt
    }

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}