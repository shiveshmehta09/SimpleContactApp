package com.shivesh.simplecontactapp.thirtydaysofkotlin.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shivesh.simplecontactapp.thirtydaysofkotlin.db.MESSAGE
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Message

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
@Dao
interface MessageDao {

    @Query("SELECT * FROM $MESSAGE")
    fun getMessage(): MutableList<Message>?

    @Insert
    fun insertMessage(message: Message?)
}