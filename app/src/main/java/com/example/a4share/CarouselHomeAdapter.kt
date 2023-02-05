package com.example.a4share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarouselHomeAdapter(private val questionList: ArrayList<String>, private val usernameList: ArrayList<String>, private val dateList: ArrayList<String>, private val answerList: ArrayList<String>, private val numOfLikesList: ArrayList<Int>) :
    RecyclerView.Adapter<CarouselHomeAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_home, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val question = holder.itemView.findViewById<TextView>(R.id.question)
        val username = holder.itemView.findViewById<TextView>(R.id.username)
        val date = holder.itemView.findViewById<TextView>(R.id.date)
        val answer = holder.itemView.findViewById<TextView>(R.id.answer)
        val numOfLikes = holder.itemView.findViewById<TextView>(R.id.numOfLikes)

        question.text = questionList[position]
        username.text = usernameList[position]
        date.text = dateList[position]
        answer.text = answerList[position]
        numOfLikes.text = numOfLikesList[position].toString()
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

}