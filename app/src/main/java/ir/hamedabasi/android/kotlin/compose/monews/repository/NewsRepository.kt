package ir.hamedabasi.android.kotlin.compose.monews.repository

import ir.hamedabasi.android.kotlin.compose.monews.retrofit.ApiService
import ir.hamedabasi.android.kotlin.compose.monews.retrofit.RetrofitInstance
import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.NewsList

class NewsRepository {

    private val apiService: ApiService = RetrofitInstance.api

    suspend fun getNews(apiKey: String): NewsList{
        return apiService.getNewsList("us", apiKey) // for united states
    }
}