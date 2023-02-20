package com.example.a4share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.single_chat_layout.*

class SingleChat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_chat_layout)

        supportActionBar?.hide()

        val username: String = intent.getStringExtra("username").toString()

        username_tv.text = username
    }
}