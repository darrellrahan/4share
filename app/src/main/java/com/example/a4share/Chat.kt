package com.example.a4share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sembako_v2.ChatRecyclerAdapter
import kotlinx.android.synthetic.main.chat.*

class Chat : AppCompatActivity() {
    private var namaList = mutableListOf<String>()
    private var chatList = mutableListOf<String>()
    private var timeList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat)

        supportActionBar?.hide()

        back.setOnClickListener {
            startActivity(Intent(this@Chat, Dashboard::class.java))
            finish()
        }

        postToList()

        recyclerView.layoutManager = LinearLayoutManager(this@Chat)
        recyclerView.adapter = ChatRecyclerAdapter(namaList, chatList, timeList)
    }

    private fun addToList(name: String, chat: String, time: String) {
        namaList.add(name)
        chatList.add(chat)
        timeList.add(time)
    }

    private fun postToList() {
        addToList("Aksa Adnan", "Hi kak aku Aksa Adnan, jadi gini ...", "13:12")
        addToList("Caden Bose", "Hi kak aku Caden Bose, jadi gini ...", "12:12")
        addToList("William Wijaya", "Hi kak aku William Wijaya, jadi gini ...", "11:12")
        addToList("Rizky Bilar", "Hi kak aku Rizky Bilar, jadi gini ...", "10:12")
        addToList("Lesti", "Hi kak aku Lesti, jadi gini ...", "9:12")
    }
}