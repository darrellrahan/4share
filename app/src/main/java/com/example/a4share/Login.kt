package com.example.a4share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        supportActionBar?.hide()

        val toRegisterBtn: ImageView = findViewById(R.id.to_register)
        val toHomeBtn: Button = findViewById(R.id.to_home)

        toRegisterBtn.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
            finish()
        }

        toHomeBtn.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }
    }
}