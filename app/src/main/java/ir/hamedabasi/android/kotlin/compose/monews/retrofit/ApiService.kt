package ir.hamedabasi.android.kotlin.compose.monews.retrofit

import ir.hamedabasi.android.kotlin.compose.monews.retrofit.models.NewsList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // https://newsapi.org/v2/

    @Headers("User-Agent: Google Chrome 120") // some api servers ignore retrofit
    @GET("top-headlines")
    suspend fun getNewsList(@Query("country") country : String, @Query("apiKey") apiKey : String) : NewsList

}