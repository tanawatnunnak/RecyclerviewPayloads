package com.tanawatnunnak.recyclerviewpayload.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.tanawatnunnak.recyclerviewpayload.model.NewsModel

open class NewsAdapter(
    private val onFavoriteClickListener: (model: NewsModel, isFavorite: Boolean) -> Unit
) : ListAdapter<NewsModel, NewsViewHolder>(NewsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.create(parent).apply {
            binding.favoriteIv.setOnClickListener {
                val model = getItem(adapterPosition)
                onFavoriteClickListener(
                    model,
                    !model.isFavorite
                )
            }
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        when {
            payloads.contains(NewsAdapterPayload.FAVORITE_CHANGE) -> holder.bindFavorite(getItem(position).isFavorite)
            else -> super.onBindViewHolder(holder, position, payloads)
        }
    }
}