package ir.hamedabasi.android.kotlin.compose.monews.retrofit.models

data class NewsList(
    val status: String,
    val totalResults: String,
    val articles: List<Article>,
)
