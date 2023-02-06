package com.example.a4share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarouselHomeAdapter(private val questionList: ArrayList<String>, private val usernameList: ArrayList<String>, private val dateList: ArrayList<String>, private val answerList: ArrayList<String>, private val numOfLikesList: ArrayList<Int>) :
    RecyclerView.Adapter<CarouselHomeAdapter.CarouselItemViewHolder>() {

    inner class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val like: ImageView = view.findViewById(R.id.likeImg)
        val numOfLikes: TextView = view.findViewById(R.id.numOfLikesCarousel)
        var numOfLikes1: Int = 6
        var numOfLikes2: Int = 9
        var numOfLikes3: Int = 420
        var isLiked1: Boolean = false
        var isLiked2: Boolean = false
        var isLiked3: Boolean = false

        init {
            like.setOnClickListener {
                val position = adapterPosition
                like.setImageResource(R.drawable.liked)

                if (position == 0) {
                    isLiked1 = !isLiked1

                    if(isLiked1) {
                        numOfLikes1++
                        numOfLikes.text = numOfLikes1.toString()
                    } else {
                        like.setImageResource(R.drawable.like)
                        numOfLikes1--
                        numOfLikes.text = numOfLikes1.toString()
                    }
                }

                if (position == 1) {
                    isLiked2 = !isLiked2

                    if(isLiked2) {
                        numOfLikes2++
                        numOfLikes.text = numOfLikes2.toString()
                    } else {
                        like.setImageResource(R.drawable.like)
                        numOfLikes2--
                        numOfLikes.text = numOfLikes2.toString()
                    }
                }

                if (position == 2) {
                    isLiked3 = !isLiked3

                    if(isLiked3) {
                        numOfLikes3++
                        numOfLikes.text = numOfLikes3.toString()
                    } else {
                        like.setImageResource(R.drawable.like)
                        numOfLikes3--
                        numOfLikes.text = numOfLikes3.toString()
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_home, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val question = holder.itemView.findViewById<TextView>(R.id.question)
        val username = holder.itemView.findViewById<TextView>(R.id.username)
        val date = holder.itemView.findViewById<TextView>(R.id.date)
        val answer = holder.itemView.findViewById<TextView>(R.id.answer)
        val numOfLikes = holder.itemView.findViewById<TextView>(R.id.numOfLikesCarousel)

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