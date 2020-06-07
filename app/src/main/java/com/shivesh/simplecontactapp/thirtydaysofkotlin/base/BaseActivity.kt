package com.shivesh.simplecontactapp.thirtydaysofkotlin.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * Created by Shivesh K Mehta on 07/06/20.
 * Version 2.0 KTX
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setupToolbar(toolbar: Toolbar?, title: String?, subTitle: String?) {
        toolbar?.let {
            setSupportActionBar(toolbar)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        title?.let {
            supportActionBar?.title = it
        }

        subTitle?.let {
            supportActionBar?.subtitle = it
        }
        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}