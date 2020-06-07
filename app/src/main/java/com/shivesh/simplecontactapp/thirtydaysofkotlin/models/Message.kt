package com.shivesh.simplecontactapp.thirtydaysofkotlin.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.TypeConverters
import com.shivesh.simplecontactapp.thirtydaysofkotlin.db.Converters
import java.util.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
@Entity
data class Message(var msgId: Int = 0, var msgTxt: String? = null, var contactName: String? = null, @TypeConverters(Converters::class) var timestamp: Date? = null) : Comparable<Message> {
    override fun compareTo(@NonNull message: Message): Int {
        return if (timestamp == null || message.timestamp == null) {
            0
        } else timestamp!!.compareTo(message.timestamp)
    }
}