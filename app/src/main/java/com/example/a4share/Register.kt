package com.example.a4share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        supportActionBar?.hide()

        val toLoginBtn: ImageView = findViewById(R.id.to_login)
        val toHomeBtn: Button = findViewById(R.id.to_home)

        toLoginBtn.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }

        toHomeBtn.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }
    }
}