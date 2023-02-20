package com.example.sembako_v2

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a4share.R
import com.example.a4share.SingleChat
import kotlinx.android.synthetic.main.social_layout.view.*

class ChatRecyclerAdapter (private var nama: List<String>, private var chat: List<String>, private var time: List<String>) : RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemNama: TextView = itemView.findViewById(R.id.nama)
        val itemChat: TextView = itemView.findViewById(R.id.chat)
        val itemTime: TextView = itemView.findViewById(R.id.time)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val singleItemPage = Intent(itemView.context, SingleChat::class.java)
                singleItemPage.putExtra("username", nama[position])
                itemView.context.startActivity(singleItemPage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.single_chat, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemNama.text = nama[position]
        holder.itemChat.text = chat[position]
        holder.itemTime.text = time[position]
    }

    override fun getItemCount(): Int {
        return nama.size
    }

}