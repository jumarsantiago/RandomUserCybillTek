package com.example.randomusercybilltek.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.randomusercybilltek.databinding.ItemPersonPreviewBinding
import com.example.randomusercybilltek.model.Results

class PersonAdapter : ListAdapter<Results, PersonAdapter.PersonViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val binding = ItemPersonPreviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PersonViewHolder(private val binding: ItemPersonPreviewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Results) {
            binding.tvFullName.text = buildString {
                append(person.first)
                append(" ")
                append(person.last)
            }
            binding.tvGender.text = person.gender
            binding.tvNationality.text = person.city
        }
    }
}

class PersonDiffCallback : DiffUtil.ItemCallback<Results>() {
    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem == newItem
    }
}
