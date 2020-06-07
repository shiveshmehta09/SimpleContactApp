package com.shivesh.simplecontactapp.thirtydaysofkotlin.repository

import android.content.Context
import com.shivesh.simplecontactapp.thirtydaysofkotlin.db.AppDatabase
import com.shivesh.simplecontactapp.thirtydaysofkotlin.db.dao.MessageDao
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.AppExecutor
import com.shivesh.simplecontactapp.thirtydaysofkotlin.utils.MainThreadExecutor
import java.util.concurrent.Executors

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class Repository(context: Context) {
    private lateinit var db: AppDatabase
    private lateinit var messageDao: MessageDao
    private lateinit var appExecutor: AppExecutor

    init {
        db = AppDatabase.newInstance(context)
        messageDao = db.getMessageDao()
        appExecutor = AppExecutor(Executors.newSingleThreadExecutor(), MainThreadExecutor())
    }

}