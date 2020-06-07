package com.shivesh.simplecontactapp.thirtydaysofkotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
data class Contact(@SerializedName("id") @Expose var id: Int = 0, @SerializedName("firstName") @Expose val firstName: String?, @SerializedName("lastName") @Expose val lastName: String?, @SerializedName("phone") @Expose val phone: String?)