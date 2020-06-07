package com.shivesh.simplecontactapp.thirtydaysofkotlin.utils

import android.content.Context
import com.shivesh.simplecontactapp.thirtydaysofkotlin.db.AppDatabase
import retrofit2.Retrofit
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.concurrent.Executors

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
const val CONTACT_NAME = "CONTACT_NAME"
const val CONTACT_NUMBER = "CONTACT_NUMBER"
class Apputils {
    companion object {
        fun getContactsJson(context: Context): String? {
            val json: String
            json = try {
                val inputStream = context.assets.open("ContactsData.json")
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                String(buffer, StandardCharsets.UTF_8)
            } catch (ex: IOException) {
                ex.printStackTrace()
                return null
            }
            return json
        }

        fun getRetrofitInterface(): ApiInterface? {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://api.twilio.com/2010-04-01/")
                .build()
            return retrofit.create(ApiInterface::class.java)
        }

        fun getAppExecutor(): AppExecutor? = AppExecutor(Executors.newSingleThreadExecutor(), MainThreadExecutor())

        fun getAppDataBase(context: Context?): AppDatabase? = AppDatabase.newInstance(context)
    }
}