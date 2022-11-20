package com.tanawatnunnak.recyclerviewpayload.model

data class NewsModel(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val description: String,
    var isFavorite: Boolean = false
)
