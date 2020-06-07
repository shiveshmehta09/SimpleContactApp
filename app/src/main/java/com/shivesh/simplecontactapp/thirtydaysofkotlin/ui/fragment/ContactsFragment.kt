package com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.shivesh.simplecontactapp.thirtydaysofkotlin.R
import com.shivesh.simplecontactapp.thirtydaysofkotlin.adapter.ContactsAdapter
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Contact
import com.shivesh.simplecontactapp.thirtydaysofkotlin.ui.activity.ContactDetailsActivity
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.AppUtils
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.CONTACT_NAME
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.CONTACT_NUMBER
import kotlinx.android.synthetic.main.fragment_contacts.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class ContactsFragment : Fragment(), ContactsAdapter.OnContactClickListener {
    private var mListener: OnContactsFragmentInteractionListener? = null
    private lateinit var adapter: ContactsAdapter

    override fun onContactSelected(contact: Contact) {
        val intent = Intent(context, ContactDetailsActivity::class.java)
        intent.putExtra(CONTACT_NAME, contact.firstName + " " + contact.lastName)
        intent.putExtra(CONTACT_NUMBER, contact.phone)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ContactsAdapter(context, this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvContacts?.layoutManager = LinearLayoutManager(context)

        if (::adapter.isInitialized) {
            rvContacts?.adapter = adapter
        }
        loadData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnContactsFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    interface OnContactsFragmentInteractionListener {
        // TODO: Update argument type and name
    }

    private fun loadData() {
        context?.let {
            val jsonString: String = AppUtils.getContactsJson(it)
            val gson = GsonBuilder().create()
            val contacts = gson.fromJson<ArrayList<Contact>>(jsonString, object : TypeToken<ArrayList<Contact?>?>() {}.type)
            if (contacts != null && contacts.isNotEmpty()) {
                adapter.setData(contacts)
            }
        }
    }

    companion object {
        fun newInstance(): ContactsFragment {
            val fragment = ContactsFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}