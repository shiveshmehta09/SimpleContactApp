package com.shivesh.simplecontactapp.thirtydaysofkotlin.utils

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
interface ApiInterface {
    @FormUrlEncoded
    @POST("Accounts/{ACCOUNT_SID}/SMS/Messages")
    fun sendMessage(@Path("ACCOUNT_SID") accountSId: String?, @Header("Authorization") signature: String?, @FieldMap metadata: Map<String?, String?>?): Call<ResponseBody?>?
}