package com.shivesh.simplecontactapp.thirtydaysofkotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shivesh.simplecontactapp.thirtydaysofkotlin.db.dao.MessageDao
import com.shivesh.simplecontactapp.thirtydaysofkotlin.models.Message

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
const val MESSAGE = "Message"
@Database(entities = [Message::class], version = AppDatabase.DATABASE_VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    //Dao interfaces
    abstract fun getMessageDao(): MessageDao

    companion object {
        const val DATABASE_NAME = "simpleContact"
        // Table Names
        const val DATABASE_VERSION = 1
        fun newInstance(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}