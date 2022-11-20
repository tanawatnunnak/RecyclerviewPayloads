package com.tanawatnunnak.recyclerviewpayload.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tanawatnunnak.recyclerviewpayload.R
import com.tanawatnunnak.recyclerviewpayload.databinding.ItemNewsBinding
import com.tanawatnunnak.recyclerviewpayload.model.NewsModel

class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): NewsViewHolder {
            val binding =
                ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return NewsViewHolder(binding)
        }
    }


    fun bind(model: NewsModel) {
        binding.apply {
            Glide.with(binding.root.context)
                .load(model.imageUrl)
                .into(newsIv)
            setNewsFavorite(model.isFavorite)
            titleTv.text = model.title
            descriptionTv.text = model.description
        }
    }

    fun bindFavorite(isFavorite: Boolean) {
        setNewsFavorite(isFavorite)
    }

    private fun setNewsFavorite(isFavorite: Boolean) {
        val icon = when {
            isFavorite -> R.drawable.ic_favorite
            else -> R.drawable.ic_unfavorite
        }
        binding.favoriteIv.setImageResource(icon)
    }

}