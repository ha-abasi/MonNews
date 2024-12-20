package ir.hamedabasi.android.kotlin.compose.monews.retrofit.models

data class NewsList(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
)
