package ir.hamedabasi.android.kotlin.compose.monews.retrofit.models

import java.util.Date

data class Article(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: Date?,
    val content: String?,
)
