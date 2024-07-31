package com.example.randomusercybilltek.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomusercybilltek.databinding.ItemPersonPreviewBinding
import com.example.randomusercybilltek.model.Results

class PersonAdapter(private val listener: OnPersonClickListener) : ListAdapter<Results, PersonAdapter.PersonViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = getItem(position)
        holder.bind(person)
        holder.itemView.setOnClickListener {
            listener.onPersonClick(person)
        }
    }

    class PersonViewHolder(private val binding: ItemPersonPreviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: Results) {
            binding.tvFullName.text = buildString {
                append(person.name?.first ?: "Unknown")
                append(" ")
                append(person.name?.last ?: "Unknown")
            }
            binding.tvGender.text = person.gender ?: "Unknown"
            binding.tvNationality.text = person.location?.city ?: "Unknown"
            Glide.with(binding.root.context)
                .load(person.picture?.large ?: person.picture?.medium)
                .into(binding.imgUser)
        }
    }
}

class PersonDiffCallback : DiffUtil.ItemCallback<Results>() {
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.UID == newItem.UID
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem == newItem
    }
}
