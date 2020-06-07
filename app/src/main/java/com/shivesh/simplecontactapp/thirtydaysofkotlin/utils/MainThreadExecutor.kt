package com.shivesh.simplecontactapp.thirtydaysofkotlin.utils

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class MainThreadExecutor : Executor {
    private val handler = Handler(Looper.getMainLooper())
    override fun execute(runnable: Runnable) {
        handler.post(runnable)
    }
}