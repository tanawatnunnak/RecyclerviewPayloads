package com.tanawatnunnak.recyclerviewpayload.adapter

import androidx.recyclerview.widget.DiffUtil
import com.tanawatnunnak.recyclerviewpayload.model.NewsModel

class NewsDiffUtil : DiffUtil.ItemCallback<NewsModel>() {
    override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: NewsModel, newItem: NewsModel): Any? {
        return if (oldItem.isFavorite != newItem.isFavorite) {
            NewsAdapterPayload.FAVORITE_CHANGE
        } else {
            null
        }
    }
}