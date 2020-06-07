package com.shivesh.simplecontactapp.thirtydaysofkotlin.utils

import java.util.concurrent.Executor

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
class AppExecutor(diskIo: Executor?, mainThread: Executor?) {
    private var diskIo: Executor? = null
    private var mainThread: Executor? = null

    init {
        this.diskIo = diskIo
        this.mainThread = mainThread
    }

    fun getDiskIo(): Executor? = diskIo

    fun getMainThread(): Executor? = mainThread
}