package com.example.a4share

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class IntroSlider1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_slider1)

        supportActionBar?.hide()

        val nextBtn: ImageView = findViewById(R.id.slider1_next)

        nextBtn.setOnClickListener {
            val intent = Intent(this, IntroSlider2::class.java)
            startActivity(intent)
            finish()
        }
    }
}