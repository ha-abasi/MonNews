package ir.hamedabasi.android.kotlin.compose.monews.retrofit

import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.NewsList
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // https://newsapi.org/v2/

    //
    @GET("top-headlines?country=us&category=business&apiKey={api_key}")
    suspend fun getNewsList(@Path("api_key") apiKey: String) : NewsList

}