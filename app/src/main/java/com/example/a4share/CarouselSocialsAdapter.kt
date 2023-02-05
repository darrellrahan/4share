package com.example.a4share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarouselSocialsAdapter(private val namaList: ArrayList<String>, private val followersList: ArrayList<String>, private val jurusanList: ArrayList<String>, private val jawabanList: ArrayList<String>, private val pertanyaanList: ArrayList<String>) :
    RecyclerView.Adapter<CarouselSocialsAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel_socials, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        val nama = holder.itemView.findViewById<TextView>(R.id.nama)
        val followers = holder.itemView.findViewById<TextView>(R.id.followers)
        val jurusan = holder.itemView.findViewById<TextView>(R.id.jurusan)
        val jawaban = holder.itemView.findViewById<TextView>(R.id.jawaban)
        val pertanyaan = holder.itemView.findViewById<TextView>(R.id.pertanyaan)

        nama.text = namaList[position]
        followers.text = followersList[position]
        jurusan.text = jurusanList[position]
        jawaban.text = jawabanList[position]
        pertanyaan.text = pertanyaanList[position]
    }

    override fun getItemCount(): Int {
        return namaList.size
    }

}