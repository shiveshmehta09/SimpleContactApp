package com.shivesh.simplecontactapp.thirtydaysofkotlin.db

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}