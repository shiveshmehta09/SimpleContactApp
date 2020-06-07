package com.shivesh.simplecontactapp.thirtydaysofkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class ContactsAdapter(context: Context, private var contactClickListener: OnContactClickListener?) : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    private lateinit var contactList: ArrayList<Contact>

    fun setData(contacts: ArrayList<Contact>) {
        contactList.clear()
        contactList.addAll(contacts)
        notifyDataSetChanged()
    }

    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position > -1) {
                    contactClickListener?.onContactSelected(contactList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_contact, parent, false))
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.itemView.txvContactName.text = contactList[position].firstName + " " + contactList[position].lastName
    }

    interface OnContactClickListener {
        fun onContactSelected(contact: Contact)
    }
}