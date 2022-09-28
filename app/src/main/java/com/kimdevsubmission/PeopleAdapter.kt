package com.kimdevsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kimdevsubmission.databinding.ItemPeopleBinding

class PeopleAdapter (private val arrayListPeople: ArrayList<People>):
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){

    inner class PeopleViewHolder(private val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(people: People) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(people.avatar)
                    .apply(RequestOptions())
                    .into(foto)

                username.text = people.username
                nama.text = people.name
                lokasi.text = people.location
            }
            itemView.setOnClickListener {
                val kirimData = Intent(itemView.context, PeopleDetail::class.java)
                kirimData.putExtra(PeopleDetail.EXTRA_DATA, people)
                itemView.context.startActivity(kirimData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemPeopleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) = holder.bind(arrayListPeople[position])


    override fun getItemCount(): Int = arrayListPeople.size

}