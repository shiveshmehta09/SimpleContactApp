package com.shivesh.simplecontactapp.thirtydaysofkotlin.interfaces

import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Message

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
interface MessageTaskListener {
    fun onDataFetched(messages: MutableList<Message>?)
}